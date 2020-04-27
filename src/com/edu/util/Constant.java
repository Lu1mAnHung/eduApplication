package com.edu.util;

import java.util.HashMap;

import cn.hutool.json.JSONObject;

public class Constant {
	public static final String USER_PASS_ERROR = "用户密码错误";
	public static final String USER_NOT_EXSIT = "用户不存在";
	public static final String SUCCESS = "success";
    public static final HashMap<String,JSONObject> USER_CACHE =new HashMap<>();
	public static final String USER_ICED = "用户已冻结";
	public static final String STUDENTNO_ISEXIST ="该学号已存在：学号不可相同！";
	public static final String COURSEID_ISEXIST ="该课程号已存在：课程号不可相同！";
	public static final String ISNOAUTH = "没有此操作权限！";
	public static final String PHONE_ISEXIST= "该手机号已存在！";
	public static final String CLASS_ISSELECTED="该课程已选择";
	public static final String MAJORCLASS_ERROR="主修课程不可删除！";
}
