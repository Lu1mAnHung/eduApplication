package com.edu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.model.CourseInfo;

@Repository
public interface CourseDao {

   /**
    * 展示课程信息
    */
   public List<CourseInfo> showCourse();

   /**
    * 获取选课信息
    */
   public List<CourseInfo> queryCourse(String sid);

   /**
    * 退选
    */
   public void delCourse(String ssid,String scid);

   /**
    * 检查选课信息（保证唯一）
    */
   public Integer checkCourse(String ssid,String scid);

   /**
    * 选课
    */

   public void addCourse(String ssid, String scid);

}
