package com.edu.service.user;

import org.springframework.stereotype.Service;

import com.edu.model.User;

@Service
public interface UserInfoService {

	/**
	 * 确保手机号的唯一性
	 * @param phone
	 * @return
	 */
	public Integer checkphone(String phone);

	/**
	 * 通过Id查询用户信息
	 * @param id
	 * @return
	 */
	public User findById(Integer id);

	/**
	 * 更新用户信息
	 * @param currentUserId
	 * @param name
	 * @param phone
	 * @param date
	 */
	public void updateUserInfo(Integer currentUserId,String name, String phone, String date,String email);

}
