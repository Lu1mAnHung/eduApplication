package com.edu.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.UserDao;
import com.edu.model.User;
import com.edu.service.system.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao userdao;


	/**
	 * 登录验证
	 */
	@Override
	public User checklogin(String username, String password) {
		// TODO Auto-generated method stub
		User user = userdao.findByUsername(username);
		return user;

	}

	/**
	 * 获取登录数据 将登录信息放入数据库（日志）
	 * @param u_login
	 * @param Address
	 * @param u_name
	 * @param u_action
	 * @return
	 */
	@Override
	public void addlog(String u_login, String Address, String u_name, String u_action) {
		// TODO Auto-generated method stub
		userdao.addLog(u_login, Address, u_name, u_action);
	}

}
