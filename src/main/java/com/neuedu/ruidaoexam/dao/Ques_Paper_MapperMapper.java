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
    
    int countQuestionNum(Integer paperId);	//取试卷中试题总数
    
    int countKeGuanQuestionNum(Integer paperId);	//取试卷中客观题总数
    
    int countZhuGuanQuestionNum(Integer paperId);	//取试卷中主观题总数
    
    List<Ques_Paper_Mapper> selectXuanZeByPaperId(Integer paperId);
    
    List<Ques_Paper_Mapper> selectPanDuanByPaperId(Integer paperId);
    
    List<Ques_Paper_Mapper> selectTianKongByPaperId(Integer paperId);
    
    List<Ques_Paper_Mapper> selectWenDaByPaperId(Integer paperId);
    
    int countXuanZeNum(Integer paperId);
    
    int countPanDuanNum(Integer paperId);
    
    int countTianKongNum(Integer paperId);
    
    int countWenDaNum(Integer paperId);
}