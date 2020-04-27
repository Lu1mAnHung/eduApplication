package com.edu.service.student.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.StudentDao;
import com.edu.model.ClassInfo;
import com.edu.model.StudentInfo;
import com.edu.model.User;
import com.edu.service.student.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public User findStudentByno(String u_no) {
		User student = studentDao.findStudentByno(u_no);
		return student;
	}

	@Override
	public ClassInfo findClass() {
		ClassInfo classInfo = studentDao.findClass();
		return classInfo;
	}

	@Override
	public StudentInfo showStudent() {
		StudentInfo studentInfo = studentDao.showStudent();
		return studentInfo;
	}

	@Override
	public StudentInfo showUser() {
		StudentInfo studentInfo = studentDao.showUser();
		return studentInfo;
	}

	@Override
	public void delStudent(String u_no) {
		studentDao.delStudent(u_no);
	}

	@Override
	public void delStudentClazz(String u_no) {
		studentDao.delStudentClazz(u_no);
	}

	@Override
	public void updateStudent(Map<String, Object> student) {
		studentDao.updateStudent(student);
	}

	@Override
	public Integer checkStudent(String u_no) {
		Integer flag = studentDao.checkStudent(u_no);
		return flag;
	}

	@Override
	public void addStudent(Map<String, Object> student) {
		studentDao.addStudent(student);
	}

	@Override
	public StudentInfo queryStudent(Map<String, Object> student) {
		StudentInfo studentInfo = studentDao.queryStudent(student);
		return studentInfo;
	}

}
