package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.Ques_Bank_MapperMapper;
import com.neuedu.ruidaoexam.dao.Ques_Paper_MapperMapper;
import com.neuedu.ruidaoexam.entity.Ques_Paper_Mapper;
import com.neuedu.ruidaoexam.service.PaperMapperService;
@Service
public class PaperMapperServiceimpl implements PaperMapperService {
	@Autowired
	Ques_Paper_MapperMapper ques_Paper_MapperMapper;
	@Override
	public int addMapper(Ques_Paper_Mapper mapper) {
		int insert = ques_Paper_MapperMapper.insert(mapper);
		return insert;
	}

}
