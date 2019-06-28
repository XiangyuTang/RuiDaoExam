package com.neuedu.ruidaoexam.service;

public interface QueryAbilityService {
	
	Integer getTotalRightQues(Integer stu_id,Integer ques_type);
	
	Integer getTotalQues(Integer stu_id,Integer ques_type);
}
