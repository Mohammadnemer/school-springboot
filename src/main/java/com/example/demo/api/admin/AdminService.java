package com.example.demo.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public List<Admin> getAllAdmins(){
		return adminRepository.findAll();
	}
	
	public Admin getAdmin(Long id){
		return adminRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Admin", "id", id));
	}
	
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin updateAdmin(Admin admin , long id) {
		Admin adminId = adminRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Admin", "id", id));
		
		adminId.setAddress(admin.getAddress());
		adminId.setEmail(admin.getEmail());
		adminId.setFirstName(admin.getFirstName());
		adminId.setLastName(admin.getLastName());
		adminId.setPhone(admin.getPhone());
		adminId.setUsername(admin.getUsername());
		
		return adminRepository.save(adminId);
	}
	public ResponseEntity<?> deleteAdmin(long id) {
		Admin adminId = adminRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Admin", "id", id));
		
		
	  adminRepository.delete(adminId);
	  return ResponseEntity.ok().build();
	}
	public boolean login(Admin adminDetails) {
		
		List<Admin> admin= getAllAdmins();
		boolean  check = false;
		for(int i=0;i<admin.size();i++) {
			if(admin.get(i).getUsername().equals(adminDetails.getUsername()) && admin.get(i).getPassword().equals(adminDetails.getPassword())) {
				 check = true; 
			}
		}
		return check;
	}
}
