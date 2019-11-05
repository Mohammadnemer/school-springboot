package com.example.demo.api.teacher;

import com.example.demo.api.admin.Admin;
import com.example.demo.api.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class TeacherController {
    @RequestMapping("/api")
    @GetMapping("/teacher")
    public List<String> getAllAdmins(){
        List<String> s =  new ArrayList<>();
        s.add("Hello");
        s.add("Docker");
        s.add("with java");
        return s;
    }

}
