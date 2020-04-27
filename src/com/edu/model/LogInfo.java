package com.edu.model;

import java.util.Date;

public class LogInfo {

 private String logger_name;

 private String logger_ip;

 private Date logger_time;

 private String loginid;

 private String logger_action;

public String getLogger_name() {
	return logger_name;
}

public void setLogger_name(String logger_name) {
	this.logger_name = logger_name;
}

public String getLogger_ip() {
	return logger_ip;
}

public void setLogger_ip(String logger_ip) {
	this.logger_ip = logger_ip;
}

public Date getLogger_time() {
	return logger_time;
}

public void setLogger_time(Date logger_time) {
	this.logger_time = logger_time;
}

public String getLoginid() {
	return loginid;
}

public void setLoginid(String loginid) {
	this.loginid = loginid;
}

public String getLogger_action() {
	return logger_action;
}

public void setLogger_action(String logger_action) {
	this.logger_action = logger_action;
}

}
