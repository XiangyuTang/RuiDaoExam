package com.neuedu.ruidaoexam.service;

import com.neuedu.ruidaoexam.entity.Paper;

public interface PaperService {
	//添加卷子并返回其id号
	Integer addPaper(Paper paper);
}
