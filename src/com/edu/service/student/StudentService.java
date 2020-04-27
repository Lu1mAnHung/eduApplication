package com.edu.service.student;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.edu.model.ClassInfo;
import com.edu.model.StudentInfo;
import com.edu.model.User;

@Service
public interface StudentService {

	public User findStudentByno(String u_no);  //通过学号查询学生信息

	public ClassInfo findClass(); //查询班级信息

	public StudentInfo showStudent();  //显示所有学生信息（教师角色权限）

 	public StudentInfo showUser();  //显示所有用户信息（管理员角色权限）

	public void delStudent(String u_no);//删除学生信息

	public void delStudentClazz(String u_no);//删除学生选课信息

	public void updateStudent(Map<String, Object> student);//修改学生信息

	public Integer checkStudent(String u_no);//检查学生学号（确保唯一）

	public void addStudent(Map<String, Object> student);//添加学生信息

	public StudentInfo queryStudent(Map<String, Object> student);//条件查询学生信息
}
