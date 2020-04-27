package com.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.edu.model.CourseInfo;
import com.edu.service.course.CourseService;
import com.edu.util.Constant;

import cn.hutool.json.JSONObject;

@Controller
@RequestMapping("/menu/selectinfo")
public class SelectController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/")
	public String index() {
		return "/menu/selectinfo/select";
	}

     /**
      * 显示选课信息
      * @return
      */
	@RequestMapping("/showCourse")
	public ModelAndView showCourse(HttpServletRequest req, HttpServletResponse rep) {
		List<CourseInfo> corseInfo =courseService.showCourse();
        ModelAndView modelAndView = new ModelAndView("/selectinfo/select");
        modelAndView.addObject(corseInfo);
        modelAndView.setViewName("/menu/selectinfo/select");
       return modelAndView;
	}

    /**
     * 查询选课信息
     */
	@RequestMapping("/queryCourse")
	public ModelAndView queryCourse(HttpServletRequest req, HttpServletResponse rep,Model model) {
       JSONObject currentUser =(JSONObject)req.getSession().getAttribute("currentUser");
       String sid = currentUser.getStr("u_no");
       List<CourseInfo> querycourseInfo = courseService.queryCourse(sid);
       ModelAndView modelAndView = new ModelAndView("/selectinfo/select");
       modelAndView.addObject(querycourseInfo);
       modelAndView.setViewName("/menu/selectinfo/select");
      return modelAndView;
	}

	/**
	 * 退选课程
	 */
	@RequestMapping("/delCourse")
	@ResponseBody
	public String delCourse(HttpServletRequest req, HttpServletResponse rep) {
         String s_sid = req.getParameter("ssid");
         String s_cid = req.getParameter("scid");
         String c_type = req.getParameter("ctype");
 		if (c_type.equals("1")) {
			return Constant.MAJORCLASS_ERROR;
		} else {
			courseService.delCourse(s_sid, s_cid);
			return Constant.SUCCESS;
		}
	}
	/**
	 *  选课
	 */
	@RequestMapping("/addCourse")
	@ResponseBody
	public String addCourse(HttpServletRequest req, HttpServletResponse rep) {
		 JSONObject currentUser =(JSONObject)req.getSession().getAttribute("currentUser");
		 String s_cid = req.getParameter("scid");
		 String s_sid = currentUser.getStr("u_no");
		 Integer flag = courseService.checkCourse(s_cid, s_sid);
		 if (flag > 0) {
				return Constant.CLASS_ISSELECTED;
			} else {
				courseService.addCourse(s_sid, s_cid);
				return Constant.SUCCESS;
			}
	}

}
