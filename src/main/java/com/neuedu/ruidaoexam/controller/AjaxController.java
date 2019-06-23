package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.ruidaoexam.service.impl.QuestionServiceimpl;
import com.neuedu.ruidaoexam.service.impl.ReportServiceimpl;

@RestController
public class AjaxController {
	@Autowired
	QuestionServiceimpl questionServiceimpl;
	
	//通过bank_id查询其所属的所有题目并返回前端
	@RequestMapping("/toquestion1")
	public Map<String, List<Object>> test(){
		questionServiceimpl.getQuestionByBankid(2);
		return null;
	}
	
	@Autowired
	ReportServiceimpl reportServiceimpl;
	
	/**
	 * 教师发布报告评语
	 * @return
	 */
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	@ResponseBody
	public String addComment( @RequestBody Map val, HttpServletRequest request) {

		System.out.println(val.get("val").toString());
		request.getSession().setAttribute("pingyu", val.get("val").toString());
		
		String reportId = "1";
		String paperId = "1";
		String stuId = "1";
		String acquiredScore = "10";
		String totalScore = "20";
	    String comment = request.getSession().getAttribute("pingyu").toString();
	    String beginTimestamp = "2019-06-22 14:00:00";
	    String endTimestamp = "2019-06-22 15:00:00";
	    String switchTimes = "3";
	    String  isAllowedToSee = "1";
	    
		ArrayList<String> reportArray = new ArrayList<String>();
		reportArray.add(reportId);
		reportArray.add(paperId);
		reportArray.add(stuId);
		reportArray.add(acquiredScore);
		reportArray.add(totalScore);
		reportArray.add(comment);
		reportArray.add(beginTimestamp);
		reportArray.add(endTimestamp);
		reportArray.add(switchTimes);
		reportArray.add(isAllowedToSee);
		
		reportServiceimpl.addComment(reportArray);
		
		return val.get("val").toString();
	}
	
	/**
	 * 教师删除报告
	 * @return
	 */
	@RequestMapping(value = "/deleteReport", method = RequestMethod.POST)
	@ResponseBody
	public String deleteReport(@RequestBody Map val, HttpServletRequest request) {
		
		request.getSession().setAttribute("report_id", val.get("val").toString());
		
	    String reportId = request.getSession().getAttribute("report_id").toString();
	    
	    int report_id = Integer.parseInt(reportId);
	    
		reportServiceimpl.deleteReport(report_id);
		
		return val.get("val").toString();
	}
}
