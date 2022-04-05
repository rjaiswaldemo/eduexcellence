package com.edu.excellence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.excellence.entity.Student;
import com.edu.excellence.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping
	Integer saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping
	public List<Student> fetchAllStudent(){
		return studentService.getStudentList();
	}
	
	@GetMapping("/{Id}")
	public Student fetchSingleStudent(@PathVariable("Id") Integer studentId) {
		return studentService.getStudent(studentId);
	}
	
	@DeleteMapping("/{Id}")
    public String deleteDepartmentById(@PathVariable("Id") Integer studentId)
    {
		studentService.deleteStudent(studentId);
        return "Student has been deleted Successfully";
    }
	
	@PutMapping("/{Id}")
    public Student updateDepartment(@RequestBody Student student, @PathVariable("Id") Integer studetnId)
    {
        return studentService.updateStudent(student, studetnId);
    }

}
