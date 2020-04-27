package com.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.model.User;
import com.edu.service.user.UserInfoService;
import com.edu.util.Constant;

import cn.hutool.json.JSONObject;

@Controller
@RequestMapping("/menu/personalinfo")
public class PersonalInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/")
	public String index() {
		return "/menu/personalinfo/index";
	}
    /**
     * 修改个人信息
     */
	@RequestMapping("/saveNewinfo")
	@ResponseBody
	public String saveNewinfo(HttpServletRequest req, HttpServletRequest rep) {
		String name = req.getParameter("u_name");
		String email = req.getParameter("u_email");
		JSONObject currentUser = (JSONObject) req.getSession().getAttribute("currentUser");
		String oldphone = currentUser.getStr("u_phone");
		String phone = req.getParameter("u_phone");
		String date = req.getParameter("u_birthday");
		Integer currentUserId = currentUser.getInt("id");
		if(!phone.equals(oldphone)) {
			Integer flag =userInfoService.checkphone(phone);
	  		if(flag>0) {
	  			return Constant.PHONE_ISEXIST;
	  		}
		}
			userInfoService.updateUserInfo(currentUserId, name, phone, date, email);
			User user =userInfoService.findById(currentUserId);

			//将数据放入session
			JSONObject userJson = new JSONObject();
			userJson.put("id", user.getId())
			.put("u_name", user.getU_name())
			.put("u_no",user.getU_no())
			.put("u_password", user.getU_password())
			.put("u_phone", user.getU_phone())
			.put("u_email", user.getU_email())
			.put("u_birthday", user.getU_birthday())
			.put("u_role", user.getU_role_fk());
			req.getSession().setAttribute("currentUser",userJson);
		    return Constant.SUCCESS;
	}

}
