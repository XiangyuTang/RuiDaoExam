package com.neuedu.ruidaoexam.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.dao.TeacherMapper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.Teacher;
import com.neuedu.ruidaoexam.service.LogAndRegService;
import com.neuedu.ruidaoexam.test.MyBatisSessionFactory;
@Service
public class LogAndRegServiceimpl implements LogAndRegService {

	SqlSession session = MyBatisSessionFactory.getSession();
	
	@Autowired StudentMapper studentmapper;
	@Autowired TeacherMapper teachermapper;
	
	@Override
	public int register(Object o) {
		if(o instanceof Teacher) {
			int i=teachermapper.insertSelective((Teacher)o);
			return i;
		}else {
			int i=studentmapper.insertSelective((Student)o);
			return i;
		}
	}

	/*
	 * 方法：登录
	 * 详细：调用checkUser方法
	 * 返回：1-老师;2-学生;0-用户不存在
	 */
	@Override
	public int login(String username,String password) {
		return checkUser(username, password);
	}

	
	
	/*
	 * 方法：检查邮箱是否存在
	 * 详细：无
	 * 返回：true存在，false不存在
	 */
	@Override
	public Boolean checkEmail(String email) {
		Student student=studentmapper.selectByEmail(email);
		Teacher teacher=teachermapper.selectByEmail(email);
		if(student==null&&teacher==null) {
			return false;
			
		}
		
		return true;
	}

	/*
	 * 方法：检查用户是否存在
	 * 详细：判断邮箱登录还是用户名登录，并检查用户是学生还是老师
	 * 返回：1,3-老师(email或邮箱);2,4-学生;0-用户不存在
	 */
	@Override
	public int checkUser(String username, String password) {
		
		if(isEmail(username)) {
			if(teachermapper.selectByEmailPassword(username, password) != null) {
				return 1;
			}else if(studentmapper.selectByEmailPassword(username, password) != null) {
				return 2;
			}else {
				return 0;
			}
		}else {
			if(teachermapper.selectByNamePassword(username, password) != null) {
				return 1;
			}else if(studentmapper.selectByNamePassword(username, password) != null) {
				return 2;
			}else {
				return 0;
			}
		}
	}

	/*
	 * 方法：检查用户是否存在
	 * 详细：根据用户名判断用户是否存在
	 * 返回：true存在，false不存在
	 */
	@Override
	public Boolean checkUsername(String username) {
		Student student=studentmapper.selectByName(username);
		Teacher teacher=teachermapper.selectByName(username);
		if(student==null&&teacher==null) {
			return false;
			
		}
		return true;
	}

	/*
	 * 方法：重置密码
	 * 详细：无
	 * 返回：true成功，false失败
	 */
	@Override
	public Boolean resetUserpassword(String email, String password) {
		
		return null;
	}

	/*
	 * 方法：检查邮箱格式是否正确
	 * 详细：无
	 * 返回：true邮箱，false非邮箱
	 */
	@Override
	public Boolean isEmail(String email) {
		if(email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")){
		return true;
		} else {
		return false;
		}
	}
	/*
	 * 方法：得到用户对象
	 * 详细：根据邮箱/用户名和密码，得到该用户对象
	 * 返回：student或teacher对象
	 */
	@Override
	public Object getUser(String username, String password) {
		if(isEmail(username)) {
			return teachermapper.selectByEmailPassword(username, password) != null?
					teachermapper.selectByEmailPassword(username, password):
					studentmapper.selectByEmailPassword(username, password);
		}else {
			return teachermapper.selectByNamePassword(username, password) != null?
					teachermapper.selectByNamePassword(username, password):
					studentmapper.selectByNamePassword(username, password);
		}
	}

	
}
