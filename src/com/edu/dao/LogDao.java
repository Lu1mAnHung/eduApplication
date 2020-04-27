package com.edu.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface LogDao {
	/**
	 * 将登录信息作为日志存入数据库
	 * @param loginfo
	 * @return
	 */
    void addLog(String u_login, String Address,String u_name,String u_action);
}
