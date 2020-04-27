package com.edu.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.edu.model.ClassInfo;
import com.edu.model.RoleList;
import com.edu.model.StudentInfo;
import com.edu.model.User;
import com.edu.service.course.CourseService;
import com.edu.service.student.StudentService;
import com.edu.service.user.RoleService;
import com.edu.util.Constant;
import com.jfinal.kit.StrKit;

import cn.hutool.json.JSONObject;

@Controller
@RequestMapping("/menu/accountstudent")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	RoleService roleService;

	@Autowired
	CourseService courseService;

	@RequestMapping("/")
	public String index() {
		return "/menu/accountstudent/accountstudent";
	}

	/**
	 * 显示编辑学生信息界面
	 */
	@RequestMapping("/viewEditStudent")
	public String viewEditStudent(HttpServletRequest req, HttpServletResponse rep) {
		String u_no = req.getParameter("u_no");
		User student = studentService.findStudentByno(u_no);
		ClassInfo classInfo = studentService.findClass();
		req.setAttribute("classList", classInfo);
		req.setAttribute("studentList", student);
		return "/menu/accountstudent/editStudent";

	}

	/**
	 * 显示新增学生信息界面
	 */
	@RequestMapping("/viewaddStudent")
	public String viewaddStudent(HttpServletRequest req, HttpServletResponse rep) {
		ClassInfo classInfo = studentService.findClass();
		RoleList roleInfo = roleService.showRoleList();
		req.setAttribute("classList", classInfo);
		req.setAttribute("studentList", roleInfo);
		return "/menu/accountstudent/addStudent";
	}

	/**
	 * 显示学生信息
	 */
	@RequestMapping("/showStudent")
	public ModelAndView showStudent(HttpServletRequest req, HttpServletResponse rep) {
		JSONObject currentUser = (JSONObject) req.getSession().getAttribute("currentUser");
		Integer role = currentUser.getInt("u_role");
		StudentInfo studentInfo;
		if (role == 1) {
			studentInfo = studentService.showUser();
		} else {
			studentInfo = studentService.showStudent();
		}
		ModelAndView modelAndView = new ModelAndView("/accountstudent/accountstudent");
		modelAndView.addObject(studentInfo);
		return modelAndView;
	}

	/**
	 * 删除学生信息
	 */
	@RequestMapping("/delStudent")
	@ResponseBody
	public String delStudent(HttpServletRequest req, HttpServletResponse rep) {
		String u_no = req.getParameter("u_no");
		Integer u_role = Integer.parseInt(req.getParameter("u_role"));
		if (u_role == 1) {
			return  Constant.ISNOAUTH;
		} else {
			studentService.delStudent(u_no);
			studentService.delStudentClazz(u_no);
		}
		return Constant.SUCCESS;
	}

	/**
	 * 修改学生信息
	 */
	@RequestMapping("/editStudent")
	public String editStudent(HttpServletRequest req, HttpServletResponse rep) {
		Map<String, Object> student = new HashMap<>();
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String para = params.nextElement();
			String value = req.getParameter(para);
			if (!StrKit.isBlank(value)) {
				student.put(para, value);
			}
		}
		studentService.updateStudent(student);
		return "redirect:/main";
	}

	/**
	 * 新增学生信息
	 */
	@RequestMapping("/addStudent")
	@ResponseBody
	public String addStudent(HttpServletRequest req, HttpServletResponse rep) {
		Map<String, Object> student = new HashMap<>();
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String para = params.nextElement();
			String value = req.getParameter(para);
			if (!StrKit.isBlank(value)) {
				student.put(para, value);
			}
		}
		String u_no = req.getParameter("u_no");
		Integer flag = studentService.checkStudent(u_no);
		if (flag > 0) {
			return Constant.STUDENTNO_ISEXIST;
		} else {
			student.put("u_loginid", u_no);// 默认登录名等于学号
			student.put("u_password", "e10adc3949ba59abbe56e057f20f883e");// 默认密码：123456
			studentService.addStudent(student);
			courseService.addCourse(u_no, "C-01");// 默认选课
			return "redirect:/main";
		}
	}

	/**
	 * 条件查询指定学生信息
	 */
	@RequestMapping("/queryStudent")
	public ModelAndView queryStudent(HttpServletRequest req, HttpServletResponse rep) {
		String u_no = req.getParameter("u_no");
		String u_name = req.getParameter("u_name");
		Integer class_fk = Integer.parseInt(req.getParameter("class_fk"));
		String u_phone = req.getParameter("u_phone");
		Map<String, Object> student = new HashMap<>();
		student.put("u_no", u_no);
		student.put("u_name", u_name);
		student.put("class_fk ", class_fk);
		student.put("u_phone", u_phone);
		StudentInfo studentInfo = studentService.queryStudent(student);
		ModelAndView modelAndView = new ModelAndView("/accountstudent/accountstudent");
		modelAndView.addObject(studentInfo);
		return modelAndView;

	}
}
