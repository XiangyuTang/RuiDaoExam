package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.Ques_Bank_Mapper;
public interface BankMapperService {
	int addMapper(Ques_Bank_Mapper mapper);//增加记录
	List<Ques_Bank_Mapper> getMappersByPaperid(Integer bank_id);//根据paperid获取题库的题目信息
    Boolean copyMapper(Integer bank_id,List<Ques_Bank_Mapper> oldMappers);//判断是否复制成功

}
