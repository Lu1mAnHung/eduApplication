package com.edu.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.edu.model.User;
import com.edu.service.system.LoginService;
import com.edu.util.Constant;
import com.edu.util.MenuMappping;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

@Controller
@SessionAttributes("currentUser")
public class LoginController {

	  @Autowired
	  private LoginService loginService;

	  @RequestMapping("/login")
	  public String index() {
		  return "login/login";
	  }

	  public static JSONArray menuArray;
      /**
       * 进行登录操作
       */
	  @RequestMapping(value="/dologin",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
	  @ResponseBody
	  public String doLogin(HttpServletRequest req, HttpServletResponse resp) {

		 String username = req.getParameter("userName");
		 String userpass =  SecureUtil.md5(req.getParameter("userPass"));
		 JSONObject sessionJson = (JSONObject)req.getSession().getAttribute("currentUser");
		 JSONObject cacheJson = Constant.USER_CACHE.get("useName");
			if(cacheJson != null) {
				if(cacheJson.getStr("u_password").equals(userpass)) {
					req.getSession().setAttribute("currentUser",cacheJson);
					try {
						 menuArray = MenuMappping.readMenuToJSON(sessionJson.getInt("u_role_fk"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				return Constant.SUCCESS;
				}else {
				return("error:"+Constant.USER_PASS_ERROR);
				}
			}
		 User user =loginService.checklogin(username, userpass);
		 if(user==null) {
			 return "error:"+Constant.USER_NOT_EXSIT;
			}
			if(!userpass.equals(user.getU_password())) {
				 return "error:"+Constant.USER_PASS_ERROR;
			}
			if(user.getU_states()==1) {
              return "error:"+Constant.USER_ICED;
			}

			//记录用户登录信息
			String address = req.getRemoteAddr();
//      		loginService.addlog(username, address, user.getU_name(), "登录");

			//将数据放入session
			JSONObject userJson = new JSONObject();
			userJson.put("id", user.getId())
			.put("u_name", user.getU_name())
			.put("u_loginid", username)
			.put("u_no",user.getU_no())
			.put("u_password", user.getU_password())
			.put("address", address)
			.put("u_phone", user.getU_phone())
			.put("u_email", user.getU_email())
			.put("u_birthday", user.getU_birthday())
			.put("u_role", user.getU_role_fk());
			req.getSession().setAttribute("currentUser",userJson);

			//读取用户权限菜单
			try {
				 menuArray = MenuMappping.readMenuToJSON(((JSONObject) req.getSession().getAttribute("currentUser")).getInt("u_role"));
			} catch (Exception e) {
				e.printStackTrace();
			}

			Constant.USER_CACHE.put(username, userJson);

			return  Constant.SUCCESS;
	  }

	  /**
	   *  用户注销
	   */
	  @RequestMapping("/logout")
	    public String logout(HttpSession session){
	        //通过session.invalidata()方法来注销当前的session
	        session.invalidate();
	        return "login/login";
	    }

}
