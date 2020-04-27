package com.edu.service.course.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.CourseAccountDao;
import com.edu.model.CourseInfo;
import com.edu.service.course.CourseAccountService;

@Service
public class CourseAccountServiceImpl implements CourseAccountService{

	@Autowired
	CourseAccountDao courseAccountDao;

	@Override
	public List<CourseInfo> showCousre() {
		List<CourseInfo> courseInfo = courseAccountDao.showCourse();
		return courseInfo;
	}

	@Override
	public void delCourse(String c_id) {
		courseAccountDao.delCourse(c_id);

	}

	@Override
	public void editCourse(Map<String, Object> course) {
		courseAccountDao.editCourse(course);

	}

	@Override
	public void addCourse(Map<String, Object> course) {
         courseAccountDao.addCourse(course);
	}

	@Override
	public List<CourseInfo> queryCourse(Map<String, Object> course) {
		List<CourseInfo> courseInfo = courseAccountDao.queryCourse(course);
		return courseInfo;
	}

	@Override
	public CourseInfo showEditCourse(String c_id) {
		CourseInfo courseInfo = courseAccountDao.findCourseByid(c_id);
		return courseInfo;
	}

	@Override
	public List<String> showType() {
		List<String> typelist = courseAccountDao.showType();
		return typelist;
	}

	@Override
	public Integer checkCourse(String c_id) {
		Integer flag = courseAccountDao.checkCourse(c_id);
		return flag;
	}

	@Override
	public List<String> showSchedule() {
		List <String> courseinfo = courseAccountDao.showSchedule();
		return courseinfo;
	}

	@Override
	public void SaveSchedule(String c_classroom, String c_classtime, String c_name) {
      courseAccountDao.saveSchedule(c_classroom, c_classtime, c_name);
	}

}
