package com.neuedu.ruidaoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.AnsweredPaperMapper;
import com.neuedu.ruidaoexam.dao.AnsweredQuestionMapper;
import com.neuedu.ruidaoexam.dao.ReportMapper;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.entity.AnsweredPaper;
import com.neuedu.ruidaoexam.entity.AnsweredQuestion;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.exportExcel.HeadName;
import com.neuedu.ruidaoexam.exportExcel.dataName;
import com.neuedu.ruidaoexam.service.ExcelExportService;

@Service
public class ExcelExportServiceimpl implements ExcelExportService{
	
	@Autowired
	AnsweredPaperMapper answeredPaperMapper;
	
	@Autowired
	AnsweredQuestionMapper answeredQuestionMapper;
	
	@Autowired
	StudentMapper  studentMapper;
	
	@Autowired
	ReportMapper reportMapper;
	
	@Override
	public ArrayList<ArrayList<String>> sIdAndAPId(int paper_id) {
		// TODO Auto-generated method stub
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<ArrayList<String>> saa = new ArrayList<ArrayList<String>>();
		List<AnsweredPaper> ap = answeredPaperMapper.selectByPaperId(paper_id);
		System.out.println("ppppppppppppppppppppppp"+ap.size());
		for(int i=0; i<ap.size();i++) {
			array.add(0,ap.get(i).getStuId().toString());
			System.out.println("eeeeeeeee"+ap.get(i).getStuId().toString());
			array.add(1,ap.get(i).getAnsPaperId().toString());
			saa.add(array);
		}
		System.out.println("ppppppppppppppppppppppp"+saa.size());
		return saa;
	}

	@Override
	public ArrayList<ArrayList<String>> allAnswerQuestion(int ans_paper_id) {
		// TODO Auto-generated method stub
		ArrayList<String> array = new  ArrayList<String>();
		ArrayList<ArrayList<String>> allAQ = new ArrayList<ArrayList<String>>();
		List<AnsweredQuestion> aq = answeredQuestionMapper.selectAllByAnsPaperId(ans_paper_id);
		for(int i=0; i<aq.size();i++) {
			if(aq.get(i).getQuesType()==1||aq.get(i).getQuesType()==2) {
				array.add(0,aq.get(i).getAnswerId().toString());
				array.add(1,aq.get(i).getPaperResultId().toString());
				array.add(2,aq.get(i).getQuesType().toString());
				array.add(3, aq.get(i).getCqId().toString());
//				array.add(4, aq.get(i).getEqId().toString());
//				array.add(5,aq.get(i).getJqId().toString());
				array.add(4,aq.get(i).getAnswer().toString());
				array.add(5,aq.get(i).getRightAnswer().toString());
				array.add(6,aq.get(i).getScore().toString());
				array.add(7,aq.get(i).getTotalScore().toString());
				allAQ.add(array);
			}else if(aq.get(i).getQuesType()==3||aq.get(i).getQuesType()==5) {
				array.add(0,aq.get(i).getAnswerId().toString());
				array.add(1,aq.get(i).getPaperResultId().toString());
				array.add(2,aq.get(i).getQuesType().toString());
//				array.add(3, aq.get(i).getCqId().toString());
				array.add(3, aq.get(i).getEqId().toString());
//				array.add(5,aq.get(i).getJqId().toString());
				array.add(4,aq.get(i).getAnswer().toString());
				array.add(5,aq.get(i).getRightAnswer().toString());
				array.add(6,aq.get(i).getScore().toString());
				array.add(7,aq.get(i).getTotalScore().toString());
				allAQ.add(array);
			}else {
				array.add(0,aq.get(i).getAnswerId().toString());
				array.add(1,aq.get(i).getPaperResultId().toString());
				array.add(2,aq.get(i).getQuesType().toString());
//				array.add(3, aq.get(i).getCqId().toString());
//				array.add(4, aq.get(i).getEqId().toString());
				array.add(3,aq.get(i).getJqId().toString());
				array.add(4,aq.get(i).getAnswer().toString());
				array.add(5,aq.get(i).getRightAnswer().toString());
				array.add(6,aq.get(i).getScore().toString());
				array.add(7,aq.get(i).getTotalScore().toString());
				allAQ.add(array);
			}
			
		}
		return allAQ;
	}

	@Override
	public ArrayList<String> sheetNames() {
		// TODO Auto-generated method stub
		String sheet1 = "总分";
		String sheet2 = "客观题得分";
		String sheet3 = "主观题得分";
		ArrayList<String> sheetNames = new ArrayList<String>();
		sheetNames.add(sheet1);
		sheetNames.add(sheet2);
		sheetNames.add(sheet3);
		return sheetNames;
	}
	
	@Override
	public ArrayList<String> allSheetNames() {
		// TODO Auto-generated method stub
		String sheet1="总汇报";
		ArrayList<String> sheetNames = new ArrayList<String>();
		sheetNames.add(sheet1);
		return sheetNames;
	}
	
	@Override
	public ArrayList<HeadName> allHeadNames() {
		// TODO Auto-generated method stub
		String hn1 = "姓名";
		String hn2 = "身份ID";
		String hn3 = "测试得分";
		String hn4 = "开始时间";
		String hn5 = "交卷时间";
		ArrayList<String> hns = new ArrayList<String>();
		hns.add(hn1);
		hns.add(hn2);
		hns.add(hn3);
		hns.add(hn4);
		hns.add(hn5);
		HeadName hd = new HeadName();
		hd.setHeadName(hns);
		ArrayList<HeadName> hds = new ArrayList<HeadName>();
		hds.add(hd);
		return hds;
	}
	
	@Override
	public ArrayList<dataName> allDataNames(int paper_id) {
		// TODO Auto-generated method stub
		
//		dataName dn1 = new dataName();
		ArrayList<ArrayList<String>> result1 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> siapi = sIdAndAPId(paper_id);
		
		for(int i=0; i<siapi.size(); i++) {
			Student s = studentMapper.selectByPrimaryKey(Integer.parseInt(siapi.get(i).get(0)));
			List<Report> reports = reportMapper.selectByPaperId(paper_id);
			ArrayList<String> array = new ArrayList<String>();
			for(int j=0; j<reports.size();j++) {
				if(s.getStudentId()==reports.get(j).getStuId()) {
					array.add(s.getName());
					array.add(s.getEmail());
					array.add(reports.get(j).getAcquiredScore().toString());
					array.add(reports.get(j).getBeginTimestamp().toString());
					array.add(reports.get(j).getEndTimestamp().toString());
				}
			}
			result1.add(array);
		}
		dataName dt = new dataName();
		dt.setDatas(result1);
		ArrayList<dataName> dns = new ArrayList<dataName>();
		dns.add(dt);
		return dns;
	}

	@Override
	public ArrayList<HeadName> headNames() {
		// TODO Auto-generated method stub
		String hn11 = "姓名";
		String hn12 = "身份ID";
		String hn13 = "测试得分";
		ArrayList<String> hn1s = new ArrayList<String>();
		hn1s.add(hn11);
		hn1s.add(hn12);
		hn1s.add(hn13);
		HeadName hn1 = new HeadName();
		hn1.setHeadName(hn1s);
		
		
		String hn21 = "姓名";
		String hn22 = "身份ID";
		String hn23 = "客观题分数";
		ArrayList<String> hn2s = new ArrayList<String>();
		hn2s.add(hn21);
		hn2s.add(hn22);
		hn2s.add(hn23);
		HeadName hn2 = new HeadName();
		hn2.setHeadName(hn2s);
		
		String hn31 = "姓名";
		String hn32 = "身份ID";
		String hn33 = "主观题分数";
		ArrayList<String> hn3s = new ArrayList<String>();
		hn3s.add(hn31);
		hn3s.add(hn32);
		hn3s.add(hn33);
		HeadName hn3 = new HeadName();
		hn3.setHeadName(hn3s);
		
		ArrayList<HeadName> headNames = new ArrayList<HeadName>();
		headNames.add(hn1);
		headNames.add(hn2);
		headNames.add(hn3);
		return headNames;
	}

	@Override
	public ArrayList<dataName> dataNames(int paper_id) {
		// TODO Auto-generated method stub
		dataName dn1 = new dataName();
		ArrayList<ArrayList<String>> result1 = new ArrayList<ArrayList<String>>();
		dataName dn2 = new dataName();
		ArrayList<ArrayList<String>> result2 = new ArrayList<ArrayList<String>>();
		dataName dn3 = new dataName();
		ArrayList<ArrayList<String>> result3 = new ArrayList<ArrayList<String>>();
		//stuID和answeredPaperId
		ArrayList<ArrayList<String>> siapi = sIdAndAPId(paper_id);
		System.out.println("siapi"+siapi.size());
		for(int i=0; i<siapi.size();i++) {
			Student s = studentMapper.selectByPrimaryKey(Integer.parseInt(siapi.get(i).get(0)));
			ArrayList<ArrayList<String>> ansQues = allAnswerQuestion(Integer.parseInt(siapi.get(i).get(1)));
			ArrayList<String> array1 = new ArrayList<String>();
			ArrayList<String> array2 = new ArrayList<String>();
			ArrayList<String> array3 = new ArrayList<String>();
			int totalAcqScore = 0;
			int objAcqScore = 0;
			int subAcqScore = 0;
			System.out.println("ansQues"+ansQues.size());
			for(int j=0; j<ansQues.size(); j++) {
				totalAcqScore = totalAcqScore+Integer.parseInt(ansQues.get(j).get(6));
				if(Integer.parseInt(ansQues.get(j).get(2))==1||Integer.parseInt(ansQues.get(j).get(2))==2||Integer.parseInt(ansQues.get(j).get(2))==4) {
					objAcqScore = objAcqScore+Integer.parseInt(ansQues.get(j).get(6));
				}
				if(Integer.parseInt(ansQues.get(j).get(2))==3||Integer.parseInt(ansQues.get(j).get(2))==5) {
					subAcqScore = subAcqScore+Integer.parseInt(ansQues.get(j).get(6));
				}
			}
			array1.add(s.getName());
			array1.add(s.getEmail());
			array1.add(Integer.toString(totalAcqScore));
			result1.add(array1);
			
			array2.add(s.getName());
			array2.add(s.getName());
			array2.add(Integer.toString(objAcqScore));
			result2.add(array2);
			
			array3.add(s.getName());
			array3.add(s.getEmail());
			array3.add(Integer.toString(subAcqScore));
			result3.add(array3);
		}
		dn1.setDatas(result1);
		dn2.setDatas(result2);
		dn3.setDatas(result3);
		ArrayList<dataName> dns = new ArrayList<dataName>();
		dns.add(dn1);
		dns.add(dn2);
		dns.add(dn3);
		System.out.println("hhhhaaaahhhhaaaa"+dns.size());
		return dns;
	}


	

	

	
	
	
}
