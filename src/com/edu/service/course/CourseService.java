package com.edu.service.course;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.model.CourseInfo;

@Service
@Transactional
public interface CourseService {
	/**
	 * 显示课程信息
	 */
	public List<CourseInfo> showCourse();
	/**
	 * 查询课程信息
	 */
	public List<CourseInfo>queryCourse(String sid);
	/**
	 * 退选课程
	 */
	public void delCourse(String ssid, String scid);
	/**
	 * 检查是否重复选课
	 */
	public Integer checkCourse(String ssid, String scid);
	/**
	 * 选课
	 */
	public void addCourse(String ssid, String scid);
    /**
     * 显示个人课表
     */
	public List<CourseInfo> showMyCourse(String u_no);
}
