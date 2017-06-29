package com.chinasofti.dao;

import java.util.List;

import com.chinasofti.entity.Student;

public interface StudentDao {
	public void addStudent(Student student);
	
	public List<Student> getStudetList(Student student);
	
	public void deleteStudent(Student student);
	
	public Student getStudent(Student student);
	
	public void updateStudent(Student student);

}
