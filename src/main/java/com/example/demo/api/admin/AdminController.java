package com.example.demo.api.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	@GetMapping("/admins/{id}")
	public Admin getAdmin(@PathVariable long id) {
		return adminService.getAdmin(id);
	}
	
	@PostMapping("/admins")
	public Admin createAdmin(@Valid @RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}
	
	@PutMapping("/admins/{id}")
	public Admin updateAdmin(@Valid @RequestBody Admin admin , @PathVariable long id) {
		return adminService.updateAdmin(admin, id);
	}
	
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable long id){
		return adminService.deleteAdmin(id);
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody Admin admin) {
		return adminService.login(admin);
	}
}
