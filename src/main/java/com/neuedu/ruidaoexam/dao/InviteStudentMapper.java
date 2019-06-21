package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.InviteStudentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface InviteStudentMapper {
    int countByExample(InviteStudentExample example);

    int deleteByExample(InviteStudentExample example);

    int deleteByPrimaryKey(Integer inviteId);

    int insert(InviteStudent record);

    int insertSelective(InviteStudent record);

    List<InviteStudent> selectByExample(InviteStudentExample example);

    InviteStudent selectByPrimaryKey(Integer inviteId);

    int updateByExampleSelective(@Param("record") InviteStudent record, @Param("example") InviteStudentExample example);

    int updateByExample(@Param("record") InviteStudent record, @Param("example") InviteStudentExample example);

    int updateByPrimaryKeySelective(InviteStudent record);

    int updateByPrimaryKey(InviteStudent record);
}