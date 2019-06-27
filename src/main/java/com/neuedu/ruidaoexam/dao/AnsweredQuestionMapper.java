package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.AnsweredQuestion;
import com.neuedu.ruidaoexam.entity.AnsweredQuestionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AnsweredQuestionMapper {
    int countByExample(AnsweredQuestionExample example);

    int deleteByExample(AnsweredQuestionExample example);

    int deleteByPrimaryKey(Integer answerId);

    int insert(AnsweredQuestion record);

    int insertSelective(AnsweredQuestion record);

    List<AnsweredQuestion> selectByExample(AnsweredQuestionExample example);

    AnsweredQuestion selectByPrimaryKey(Integer answerId);

    int updateByExampleSelective(@Param("record") AnsweredQuestion record, @Param("example") AnsweredQuestionExample example);

    int updateByExample(@Param("record") AnsweredQuestion record, @Param("example") AnsweredQuestionExample example);

    int updateByPrimaryKeySelective(AnsweredQuestion record);

    int updateByPrimaryKey(AnsweredQuestion record);

	int updateAndInsert(AnsweredQuestion aq);

	int selectPrimeKey(Integer paperResultId, Integer quesType, Integer quesId);
	
	int selectAcquiredScore(Integer paperResultId);
}