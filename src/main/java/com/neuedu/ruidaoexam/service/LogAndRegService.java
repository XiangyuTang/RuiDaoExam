package com.neuedu.ruidaoexam.service;

//登录注册service
public interface LogAndRegService {

	int register(Object o);
	
	int login(String username,String password);
//	Boolean checkHavePassword(Object o);
	//email是否存在
	Boolean checkEmail(String email);
	//User是否存在，参数为用户名或邮箱，密码;返回0不存在，1老师，2学生
	int checkUser(String username, String password);
	//用户名是否存在
	Boolean checkUsername(String username);
	Boolean resetUserpassword(String email, String password);
	//email格式是否正确
	Boolean isEmail(String email);
	//根据用户名/邮箱得到对象
	Object getUser(String username, String password);
	
}
