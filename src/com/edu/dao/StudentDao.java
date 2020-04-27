package com.edu.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.edu.model.ClassInfo;
import com.edu.model.StudentInfo;
import com.edu.model.User;

@Repository
public interface StudentDao {

	/**
	 * 通过学号查询学生信息
	 */
	public User findStudentByno(String u_no);

	/**
	 * 查询班级信息
	 */
	public ClassInfo findClass();

	/**
	 * 查询学生相关信息（教师权限）
	 */
	public StudentInfo showStudent();

	/**
	 * 查询学生及教师信息（管理员权限）
	 */
	public StudentInfo showUser();

	/**
	 * 删除学生信息
	 */
	public void delStudent(String u_no);

	/**
	 * 删除学生选课和成绩信息
	 */
	public void delStudentClazz(String u_no);

	/**
	 * 修改学生信息
	 */
	public void updateStudent(Map<String, Object> student);

	/**
	 * 检查学生学号（确保唯一）
	 */
	public Integer checkStudent(String u_no);

	/**
	 * 新增学生信息
	 */
	public void addStudent(Map<String, Object> student);

	/**
	 * 条件查询学生信息
	 */
	public StudentInfo queryStudent(Map<String, Object> student);
}
