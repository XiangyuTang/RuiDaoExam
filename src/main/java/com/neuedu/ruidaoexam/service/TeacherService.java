package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.entity.Teacher;

public interface TeacherService {
	int registTeacher(Teacher teacher);
	String getTeacherNameByPaper(Integer created_id);//lb增加 学生index页面要用到
	int addPoint(Integer teacherid,Integer addNum);//0626 by lb 卖卷子或者题库成功时候可以用到
	int degradePoint(Integer teacherid,Integer degradeNum);//0626 by lb 购买时用到
	
	List<QuestionBank> getSelledBanksByTeacherid(Integer teacher_id);//获得卖出的题库
	
	int cancelSellBank(Integer bank_id,Integer teacher_id);//0627 取消贩卖题库 By lb
	

	List<Paper> getSelledPapersByTeacherid(Integer teacher_id);
	
	int cancelSellPaper(Integer paper_id,Integer teacher_id);//0627取消出售 by lb
	
	int sellPaper(Integer paper_id,Integer price,Integer teacher_id);//0627出售试卷
	
	int sellBank(Integer bank_id,Integer price,Integer teacher_id);//0627出售题库
	
	Boolean buyBanks(Integer buyer_id,  Integer bank_id);
	
	List<QuestionBank> getUnselledBankByTeacherid(Integer teacher_id);
	 
	List<Paper> getUnselledPaperByTeacherid(Integer teacher_id);
	
	public Teacher getTeacher(Integer teacherid) ;

}

