package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.Ques_Paper_Mapper;

public interface PaperMapperService {
	int addMapper(Ques_Paper_Mapper mapper);
	List<Ques_Paper_Mapper> getMappersByPaperid(Integer paper_id);//通过id获取所有的题
    Boolean copyMapper(Integer paper_id,List<Ques_Paper_Mapper> oldMappers);//复制试卷
}
