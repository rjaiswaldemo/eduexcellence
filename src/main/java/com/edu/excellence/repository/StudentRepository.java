package com.edu.excellence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.excellence.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
