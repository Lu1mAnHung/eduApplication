package com.edu.service.course;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.edu.model.CourseInfo;

@Service
public interface CourseAccountService {

	public List<CourseInfo> showCousre();//显示已有所有课程

	public void delCourse(String c_id);//删除课程

	public void editCourse(Map<String, Object> course);//修改课程信息

	public void addCourse(Map<String, Object> course);//添加课程

	public List<CourseInfo> queryCourse(Map<String, Object> course);//条件查询课程信息

	public CourseInfo showEditCourse(String c_id); //显示选中课程信息

	public Integer checkCourse(String c_id);//检查学生学号（确保唯一）

	public List<String> showType(); //显示课程类型

	public List<String> showSchedule(); //显示排课列表

	public void SaveSchedule(String c_classroom,String c_classtime,String c_name);//保存排课信息
}
