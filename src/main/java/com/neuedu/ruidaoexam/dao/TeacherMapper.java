package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.Teacher;
import com.neuedu.ruidaoexam.entity.TeacherExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TeacherMapper {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    /*
     * 19/6/21 by王重阳
     * 备注：增加了selectByEmail,selectByName,selectByEmailPassword,
     * selectByNamePassword
     * 
     */
    Teacher selectByEmail(String email);
    
    Teacher selectByName(String name);
    
    Teacher selectByEmailPassword(String email,String password);
    
    Teacher selectByNamePassword(String name,String password);
    
    int addPoint(Integer teacherid,Integer addnum);// 06/26 by lb 增加积分（可能用到）
    
    int degradePoint(Integer teacherid,Integer degradeNum);// 06/26 by lb减少积分（购买时候用到）
}