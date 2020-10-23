package com.episen.sca.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("adduser")
	public Student createOrUpdate(@RequestBody Student order){
		return studentRepository.save(order);
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
