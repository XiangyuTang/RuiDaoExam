package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.GradeListVO;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.StudentDataVO;
import com.neuedu.ruidaoexam.service.PaperService;
import com.neuedu.ruidaoexam.service.ReportService;
import com.neuedu.ruidaoexam.service.StudentService;

@Controller


public class StudentIndexController {
	
	@Autowired StudentService studentservice;
	@Autowired PaperService paperservice;
	@Autowired ReportService reportservice;
	
	@PostMapping("/getGradelist")
	@ResponseBody
	public List<GradeListVO> getGradelist(HttpServletRequest request) {
		HttpSession session=request.getSession();
//	System.out.println(session.getAttribute("uid"));
		List<Report> gradeList=studentservice.getGradeList((Integer)session.getAttribute("uid"));
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
		return studentservice.getStudentIndexData((Integer)session.getAttribute("uid"));
	}

}
