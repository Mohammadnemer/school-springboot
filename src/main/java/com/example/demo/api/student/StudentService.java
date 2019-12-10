//package com.example.demo.api.student;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import com.example.demo.exception.ResourceNotFoundException;
//
//@Service
//public class StudentService {
//	@Autowired
//	StudentRepository studentRepository;
//
//	public List<Student> getAllStudents(){
//		return studentRepository.findAll();
//	}
//
//	public Student getStudent(Long id){
//		return studentRepository.findById(id).orElseThrow(
//				()-> new ResourceNotFoundException("Student", "id", id));
//	}
//
//	public Student createStudent(Student student) {
//		return studentRepository.save(student);
//	}
//
//	public Student updateStudent(Student student , long id) {
//		Student studentId = studentRepository.findById(id).orElseThrow(
//				()-> new ResourceNotFoundException("Student", "id", id));
//
//		studentId.setAddress(student.getAddress());
//		studentId.setEmail(student.getEmail());
//		studentId.setFirstName(student.getFirstName());
//		studentId.setLastName(student.getLastName());
//		studentId.setAge(student.getAge());
//
//		return studentRepository.save(studentId);
//	}
//	public ResponseEntity<?> deleteStudent(long id) {
//		Student studentId = studentRepository.findById(id).orElseThrow(
//				()-> new ResourceNotFoundException("Student", "id", id));
//
//
//	  studentRepository.delete(studentId);
//	  return ResponseEntity.ok().build();
//	}
//}
