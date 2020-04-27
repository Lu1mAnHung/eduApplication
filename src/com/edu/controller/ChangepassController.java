package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.service.user.PassService;
import com.edu.util.Constant;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;

@Controller
@RequestMapping("/menu/changepass")
public class ChangepassController{

	@Autowired
	private PassService passService;

	@RequestMapping("/")
	public String index() {
		return "/menu/changepass/index";
	}

    /**
     *  修改密码
     */
	@RequestMapping("/saveNewPass")
	@ResponseBody
	public String saveNewPass(HttpServletRequest req,HttpServletResponse rep) {
          String newPass =req.getParameter("newPass");
          String encodingNewPass = SecureUtil.md5(newPass);
          JSONObject currentUser = (JSONObject) req.getSession().getAttribute("currentUser");
          Integer id = currentUser.getInt("id");
          passService.changePass(encodingNewPass, id);
          return Constant.SUCCESS;

	}
}
