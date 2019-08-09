package com.example.demo.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
}
