package com.chinasofti.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasofti.entity.Clazz;
import com.chinasofti.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentDaoTest {

	@Autowired
	private StudentDao studentDao;

	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setName("刘翠芳略略略");
		studentDao.addStudent(student);
	}

	@Test
	public void testGetStudentList() {
		Student student=new Student();
		student.setName("%翠%");
		Clazz clazz=new Clazz();
		clazz.setId(3);
		student.setClazz(clazz);
		List<Student> students = studentDao.getStudetList(student);
		for (Student s : students) {
			System.out.println(s.getName());
		}
	}
	
	@Test
	public void testDeleteStudent(){
		Student s=new Student();
		s.setId(11);
		studentDao.deleteStudent(s);
	}
	
	@Test
	public void testGetStudent(){
		Student s=new Student();
		s.setId(2);		
		Student pstudet=studentDao.getStudent(s);
		System.out.println(pstudet.getId());
		System.out.println(pstudet.getName());
		System.out.println(pstudet.getPassword());
	}
	
	@Test
	public void testUpdate(){
		Student s=new Student();
		s.setId(5);
		s.setName("啊啊啊aaa");
		s.setPassword("111");
		studentDao.updateStudent(s);
	}
}
