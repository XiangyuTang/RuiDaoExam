package com.neuedu.ruidaoexam.service;

import java.util.HashMap;

import com.neuedu.ruidaoexam.entity.Paper;

public interface PaperService {
	//添加卷子并返回其id号
	Integer addPaper(Paper paper);
	String getPaper_name(Integer paper_id);
	//根据教师的id选择其创建和购买的卷子
	HashMap<String, Object> getPaperByTeacherId(Integer TeacherId);
}
