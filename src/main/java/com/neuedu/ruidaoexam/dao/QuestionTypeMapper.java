package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.QuestionType;
import com.neuedu.ruidaoexam.entity.QuestionTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface QuestionTypeMapper {
    int countByExample(QuestionTypeExample example);

    int deleteByExample(QuestionTypeExample example);

    int deleteByPrimaryKey(Integer quesTypeId);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    List<QuestionType> selectByExample(QuestionTypeExample example);

    QuestionType selectByPrimaryKey(Integer quesTypeId);

    int updateByExampleSelective(@Param("record") QuestionType record, @Param("example") QuestionTypeExample example);

    int updateByExample(@Param("record") QuestionType record, @Param("example") QuestionTypeExample example);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
}