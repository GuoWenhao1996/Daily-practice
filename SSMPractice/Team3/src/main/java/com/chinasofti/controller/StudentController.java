package com.chinasofti.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.entity.Clazz;
import com.chinasofti.entity.Student;
import com.chinasofti.service.ClazzService;
import com.chinasofti.service.StudentService;
import com.chinasofti.util.BaseController;

@Controller
@RequestMapping("/student/")
public class StudentController extends BaseController {

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
	public String add(Student student, Model model, HttpServletRequest request) throws UnsupportedEncodingException {

		studentService.addStudent(student);
		return list(new Student(), model, request);
	}

	@RequestMapping("list.do")
	public String list(Student student, Model model, HttpServletRequest request) throws UnsupportedEncodingException {

		if (student.getName() != null && !student.getName().equals("")) {
			student.setName(URLDecoder.decode(student.getName(), "UTF-8"));
		}
		if (student.getName() != null && !student.getName().equals("")) {
			model.addAttribute("studentnamequery", URLEncoder.encode(student.getName(), "UTF-8"));
		}
		if (student.getClazz() != null) {
			model.addAttribute("studentclazzidquery", student.getClazz().getId());
		}

		this.initPage(request);
		student.setStart(getStart());

		List<Student> students = studentService.getStudentList(student);
		model.addAttribute("students", students);

		Long total = studentService.getCount(student);
		model.addAttribute("total", total);

		List<Clazz> clazzes = clazzService.getClazzList();
		model.addAttribute("clazzes", clazzes);
		return "index";
	}

	@RequestMapping("delete.do")
	public String delete(Student student, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		studentService.deleteStudent(student);
		return list(new Student(), model, request);
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
	public String update(Student student, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		studentService.updateStudent(student);
		return list(new Student(), model, request);
	}

	@RequestMapping("loadadd.do")
	public String loadAdd(Model model) {
		List<Clazz> clazzes = clazzService.getClazzList();
		model.addAttribute("clazzes", clazzes);
		return "student_add";
	}
}
