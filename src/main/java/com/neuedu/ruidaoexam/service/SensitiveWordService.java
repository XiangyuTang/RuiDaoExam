package com.neuedu.ruidaoexam.service;

public interface SensitiveWordService {
	String replaceBadWord(String txt,int matchType,String replaceChar);
}
