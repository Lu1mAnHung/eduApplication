package com.edu.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.CourseDao;
import com.edu.model.CourseInfo;
import com.edu.service.course.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	/**
	 * 显示课程信息
	 */
	@Override
	public List<CourseInfo> showCourse() {
		List<CourseInfo> courseinfo =courseDao.showCourse();
		for(CourseInfo tmp : courseinfo) {
			System.out.println(tmp);
		}
		return courseinfo;
	}
	/**
	 * 查询课程信息
	 */
	@Override
	public List<CourseInfo> queryCourse(String sid) {
		List<CourseInfo> queryCourseInfo = courseDao.queryCourse(sid);
		return queryCourseInfo;
	}
	/**
	 * 退选课程
	 */
	@Override
	public void delCourse(String ssid, String scid) {
             courseDao.delCourse(ssid, scid);
	}
	/**
	 * 检查是否重复选课
	 */
	@Override
	public Integer checkCourse(String ssid, String scid) {
         Integer flag = courseDao.checkCourse(ssid, scid);
		return flag;
	}
	/**
	 * 选课
	 */
	@Override
	public void addCourse(String ssid, String scid) {
            courseDao.addCourse(ssid, scid);
	}

	@Override
	public List<CourseInfo> showMyCourse(String u_no) {
		// TODO Auto-generated method stub
		return null;
	}

}
