package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.entity.QuestionBankExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
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
    
    int cancelSellBank(Integer bankid,Integer teacherid);
    
    int sellBank(Integer bankid,Integer price,Integer teacherid);//贩卖卷子
    
    int addBank(QuestionBank bank);// lb 获取bank新增后的返回值
}