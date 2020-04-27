package com.edu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.edu.model.StudentGradeInfo;
import com.edu.service.grade.GradeService;

import cn.hutool.json.JSONObject;

@Controller
@RequestMapping("/menu/gradeinfo")
public class GradeInfoController {

	@Autowired
	private GradeService gradeService;

	@RequestMapping("/")
	public String index() {
		return "/menu/gradeinfo/garde";
	}
    /**
     * 显示学生个人成绩（学生权限）
     */
	@RequestMapping("/showGrade")
	public ModelAndView showGrade(HttpServletRequest req,HttpServletRequest rep) {
		JSONObject currentUser =(JSONObject)req.getSession().getAttribute("currentUser");
		String g_sid = currentUser.getStr("u_no");
		StudentGradeInfo studentGradeInfo = gradeService.showStudentGrade(g_sid);
		ModelAndView modelAndView = new ModelAndView("/gradeinfo/garde");
		modelAndView.addObject(studentGradeInfo);
		return modelAndView;
	}

	/**
	 * 条件查询学生个人成绩（学生权限）
	 */

	@RequestMapping("/querygrade")
	public ModelAndView querygrade(HttpServletRequest req,HttpServletRequest rep) {
		JSONObject currentUser =(JSONObject)req.getSession().getAttribute("currentUser");
		String g_sid = currentUser.getStr("u_no");
		Integer g_staus = Integer.parseInt(req.getParameter("g_staus"));
		String c_name = req.getParameter("c_name");
		Map<String, Object> qgrade = new HashMap<>();
		qgrade.put("s_sid", g_sid);
		qgrade.put("c_name", c_name);
		qgrade.put("g_staus", g_staus);
		StudentGradeInfo studentGradeInfo = gradeService.queryStudentGrade(qgrade);
		ModelAndView modelAndView = new ModelAndView("/gradeinfo/garde");
		modelAndView.addObject(studentGradeInfo);
		return modelAndView;
	}
}
