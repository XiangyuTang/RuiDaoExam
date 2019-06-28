package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.QuestionBank;

public interface QuestionBankService {
	//通过老师id查询其创建的题库
	List<QuestionBank> getQusetionBankByTeacherid(Integer Teacher_id);
	//删除题库
	int deleteBankByBankId(Integer Bank_id);
    List<QuestionBank> getAllSelledBanks(Integer teacherid);//0626 lb 商城展示页 展示所有已卖出的题库
	
	List<QuestionBank> getCertainTypeSelledBanks(Integer type,Integer teacherid); //0626 lb 商城展示页 展示特定类别要卖出的题库
	
	Integer addQuestBank(QuestionBank bank);//增加并返回ID
	
	List<QuestionBank> keywordSearchBank(String keyword,Integer teacherid);//通过关键字搜索
}
