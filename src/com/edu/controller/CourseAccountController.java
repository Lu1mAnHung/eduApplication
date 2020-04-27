package com.edu.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.edu.model.CourseInfo;
import com.edu.service.course.CourseAccountService;
import com.edu.util.Constant;
import com.jfinal.kit.StrKit;

@Controller
@RequestMapping("/menu/accountcourse")
public class CourseAccountController {

	@Autowired
	CourseAccountService courseAccountService;

	@RequestMapping("/")
	public String index() {
		return "/menu/accountcourse/accountcourse";
	}

	/**
	 * 显示编辑课程信息界面
	 */
	@RequestMapping("/viewEditCourse")
	public String videEditCourse(HttpServletRequest req,HttpServletResponse res) {
		String c_id =  req.getParameter("c_id");
        CourseInfo courseList = courseAccountService.showEditCourse(c_id);
        List<String> typelist = courseAccountService.showType();
        req.setAttribute("courseList", courseList);
        req.setAttribute("typelist", typelist);
		return "/menu/accountcourse/editCourse";
	}

	/**
	 * 显示添加课程信息界面
	 */

	@RequestMapping("/videaddCourse")
	public String viewaddCourse(HttpServletRequest req,HttpServletResponse res) {
		List<String> typelist = courseAccountService.showType();
		req.setAttribute("typelist", typelist);
		return "/menu/accountcourse/addCourse";
	}

	/**
	 * 显示课程信息
	 */

	@RequestMapping("/showCourse")
	public ModelAndView showCourse() {
		List<CourseInfo> courseInfo = courseAccountService.showCousre();
		ModelAndView modelAndView = new ModelAndView("/accountcourse");
		modelAndView.addObject(courseInfo);
		return modelAndView;
	}

	/**
	 * 删除课程信息
	 */

	@RequestMapping("/delCourse")
	@ResponseBody
	public String delCourse(HttpServletRequest req,HttpServletResponse rep) {
		 String c_id = req.getParameter("c_id");
		 courseAccountService.delCourse(c_id);
		 return Constant.SUCCESS;
	}

	/**
	 * 编辑课程信息
	 */

	@RequestMapping("/editCourse")
	public String editCourse(HttpServletRequest req,HttpServletResponse rep) {
		Map<String, Object> course = new HashMap<String, Object>();
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String para = params.nextElement();
			String value = req.getParameter(para);
			if (!StrKit.isBlank(value)) {
				course.put(para, value);
			}
		}
		courseAccountService.editCourse(course);
		return "redirect:/main";
	}

	/**
	 * 添加课程信息
	 */

	@RequestMapping("/addCourse")
	public String addCourse(HttpServletRequest req,HttpServletResponse rep) {
		Map<String, Object> course = new HashMap<String, Object>();
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String para = params.nextElement();
			String value = req.getParameter(para);
			if (!StrKit.isBlank(value)) {
				course.put(para, value);
			}
		}
		String c_id = req.getParameter("c_id");
		Integer flag = courseAccountService.checkCourse(c_id);
		if (flag > 0) {
			return Constant.COURSEID_ISEXIST;
		}
		courseAccountService.addCourse(course);
		return "redirect:/main";
	}

	/**
	 * 修改课程信息
	 */
	@RequestMapping("/queryCourse")
    public ModelAndView queryCourse(HttpServletRequest req,HttpServletResponse res) {
		String c_id = req.getParameter("c_id");
		String c_name=req.getParameter("c_name");
		String  c_teacher=req.getParameter("c_teacher");
		Integer c_type=Integer.parseInt(req.getParameter("c_type"));
		Map<String, Object> course = new HashMap<>();
        course.put("c_id", c_id);
        course.put("c_name", c_name);
        course.put("c_teacher", c_teacher);
        course.put("c_type", c_type);
        List<CourseInfo> courseInfo = courseAccountService.queryCourse(course);
        ModelAndView modelAndView = new ModelAndView("/accountcourse");
		modelAndView.addObject(courseInfo);
		return modelAndView;
	}

}
