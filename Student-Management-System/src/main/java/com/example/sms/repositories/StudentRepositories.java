package com.example.sms.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;

public interface StudentRepositories extends JpaRepository<Student, Integer> {
	
	public int countByCourse(String course);  
	
	
	//derived method
	public List<Student> findByMarksGreaterThan(int marks);
	public List<Student> findByNameStartingWith(String name);

}
