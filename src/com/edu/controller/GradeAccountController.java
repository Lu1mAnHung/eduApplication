package com.edu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.edu.model.GradeInfo;
import com.edu.service.grade.GradeService;

import cn.hutool.json.JSONObject;

@Controller
@RequestMapping("menu/accountgrade")
public class GradeAccountController {

	@Autowired
	private GradeService gradeService;

	@RequestMapping("/")
	public String index() {
		return "/menu/accountgrade/accountgrade";
	}

	/**
	 * 显示修改学生成绩页面
	 */
	@RequestMapping("/viewEditGrade")
	public String ViewEidtGrade(HttpServletRequest req, HttpServletRequest rep) {
		String u_no = req.getParameter("u_no");
		Integer g_grade = Integer.parseInt(req.getParameter("g_grade"));
		String s_cid = req.getParameter("s_cid");
		Integer g_staus = Integer.parseInt(req.getParameter("g_staus"));
		JSONObject gradeInfo = new JSONObject();
		gradeInfo.append("u_no", u_no).append("g_grade", g_grade).append("s_cid", s_cid).append("g_staus", g_staus);
		req.setAttribute("gradeinfo", gradeInfo);
		return "/menu/gradeinfo/editGrade";
	}

	/**
	 * 显示学生成绩（教师权限）
	 */
	@RequestMapping("/showGrade")
	public ModelAndView showGrade() {
		GradeInfo gradeInfo = gradeService.showGrade();
		ModelAndView modelAndView = new ModelAndView("/accountgrade/accountgrade");
		modelAndView.addObject(gradeInfo);
		return modelAndView;
	}

	/**
	 * 条件查询学生成绩（教师权限）
	 */
	@RequestMapping("/queryGrade")
	public ModelAndView queryGrade(HttpServletRequest req, HttpServletRequest rep) {
		String u_no = req.getParameter("u_no");
		String c_name = req.getParameter("c_name");
		String u_name = req.getParameter("u_name");
		Integer g_staus = Integer.parseInt(req.getParameter("g_staus"));
		Map<String, Object> qgrade = new HashMap<>();
		qgrade.put("u_no", u_no);
		qgrade.put("c_name", c_name);
		qgrade.put("u_name ", u_name);
		qgrade.put("g_staus", g_staus);
		GradeInfo qgradeInfo = gradeService.queryGrade(qgrade);
		ModelAndView modelAndView = new ModelAndView("/accountgrade/accountgrade");
		modelAndView.addObject(qgradeInfo);
		return modelAndView;
	}

	/**
	 * 修改学生成绩
	 */
	@RequestMapping("/editgrade")
	public String editgrade(HttpServletRequest req, HttpServletRequest rep) {
		String u_no = req.getParameter("u_no");
		Integer g_grade = Integer.parseInt(req.getParameter("g_grade"));
		String s_cid = req.getParameter("s_cid");
		Integer g_staus;
		if (g_grade >= 60) {
			g_staus = 1;
		} else {
			g_staus = 2;
		}
		gradeService.updateGrade(u_no, s_cid, g_grade, g_staus);
		return "redirect/main";
	}
}
