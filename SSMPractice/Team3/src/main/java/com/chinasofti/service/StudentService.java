package com.chinasofti.service;

import java.util.List;

import com.chinasofti.entity.Student;

public interface StudentService {
	public void addStudent(Student student);

	public List<Student> getStudentList(Student student);
	
	public Long getCount(Student student);


	public void deleteStudent(Student student);

	public Student getStudent(Student student);

	public void updateStudent(Student student);
	
	public boolean validate(Student student);

}
