package com.edu.service.system;

import com.edu.model.User;

public interface LoginService {

	/**
	 * 登录检查
	 * @param username
	 * @param password
	 * @return
	 */
	public User checklogin(String username ,String password);

	/**
	 * 获取登录数据 将登录信息放入数据库（日志）
	 * @param u_login
	 * @param Address
	 * @param u_name
	 * @param u_action
	 * @return
	 */
	public void addlog(String u_login,String Address,String u_name,String u_action);
}
