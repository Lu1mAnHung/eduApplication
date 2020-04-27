package com.edu.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.UserDao;
import com.edu.model.User;
import com.edu.service.user.UserInfoService;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl  implements UserInfoService{
	@Autowired
	private UserDao userDao;

	@Override
	public Integer checkphone(String phone) {
		Integer flag = userDao.checkphone(phone);
		return flag;
	}

	@Override
	public User findById(Integer id) {
         User user = userDao.findById(id);
		return user;
	}

	@Override
	public void updateUserInfo(Integer currentUserId, String name, String phone, String date, String email) {
		  userDao.updateUserInfo(currentUserId, name, phone, date,email);

	}

}
