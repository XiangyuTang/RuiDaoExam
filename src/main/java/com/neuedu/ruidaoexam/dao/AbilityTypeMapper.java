package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.AbilityType;

import com.neuedu.ruidaoexam.entity.AbilityTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AbilityTypeMapper {
    int countByExample(AbilityTypeExample example);

    int deleteByExample(AbilityTypeExample example);

    int deleteByPrimaryKey(Integer abilityTypeId);

    int insert(AbilityType record);

    int insertSelective(AbilityType record);

    List<AbilityType> selectByExample(AbilityTypeExample example);

    AbilityType selectByPrimaryKey(Integer abilityTypeId);

    int updateByExampleSelective(@Param("record") AbilityType record, @Param("example") AbilityTypeExample example);

    int updateByExample(@Param("record") AbilityType record, @Param("example") AbilityTypeExample example);

    int updateByPrimaryKeySelective(AbilityType record);

    int updateByPrimaryKey(AbilityType record);
}