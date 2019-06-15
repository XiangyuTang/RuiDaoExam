package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.entity.QuestionBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionBankMapper {
    int countByExample(QuestionBankExample example);

    int deleteByExample(QuestionBankExample example);

    int deleteByPrimaryKey(Integer quesBankId);

    int insert(QuestionBank record);

    int insertSelective(QuestionBank record);

    List<QuestionBank> selectByExample(QuestionBankExample example);

    QuestionBank selectByPrimaryKey(Integer quesBankId);

    int updateByExampleSelective(@Param("record") QuestionBank record, @Param("example") QuestionBankExample example);

    int updateByExample(@Param("record") QuestionBank record, @Param("example") QuestionBankExample example);

    int updateByPrimaryKeySelective(QuestionBank record);

    int updateByPrimaryKey(QuestionBank record);
}