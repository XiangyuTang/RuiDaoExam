package com.neuedu.ruidaoexam.service;

import java.util.ArrayList;

import com.neuedu.ruidaoexam.exportExcel.HeadName;
import com.neuedu.ruidaoexam.exportExcel.dataName;

public interface ExcelExportService {
	//根据paper——ID查找answerquestion，得到学生id和answerpaper——id
	ArrayList<ArrayList<String>> sIdAndAPId( int paper_id);
	
	//根据answer——paper-id取出所有的answered-question的所有属性
	ArrayList<ArrayList<String>> allAnswerQuestion(int ans_paper_id);
	
	//组合出供导出答题详情excel的数据
	ArrayList<String> sheetNames();
	ArrayList<HeadName> headNames();
	ArrayList<dataName>  dataNames(int paper_id);
	
	//组合导出总表的excel的数据
	ArrayList<String> allSheetNames();
	ArrayList<HeadName> allHeadNames();
	ArrayList<dataName> allDataNames(int paper_id);
}
