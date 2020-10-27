package com.episen.sca.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.episen.sca.model.Student;
import com.episen.sca.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	public StudentController() {
	}
	@GetMapping("students")
	public List<Student> getStudents(){
		return this.studentRepository.findAll();
	}

	@PostMapping("addstudent")
	public Student createStudent(@RequestBody Student s){
		return studentRepository.save(s);
	}

	@PutMapping("editstudent/{id}")
	public Student updateStudent(@PathVariable("id") Long studentId, @RequestBody Student s){
		if(studentRepository.findById(studentId).isPresent()){
			Student s2 = studentRepository.findById(studentId).get();
			s2.setFirstname(s.getFirstname());
			s2.setLastname(s.getLastname());
			s2.setEmail(s.getEmail());
			s2.setAge(s.getAge());
			s2.setGender(s.getGender());
			s2.setGroups(s.getGroups());
			s2.setRedoublant(s.isRedoublant());
			Student updatedStudent = studentRepository.save(s2);
			return updatedStudent;
		}else{return null;}
	}

	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable("id") Long studentId) {
		studentRepository.delete(studentRepository.findById(studentId).orElse(null));
		// if every thing went well
		return true;
	}

	@GetMapping("student/{id}")
	public Student findById(@PathVariable("id")Long id) {
		return studentRepository.findById(id).orElse(null);
	}
}
