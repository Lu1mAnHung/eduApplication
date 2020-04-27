package com.edu.service.grade.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.GradeDao;
import com.edu.model.GradeInfo;
import com.edu.model.StudentGradeInfo;
import com.edu.service.grade.GradeService;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;

	@Override
	public GradeInfo showGrade() {
		GradeInfo gradeInfo = gradeDao.showGrade();
		return gradeInfo;
	}

	@Override
	public GradeInfo queryGrade(Map<String, Object> qgrade) {
		GradeInfo qgradeInfo = gradeDao.queryGrade(qgrade);
		return qgradeInfo;
	}

	@Override
	public void updateGrade(String u_no, String s_cid, Integer g_grade, Integer g_staus) {
		gradeDao.updateGrade(u_no, s_cid, g_grade, g_staus);
	}

	@Override
	public StudentGradeInfo showStudentGrade(String s_sid) {
		StudentGradeInfo gradeInfo = gradeDao.showStudentGrade(s_sid);
		return gradeInfo;
	}

	@Override
	public StudentGradeInfo queryStudentGrade(Map<String, Object> qgrade) {
		StudentGradeInfo gradeInfo = gradeDao.queryStudentGrade(qgrade);
		return gradeInfo;
	}

}
