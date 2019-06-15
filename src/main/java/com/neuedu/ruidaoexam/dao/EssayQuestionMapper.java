package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EssayQuestionMapper {
    int countByExample(EssayQuestionExample example);

    int deleteByExample(EssayQuestionExample example);

    int deleteByPrimaryKey(Integer quesAnsId);

    int insert(EssayQuestion record);

    int insertSelective(EssayQuestion record);

    List<EssayQuestion> selectByExample(EssayQuestionExample example);

    EssayQuestion selectByPrimaryKey(Integer quesAnsId);

    int updateByExampleSelective(@Param("record") EssayQuestion record, @Param("example") EssayQuestionExample example);

    int updateByExample(@Param("record") EssayQuestion record, @Param("example") EssayQuestionExample example);

    int updateByPrimaryKeySelective(EssayQuestion record);

    int updateByPrimaryKey(EssayQuestion record);
}