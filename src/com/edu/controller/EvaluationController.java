package com.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.edu.model.EvalutionInfo;
import com.edu.service.evaluation.EvaluationService;

import cn.hutool.json.JSONObject;

@Controller
@RequestMapping("/menu/courseeva")
public class EvaluationController {

	@Autowired
	EvaluationService evaluationService;


	@RequestMapping("/")
     public String index(HttpServletRequest req) {
		String role = ((JSONObject)req.getSession().getAttribute("currentUser")).getStr("u_role");
		if(role.equals("2")) {
			return("/menu/evaluiation/evaluation.html");
		}else {
			return("/menu/evaluiation/viewEvaluation.html");
		}
     }

	/**
	 *显示可评价信息页面（学生权限）
	 */
	@RequestMapping("/showEvaluation")
	public ModelAndView showEvaluation(HttpServletRequest req,HttpServletResponse res) {
		String u_no = ((JSONObject) req.getSession().getAttribute("currentUser")).getStr("u_no");
		List<EvalutionInfo> evaluationList = evaluationService.showEvaCourse(u_no);
		ModelAndView modelAndView = new ModelAndView("/evaluiation/evaluation");
		modelAndView.addObject(evaluationList);
		return modelAndView;
	}

	/**
	 *展示添加课程评价页面（学生权限）
	 */
	@RequestMapping("/viewaddevaluation")
	public String viewaddevaluation(HttpServletRequest req,HttpServletResponse res) {
		String c_id = req.getParameter("c_id");
		String c_name = req.getParameter("c_name");
		String c_teacher = req.getParameter("c_teacher");
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("c_id", c_id);
		map.put("c_name", c_name);
		map.put("c_teacher", c_teacher);
		req.setAttribute("evaluationinfo",map);
		return ("/menu/evaluiation/addevaluation");
	}

	/**
	 *添加课程评价（学生权限）
	 */
	@RequestMapping("/addevaluation")
	public String addevaluation(HttpServletRequest req,HttpServletResponse res) {
		String u_no = ((JSONObject) req.getSession().getAttribute("currentUser")).getStr("u_no");
		String c_id = req.getParameter("c_id");
		String evaluation = req.getParameter("evaluation");
		evaluationService.addEvaluation(u_no, c_id, evaluation);
		return "redirect:/main";
	}

	/**
	 *展示学生评价页面（教师权限）
	 */
	@RequestMapping("/viewevaluation")
	public ModelAndView viewevaluation(HttpServletRequest req,HttpServletResponse res) {
		String u_name = ((JSONObject) req.getSession().getAttribute("currentUser")).getStr("u_name");
		List<EvalutionInfo> evaluationList = evaluationService.viewEvaluation(u_name);
		ModelAndView modelAndView = new ModelAndView("/evaluiation/viewEvaluation");
		modelAndView.addObject(evaluationList);
		return modelAndView;
	}
}
