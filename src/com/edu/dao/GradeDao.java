package com.edu.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.edu.model.GradeInfo;
import com.edu.model.StudentGradeInfo;

@Repository
public interface GradeDao {

	/**
	 * 显示学生成绩（教师权限）
	 */
	public GradeInfo showGrade();

	/**
	 * 条件查询学生成绩（教师权限）
	 */
	public GradeInfo queryGrade(Map<String, Object> qgrade);
	/**
	 * 修改学生成绩
	 */
	public void updateGrade(String u_no, String s_cid,Integer g_grade,Integer g_staus);
	/**
	 * 显示学生个人成绩（学生权限）
	 */
    public StudentGradeInfo showStudentGrade(String s_sid);
    /**
     * 条件查询学生个人成绩（学生权限）
     */
    public StudentGradeInfo queryStudentGrade(Map<String, Object> qgrade);
}
