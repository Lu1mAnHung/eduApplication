package com.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.edu.model.CourseInfo;
import com.edu.service.course.CourseService;

import cn.hutool.json.JSONObject;

@Controller
@RequestMapping("/menu/mycourse")
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping("/")
	public String index() {
		return "/menu/mycourse/myCourse";
	}
    /**
     * 显示课表
     */
	@RequestMapping("/showCourse")
    public ModelAndView showCourse(HttpServletRequest req,HttpServletRequest rep) {
    	String u_no = ((JSONObject) req.getSession().getAttribute("currentUser")).getStr("u_no");
    	String role = ((JSONObject) req.getSession().getAttribute("currentUser")).getStr("u_role");
    	String u_name = ((JSONObject) req.getSession().getAttribute("currentUser")).getStr("u_name");
    	 List<CourseInfo>  courselist;
		if(role.equals("2")) {
		  courselist=courseService.showMyCourse(u_no);
		}else {
		  courselist=courseService.showMyCourse(u_name);
		}
		ModelAndView modelAndView = new ModelAndView("/mycourse/myCourse");
		modelAndView.addObject(courselist);
		return modelAndView;
    }

}
