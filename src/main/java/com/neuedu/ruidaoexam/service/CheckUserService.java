package com.neuedu.ruidaoexam.service;

public interface CheckUserService {
	Boolean checkEmail(String email);
	Boolean checkUser(String username, String password);
}
