package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.AnsweredPaper;
import com.neuedu.ruidaoexam.entity.AnsweredPaperExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AnsweredPaperMapper {
    int countByExample(AnsweredPaperExample example);

    int deleteByExample(AnsweredPaperExample example);

    int deleteByPrimaryKey(Integer ansPaperId);

    int insert(AnsweredPaper record);

    int insertSelective(AnsweredPaper record);

    List<AnsweredPaper> selectByExample(AnsweredPaperExample example);

    AnsweredPaper selectByPrimaryKey(Integer ansPaperId);

    int updateByExampleSelective(@Param("record") AnsweredPaper record, @Param("example") AnsweredPaperExample example);

    int updateByExample(@Param("record") AnsweredPaper record, @Param("example") AnsweredPaperExample example);

    int updateByPrimaryKeySelective(AnsweredPaper record);

    int updateByPrimaryKey(AnsweredPaper record);
}