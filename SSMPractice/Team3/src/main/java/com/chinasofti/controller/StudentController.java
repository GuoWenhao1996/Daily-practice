package com.chinasofti.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.entity.Clazz;
import com.chinasofti.entity.Message;
import com.chinasofti.entity.Student;
import com.chinasofti.service.ClazzService;
import com.chinasofti.service.StudentService;
import com.chinasofti.util.BaseController;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

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

	@RequestMapping("validate.do")
	public @ResponseBody Message validate(Student student) {
		boolean flag = studentService.validate(student);
		if (flag) {
			Message message = new Message();
			message.setContent("账号可用！");
			message.setData(new Date());
			return message;
		} else {
			Message message = new Message();
			message.setContent("账号已存在！");
			message.setData(new Date());
			return message;
		}
	}

	@RequestMapping("upload.do")
	public @ResponseBody String uploadImg(@RequestParam(required = false) MultipartFile file,
			HttpServletRequest request) throws IOException, InterruptedException {
		System.out.println(file);
		String fileName = String.valueOf(new Date().getTime());
		fileName += new Random().nextLong();
		String url = "/upload/" + fileName + ".jpg";
		String httpurl = "http://localhost:9123/Team3_fileserver" + url;
		// url = request.getServletContext().getRealPath(url);
		// System.out.println("url=" + url);
		// // FileOutputStream fos= new FileOutputStream(url);
		// // fos.write(file.getBytes());
		// // fos.close();
		// file.transferTo(new File(url));
		// Thread.sleep(5000);
		
		Client client =new Client();
		WebResource resource=client.resource(httpurl);
		resource.put(String.class,file.getBytes());
		
		return httpurl;
	}
}
