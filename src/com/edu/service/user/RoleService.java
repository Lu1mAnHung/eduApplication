package com.edu.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.model.RoleList;
import com.edu.model.UserRole;

@Service
@Transactional
public interface RoleService {
    /**
     * 展示权限列表
     * @return
     */
	public RoleList showRoleList();
    /**
     * 更改权限
     * @param role
     * @param u_no
     */
	public void editRole(Integer role, String u_no);
    /**
     * 冻结（解冻）学生
     * @param status
     * @param u_no
     */
    public void iceStudent(Integer status, String u_no);
    /**
     * 展示角色以及其权限
     * @return
     */
    public UserRole showUserRole();
}
