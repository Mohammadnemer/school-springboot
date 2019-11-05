package com.example.demo.api.teacher;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class TeacherController {
    @GetMapping("/teacher")
    public List<String> getAllAdmins(){
        List<String> s =  new ArrayList<>();
        s.add("ubuntu");
        s.add("Docker");
        s.add("java");
        return s;
    }

}
