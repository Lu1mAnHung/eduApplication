package com.edu.service.user;

import org.springframework.stereotype.Service;

@Service
public interface PassService {

	/**
	 * 修改密码
	 * @param pass
	 * @param id
	 */
	public void changePass(String pass,Integer id);
}
