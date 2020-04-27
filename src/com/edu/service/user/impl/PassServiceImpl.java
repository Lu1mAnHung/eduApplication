package com.edu.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.UserDao;
import com.edu.service.user.PassService;

@Service("PassService")
@Transactional
public class PassServiceImpl implements PassService{

	@Autowired
	private UserDao UserDao;

	@Override
	public void changePass(String pass, Integer id) {
		UserDao.updatePass(pass, id);
	}

}
