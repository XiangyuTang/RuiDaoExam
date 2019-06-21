package com.neuedu.ruidaoexam.service;

public interface LogAndRegService {

	int register(Object o);
	int login(Object o);
	Boolean checkEmail(String email);
	Boolean checkUser(String username, String password);
	Boolean checkUsername(String username);
	Boolean resetUserpassword(String email, String password);
	
	
}
