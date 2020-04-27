package com.edu.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.UserDao;
import com.edu.model.RoleList;
import com.edu.model.UserRole;
import com.edu.service.user.RoleService;

@Service
@Transactional
public class RoleServiceImpl  implements RoleService{

	@Autowired
	UserDao userDao;

	@Override
	public RoleList showRoleList() {
		RoleList roleList = userDao.showRoleList();
		return roleList;
	}

	@Override
	public void editRole(Integer role, String u_no) {
       userDao.updateRole(role, u_no);
	}

	@Override
	public void iceStudent(Integer status, String u_no) {
       userDao.iceStudent(status, u_no);
	}

	@Override
	public UserRole showUserRole() {
       UserRole userRole =userDao.showUserRole();
	   return userRole;
	}

}
