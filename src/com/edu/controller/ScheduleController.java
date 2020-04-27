package com.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.service.course.CourseAccountService;
import com.edu.util.Constant;

@Controller
@RequestMapping("/menu/schedule")
public class ScheduleController {

	@Autowired
	CourseAccountService courseAccountservice;

	/**
	 * 显示排课列表
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest req,HttpServletResponse res) {
		List<String> courseinfolist = courseAccountservice.showSchedule();
		req.setAttribute("courseinfolist", courseinfolist);
		return "/menu/schedule/schedule";
	}

	/**
	 * 保存排课信息
	 */

	@RequestMapping("/saveSchedule")
	public String saveSchedule(HttpServletRequest req,HttpServletResponse res) {
        String c_name = req.getParameter("c_name");
        String c_classtime_1 = req.getParameter("c_classtime_1");
        String c_classtime_2 = req.getParameter("c_classtime_2");
        String c_classroom = req.getParameter("c_classroom");
        String c_classtime = c_classtime_1+"-"+c_classtime_2;
        courseAccountservice.SaveSchedule(c_classroom, c_classtime, c_name);
        return Constant.SUCCESS;
	}
}
