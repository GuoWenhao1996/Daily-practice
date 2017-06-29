package com.chinasofti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.ClazzDao;
import com.chinasofti.dao.StudentDao;
import com.chinasofti.entity.Clazz;
import com.chinasofti.entity.Student;
import com.chinasofti.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ClazzDao clazzDao;

	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	public List<Student> getStudentList(Student student) {
		if(student.getName()!=null&& !student.getName().equals("")){
			student.setName("%"+student.getName()+"%");
		}
		List<Student> students=studentDao.getStudetList(student);
		for(Student s:students){
			Integer id=s.getClazz().getId();
			Clazz clazz=clazzDao.getClazzByid(id);
			s.setClazz(clazz);
		}
		return students;
	}

	public void deleteStudent(Student student) {
		studentDao.deleteStudent(student);
	}

	public Student getStudent(Student student) {
		return studentDao.getStudent(student);
	}

	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

}
