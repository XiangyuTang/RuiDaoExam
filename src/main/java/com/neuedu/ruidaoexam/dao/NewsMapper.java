package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.News;
import com.neuedu.ruidaoexam.entity.NewsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface NewsMapper {
    int countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(Integer newsId);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    //查询学生是否有新消息
    Integer countStudentReceiveNews(Integer receive_student_id);
    //查询老师是否有新消息
    Integer countTeacherReceiveNews(Integer receive_teacher_id);
    //查询所有老师的消息
    List<News> getAllTeacherNews(Integer receive_teacher_id);
    //查询所有学生的消息
    List<News> getAllStudentNews(Integer receive_student_id);
    //根据教师id改变其信息的未读状态
    Integer updateIsReadByTeacher_id(Integer receive_teacher_id);
    //根据学生id改变其信息未读状态
    Integer updateIsReadByStudent_id(Integer receive_student_id);
}