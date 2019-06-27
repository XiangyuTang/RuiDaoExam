package com.neuedu.ruidaoexam.service;

import java.util.ArrayList;

import com.neuedu.ruidaoexam.entity.ForChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ForJudgeQuestion;
import com.neuedu.ruidaoexam.entity.ForTianKongQuestion;
import com.neuedu.ruidaoexam.entity.ForWenDaQuestion;

public interface ReportService {
	void addComment(ArrayList<String> reportArray);	//教师发布报告评语

	void deleteReport(int report_id);	//教师删除报告
	
	int getPaper_id(int report_id);//获得对应的试卷id
	
	ArrayList<String> getJiBenXinXi(int report_id);	//呈现基本信息
	
	ArrayList<String> getQuanMianGaiKuo(int report_id);	//呈现全面概括 
	
	ArrayList<ForChoiceQuestion> getXuanZeDaTiQingKuang(int report_id);	//呈现选择题答题情况
	
	ArrayList<ForJudgeQuestion> getPanDuanDaTiQingKuang(int report_id);	//呈现判断题答题情况
	
	ArrayList<ForTianKongQuestion> getTianKongDaTiQingKuang(int report_id);	//呈现填空题答题情况
	
	ArrayList<ForWenDaQuestion> getWenDaDaTiQingKuang(int report_id);	//呈现问答题答题情况
}
