package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.Ques_Bank_Mapper;
import com.neuedu.ruidaoexam.entity.Ques_Bank_MapperExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Ques_Bank_MapperMapper {
    int countByExample(Ques_Bank_MapperExample example);

    int deleteByExample(Ques_Bank_MapperExample example);

    int deleteByPrimaryKey(Integer mapperId);

    int insert(Ques_Bank_Mapper record);

    int insertSelective(Ques_Bank_Mapper record);

    List<Ques_Bank_Mapper> selectByExample(Ques_Bank_MapperExample example);

    Ques_Bank_Mapper selectByPrimaryKey(Integer mapperId);

    int updateByExampleSelective(@Param("record") Ques_Bank_Mapper record, @Param("example") Ques_Bank_MapperExample example);

    int updateByExample(@Param("record") Ques_Bank_Mapper record, @Param("example") Ques_Bank_MapperExample example);

    int updateByPrimaryKeySelective(Ques_Bank_Mapper record);

    int updateByPrimaryKey(Ques_Bank_Mapper record);
}