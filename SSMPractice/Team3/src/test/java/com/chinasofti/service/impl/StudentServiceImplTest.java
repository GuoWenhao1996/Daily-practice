package com.chinasofti.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasofti.entity.Student;
import com.chinasofti.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentServiceImplTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setName("哈哈哈");
		
		studentService.addStudent(student);
	}
}
