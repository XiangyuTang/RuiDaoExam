package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.Ques_Paper_Mapper;
import com.neuedu.ruidaoexam.entity.Ques_Paper_MapperExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Ques_Paper_MapperMapper {
    int countByExample(Ques_Paper_MapperExample example);

    int deleteByExample(Ques_Paper_MapperExample example);

    int deleteByPrimaryKey(Integer mapperId);

    int insert(Ques_Paper_Mapper record);

    int insertSelective(Ques_Paper_Mapper record);

    List<Ques_Paper_Mapper> selectByExample(Ques_Paper_MapperExample example);

    Ques_Paper_Mapper selectByPrimaryKey(Integer mapperId);

    int updateByExampleSelective(@Param("record") Ques_Paper_Mapper record, @Param("example") Ques_Paper_MapperExample example);

    int updateByExample(@Param("record") Ques_Paper_Mapper record, @Param("example") Ques_Paper_MapperExample example);

    int updateByPrimaryKeySelective(Ques_Paper_Mapper record);

    int updateByPrimaryKey(Ques_Paper_Mapper record);
}