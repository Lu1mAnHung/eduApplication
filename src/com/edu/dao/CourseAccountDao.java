package com.edu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.edu.model.CourseInfo;

@Repository
public interface CourseAccountDao {

	   /**
	    * 显示课程信息
	    */
	  public List<CourseInfo> showCourse();

	  /**
	   * 通过ID查询课程信息
	   */
	  public CourseInfo  findCourseByid(String c_id);

	  /**
	   * 删除课程信息
	   */
	  public void delCourse(String c_id);

	  /**
	    * 修改课程信息
	    */
	   public void editCourse(Map<String, Object> course);

	   /**
	    * 新增课程信息
	    */
	   public void addCourse(Map<String, Object> course);

	   /**
	    * 条件查询课程信息
	    */
	  public List<CourseInfo> queryCourse(Map<String, Object> course);

	   /**
	    * 查询课程类型
	    */
	   public List<String> showType();

	   /**
		 * 检查课程号（确保唯一）
		 */
	   public Integer checkCourse(String c_id);

	   /**
	    * 显示排课列表
	    */
	   public List<String> showSchedule();

	   /**
	    *保存排课
	    */

	   public void saveSchedule(String c_classroom,String c_classtime,String c_name);
}
