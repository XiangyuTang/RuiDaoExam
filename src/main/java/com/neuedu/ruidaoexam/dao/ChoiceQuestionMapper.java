package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ChoiceQuestionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChoiceQuestionMapper {
    int countByExample(ChoiceQuestionExample example);

    int deleteByExample(ChoiceQuestionExample example);

    int deleteByPrimaryKey(Integer choiceQuesId);

    int insert(ChoiceQuestion record);

    int insertSelective(ChoiceQuestion record);

    List<ChoiceQuestion> selectByExample(ChoiceQuestionExample example);

    ChoiceQuestion selectByPrimaryKey(Integer choiceQuesId);

    int updateByExampleSelective(@Param("record") ChoiceQuestion record, @Param("example") ChoiceQuestionExample example);

    int updateByExample(@Param("record") ChoiceQuestion record, @Param("example") ChoiceQuestionExample example);

    int updateByPrimaryKeySelective(ChoiceQuestion record);

    int updateByPrimaryKey(ChoiceQuestion record);
    //根据在list中的id值选取问题
    List<ChoiceQuestion> selectByidInList(List<Integer> choice_id_list);
    
    int insertAndGetId(ChoiceQuestion record);
}