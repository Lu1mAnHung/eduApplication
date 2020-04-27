package com.edu.dao;

import org.springframework.stereotype.Repository;

import com.edu.model.RoleList;
import com.edu.model.User;
import com.edu.model.UserRole;

@Repository
public interface UserDao {

	/**
	 * 通过用户名查询用户信息
	 * @param username 用户名
	 * @return
	 */

	public User findByUsername(String username);

	/**
	 * 修改密码
	 * @param newPass
	 * @param id
	 */
	public void updatePass(String newPass,Integer id);


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
    public void updateUserInfo(Integer currentUserId, String name, String phone, String date,String email);

    /**
     * 检查手机号（保证手机号的唯一）
     * @param phone
     * @return
     */
    public Integer checkphone(String phone);
    /**
     * 从数据库中取出权限数据
     * @return
     */
    public RoleList showRoleList();
    /**
     * 修改角色权限
     * @param u_no
     * @param role
     */
    public void  updateRole(Integer role,String u_no);
    /**
     * 冻结（解冻）学生
     * @param status
     * @param u_no
     */
    public void iceStudent(Integer status, String u_no);
    /**
     * 展示用户权限信息
     * @return
     */
    public UserRole showUserRole();

    /**
	 * 将登录信息作为日志存入数据库
	 * @param loginfo
	 * @return
	 */
    public void addLog(String u_login, String Address,String u_name,String u_action);
}
