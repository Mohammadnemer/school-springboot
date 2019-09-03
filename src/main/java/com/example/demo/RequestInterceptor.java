package com.example.demo;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getMethod() != null && request.getMethod().toUpperCase().equals("OPTIONS"))
            return true;
		String url = getResMappingKey(request);
		if(url != null && url.equals("api/login"))
			return true;
		String auth = request.getHeader("Authorization");
		if(auth == null || auth.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
		if(auth.startsWith("Basic "))
			auth = auth.substring(6);
		auth = new String(Base64Utils.decode(auth.getBytes()));
		StringTokenizer tokenizer = new StringTokenizer(auth, ":");
		if(tokenizer.countTokens() != 2) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();
		
		return true;
	}
	
	private String getResMappingKey(HttpServletRequest request) {
		String resMappingKey = null;
		StringBuffer requestURL = request.getRequestURL();
		if (requestURL != null) {
			int index = -1;
			for (int i = requestURL.length() - 1, cnt = 0; i > -1; i--)
				if (requestURL.charAt(i) == '/' && ++cnt == 2) {
					index = i;
					break;
				}
			resMappingKey = requestURL.substring(++index);
		}
		return resMappingKey;
	}

}
