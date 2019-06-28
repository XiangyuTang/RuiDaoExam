 package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.StudentExample;
import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

	Student getStudentByEmail(String email);
	
	
    /*
     * 19/6/21 by王重阳
     * 备注：增加了selectByEmail,selectByName,selectByEmailPassword,
     * selectByNamePassword
     * 
     */
    Student selectByEmail(String email);
    
    Student selectByName(String name);
    
    Student selectByEmailPassword(String email,String password);
    
    Student selectByNamePassword(String name,String password);
    
    List<Paper> showNotAnswered(Integer stuid);//19/06/24 by lb 获得未答试卷的列表
    //选取studentid在student_idlist中的对象
    List<Student> getStudentsinList(List<Integer> student_idList);
}