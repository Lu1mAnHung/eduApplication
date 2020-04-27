package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.edu.model.RoleList;
import com.edu.model.UserRole;
import com.edu.service.user.RoleService;
import com.edu.util.Constant;



@Controller
@RequestMapping("/menu/accountrole")
public class RoleAccountController {

	@Autowired
	RoleService roleService;

	@RequestMapping("/")
	public String index() {
        return "/menu/accountrole/index";
	}

    /**
     * 显示编辑角色权限页面
     */
	@RequestMapping("/viewEditRole")
	@ResponseBody
	public String viewEditRole(HttpServletRequest req,HttpServletResponse rep) {
		String u_no = req.getParameter("u_no");
        RoleList roleList =  roleService.showRoleList();
 	    req.setAttribute("roleList",roleList);
 	    req.setAttribute("uno",u_no);
        return "/menu/accountrole/editrole";
	 }
    /**
     * 显示角色权限管理页面
     */
	@RequestMapping("/showRole")
	public ModelAndView showRole(HttpServletRequest req,HttpServletResponse rep) {
		 UserRole userRole =roleService.showUserRole();
		 ModelAndView modelAndView = new ModelAndView("/accountrole/index");
		 modelAndView.addObject(userRole);
      return modelAndView;
	}

    /**
     *  冻结（解冻）学生
     */
	@RequestMapping("/iceStudent")
	@ResponseBody
	public String iceStudent(HttpServletRequest req,HttpServletResponse rep) {
		 Integer u_status = Integer.parseInt(req.getParameter("u_status"));
		 String  u_no = req.getParameter("u_no");
		if (u_status == 1) {
			roleService.iceStudent(0, u_no);
		} else {
			roleService.iceStudent(1, u_no);
		}
		return Constant.SUCCESS;
	}

    /**
     * 修改角色权限
     */
	@RequestMapping("/editRole")
	@ResponseBody
	public String editRole(HttpServletRequest req,HttpServletResponse rep) {
		 Integer role = Integer.parseInt(req.getParameter("role"));
		 String  u_no = req.getParameter("u_no");
		 roleService.editRole(role, u_no);
		return "redirect:/main";
	}
}
