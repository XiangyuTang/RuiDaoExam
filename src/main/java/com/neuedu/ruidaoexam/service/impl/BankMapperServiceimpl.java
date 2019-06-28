package com.neuedu.ruidaoexam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.Ques_Bank_MapperMapper;
import com.neuedu.ruidaoexam.entity.Ques_Bank_Mapper;
import com.neuedu.ruidaoexam.entity.Ques_Bank_MapperExample;
import com.neuedu.ruidaoexam.entity.Ques_Bank_MapperExample.Criteria;
import com.neuedu.ruidaoexam.service.BankMapperService;
@Service
public class BankMapperServiceimpl implements BankMapperService{
	@Autowired Ques_Bank_MapperMapper ques_Bank_MapperMapper;

	@Override
	public int addMapper(Ques_Bank_Mapper mapper) {
		int insert = ques_Bank_MapperMapper.insert(mapper);
		return insert;
	}

	@Override
	public List<Ques_Bank_Mapper> getMappersByPaperid(Integer bank_id) {
		Ques_Bank_MapperExample example=new Ques_Bank_MapperExample();
		Criteria  criteria = example.createCriteria();
	       criteria.andBankIdEqualTo(bank_id);
	       List<Ques_Bank_Mapper> mappers=ques_Bank_MapperMapper.selectByExample(example);
			return mappers;
	}

	@Override
	public Boolean copyMapper(Integer bank_id, List<Ques_Bank_Mapper> oldMappers) {
		for(Ques_Bank_Mapper single:oldMappers) {
			single.setBankId(bank_id);
			single.setMapperId(null);
			ques_Bank_MapperMapper.insert(single);
		}
		return true;
	}
	
	

}
