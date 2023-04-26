package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studService;
	
	@GetMapping(value="fetchStudents")
	public List<Student> getAllStudents()
	{
		List<Student> studList=studService.getAllStudents();
		return studList;
	}
	@PostMapping(value="/saveStudent")
	public Student saveStudent(@RequestBody Student s)
	{
		return studService.saveStudent(s); 
	}
	
	@PutMapping(value="/updateStudent")
	public Student updateStudent(@RequestBody Student s)
	{
		return studService.saveStudent(s); 
	}
	
	//http://localhost:8080/deleteStudent/1003
	@DeleteMapping(value="/deleteStudent/{rno}")
	public String deleteStudent(@PathVariable("rno") int regno)
	{
		studService.deleteStudent(regno);
		return "deleted";
	}
	@GetMapping(value="/getStudent/{rno}")
	public Student getStudent(@PathVariable("rno") int regno)
	{
		return studService.getStudent(regno);
	}
	//pagination and sorting//
	
	//http://localhost:8080/sortStudents/name
	
	@GetMapping("/sortStudents/{field}")
	public List<Student>sortStudents(@PathVariable String field)
	{
		return studService.sortStudents(field);
	}

}
