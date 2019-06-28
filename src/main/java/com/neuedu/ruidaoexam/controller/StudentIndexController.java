package com.neuedu.ruidaoexam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.GradeListVO;
import com.neuedu.ruidaoexam.entity.NotAnsweredDataVO;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.StudentDataVO;
import com.neuedu.ruidaoexam.service.PaperService;
import com.neuedu.ruidaoexam.service.ReportService;
import com.neuedu.ruidaoexam.service.StudentService;
import com.neuedu.ruidaoexam.service.TeacherService;

@Controller


public class StudentIndexController {
	
	@Autowired StudentService studentservice;
	@Autowired PaperService paperservice;
	@Autowired ReportService reportservice;
	@Autowired TeacherService teacherservice;
	
	@PostMapping("/getGradelist")
	@ResponseBody
	public List<GradeListVO> getGradelist(HttpServletRequest request) {
		HttpSession session=request.getSession();
//	System.out.println(session.getAttribute("uid"));
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		List<Report> gradeList=studentservice.getGradeList(uid_new);
		List<GradeListVO> voInfos=new ArrayList<GradeListVO>();
		for (Report report : gradeList) {
			GradeListVO vo = new GradeListVO();
			vo.setPaper_name(paperservice.getPaper_name(reportservice.getPaper_id(report.getReportId())));
			vo.setPaper_id(report.getPaperId());
			vo.setScore(report.getAcquiredScore()+"");
			voInfos.add(vo);
		}
		return voInfos;
	
		
	}
	
	@PostMapping("/getStudentIndexData")
	@ResponseBody
	public StudentDataVO getStudentIndexData(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Integer stuid = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());	  int numberOfanswered=studentservice.getNumberofAnswered(stuid);
	  int numberOfNotAnswered=studentservice.getNumberofNotAnswered(stuid);
	  List<Paper> notAnsweredPaper=studentservice.getNotAnsweredList(stuid);
	  List<NotAnsweredDataVO> notAnsweredData=new ArrayList<NotAnsweredDataVO>();
	  for (Paper paper : notAnsweredPaper) {
		  NotAnsweredDataVO vo1=new NotAnsweredDataVO();
		  vo1.setCreatedTeacher(teacherservice.getTeacherNameByPaper(paper.getCreatedbyteacherid()));
		  vo1.setPaperTime(paper.getPaperTime());
		  vo1.setPaperName(paper.getPaperName());
		  vo1.setPaperID(paper.getPaperId());
		  notAnsweredData.add(vo1);
	}
	  StudentDataVO vo2=new StudentDataVO();
	  vo2.setNumberOfAnswered(numberOfanswered);
	  vo2.setNumberOfNotAnswered(numberOfNotAnswered);
	  vo2.setNotAnsweredPapers(notAnsweredData);
	  return vo2;
	}
	
	
	
	@PostMapping("/showBoughtPapers")
	@ResponseBody
	public List<Map<String,Object>> showBoughtPapers(HttpServletRequest request) {
		Integer stuid = Integer.parseInt(String.valueOf(request.getSession().getAttribute("uid")).trim());
		 List<Map<String,Object>> resultList=new ArrayList<Map<String,Object>>();
		 List<Map<String,Object>> boughtPapers = studentservice.getBoughtPapers(stuid);
		 for (Map<String,Object> maps : boughtPapers) {
			for(Map.Entry<String,Object> map :maps.entrySet()) {
				System.out.println(map.getKey() + map.getValue());
				if(map.getKey().equals("seller_id"))
					map.setValue(teacherservice.getTeacherNameByPaper((Integer)map.getValue()));
				if(map.getKey().contentEquals("time")) {
					SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy:MM:dd HH:mm:ss" ); 

			        String str = sdf.format(map.getValue()); 
					map.setValue(str);
				}
				
					
				
			}
			resultList.add(maps);
		}
		return resultList;
		 
		 
		
	}

}
