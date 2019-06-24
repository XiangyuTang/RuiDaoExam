package com.neuedu.ruidaoexam.service;

import java.util.ArrayList;

public interface ReportService {
	void addComment(ArrayList<String> reportArray);	//教师发布报告评语

	void deleteReport(int report_id);	//教师删除报告
	
	int getPaper_id(int report_id);//获得对应的试卷id
}
