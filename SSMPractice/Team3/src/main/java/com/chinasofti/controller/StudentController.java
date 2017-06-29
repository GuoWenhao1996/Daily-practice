package com.chinasofti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.entity.Clazz;
import com.chinasofti.entity.Student;
import com.chinasofti.service.ClazzService;
import com.chinasofti.service.StudentService;

@Controller
@RequestMapping("/student/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ClazzService clazzService;

	@RequestMapping("login.do")
	public String login(Student student, Model model) {
		System.out.println(student.getName());
		System.out.println(student.getPassword());
		System.out.println("学生登录");
		model.addAttribute("stu", student);
		return "student/student_index";
	}

	@RequestMapping("add.do")
	public String add(Student student, Model model) {

		studentService.addStudent(student);
		return list(new Student(), model);
	}

	@RequestMapping("list.do")
	public String list(Student student, Model model) {
		List<Student> students = studentService.getStudentList(student);
		model.addAttribute("students", students);
		List<Clazz> clazzes = clazzService.getClazzList();
		model.addAttribute("clazzes", clazzes);
		return "index";
	}

	@RequestMapping("delete.do")
	public String delete(Student student, Model model) {
		studentService.deleteStudent(student);
		return list(new Student(), model);
	}

	@RequestMapping("loadupdate.do")
	public String loadUpdate(Student student, Model model) {
		Student pstudent = studentService.getStudent(student);
		model.addAttribute("student", pstudent);
		List<Clazz> clazzes = clazzService.getClazzList();
		model.addAttribute("clazzes", clazzes);
		return "student_update";
	}

	@RequestMapping("update.do")
	public String update(Student student, Model model) {
		studentService.updateStudent(student);
		return list(new Student(), model);
	}

	@RequestMapping("loadadd.do")
	public String loadAdd(Model model) {
		List<Clazz> clazzes = clazzService.getClazzList();
		model.addAttribute("clazzes", clazzes);
		return "student_add";
	}
}
