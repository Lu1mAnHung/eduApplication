package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

@Controller
public class MainController {

	/**
	 * 主页 加载菜单
	 */
	@RequestMapping("/main")
	public String index(HttpServletRequest req,HttpServletResponse rep,Model model) {
		JSONObject currentUser = (JSONObject) req.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:/login" ;
		}
		try {
			JSONArray menuArray = LoginController.menuArray;
			model.addAttribute("menuArray", menuArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("currentUser", currentUser);
		return("main/main");
	}

}
