package com.edu.excellence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.excellence.entity.Student;
import com.edu.excellence.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Transactional(rollbackOn = Exception.class)
	public Integer saveStudent(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent.getStudentId();
	}
	
	public List<Student> getStudentList(){
		return studentRepository.findAll();
	}
	
	public Student getStudent(Integer studentId) {
		return studentRepository.findById(studentId).get();
	}
	
	public void deleteStudent(Integer studentId) {
		studentRepository.deleteById(studentId);
	}
	
	public Student updateStudent(Student student, Integer studentId) {
		Student updateStudent = studentRepository.findById(studentId).get();
		updateStudent.setStudentClass(student.getStudentClass());
		updateStudent.setStudentDOB(student.getStudentDOB());
		updateStudent.setStudentName(student.getStudentName());
		return studentRepository.save(updateStudent);
		
	}

}
