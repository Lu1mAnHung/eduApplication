package com.edu.service.grade;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.model.GradeInfo;
import com.edu.model.StudentGradeInfo;

@Service
@Transactional
public interface GradeService {
    /**
     * 显示个人成绩（学生角色权限）
     */
	public GradeInfo showGrade();
    /**
     *个人成绩条件查询（学生角色权限）
     */
	public GradeInfo queryGrade(Map<String, Object> qgrade);
    /**
     * 学生成绩修改（教师角色权限）
     */
	public void updateGrade(String u_no, String s_cid,Integer g_grade,Integer g_staus);
    /**
     * 显示学生成绩（教师角色权限）
     */
	public StudentGradeInfo showStudentGrade(String s_sid);

    /**
     * 学生成绩条件查询（教师角色权限）
     */
	public StudentGradeInfo queryStudentGrade(Map<String, Object> qgrade);
}
