package com.neuedu.ruidaoexam.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.Ques_Paper_MapperMapper;
import com.neuedu.ruidaoexam.entity.Ques_Paper_Mapper;
import com.neuedu.ruidaoexam.entity.Ques_Paper_MapperExample;
import com.neuedu.ruidaoexam.entity.Ques_Paper_MapperExample.Criteria;
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
	@Override
	public Boolean copyMapper(Integer paper_id,List<Ques_Paper_Mapper> oldMappers) {
		for(Ques_Paper_Mapper single:oldMappers) {
			single.setPaperId(paper_id);
			single.setMapperId(null);
			ques_Paper_MapperMapper.insert(single);
		}
		return true;
	}
	@Override
	public List<Ques_Paper_Mapper> getMappersByPaperid(Integer paper_id) {
		Ques_Paper_MapperExample example=new Ques_Paper_MapperExample();
       Criteria criteria = example.createCriteria();
       criteria.andPaperIdEqualTo(paper_id);
       List<Ques_Paper_Mapper> mappers=ques_Paper_MapperMapper.selectByExample(example);
		return mappers;
	}

}
