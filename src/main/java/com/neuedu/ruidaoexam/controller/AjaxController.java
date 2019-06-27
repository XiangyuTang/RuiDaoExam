package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.neuedu.ruidaoexam.entity.AnsweredQuestion;
import com.neuedu.ruidaoexam.entity.MsgOfUpdateQuestion;
import com.neuedu.ruidaoexam.service.AnsweredQuestionService;
import com.neuedu.ruidaoexam.service.QuestionService;
import com.neuedu.ruidaoexam.service.ReportService;
import com.neuedu.ruidaoexam.service.impl.QuestionServiceimpl;
import com.neuedu.ruidaoexam.service.impl.ReportServiceimpl;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.excel.test;
@RestController
public class AjaxController {
	
	
	@Autowired
	ReportService reportService;
	@Autowired
	AnsweredQuestionService answeredQuestionService;
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
		
		reportService.addComment(reportArray);
		
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
	    
		reportService.deleteReport(report_id);
		
		return val.get("val").toString();
	}
	
	//每做一个题，更新问题
	@RequestMapping(value="/updateQuestion",method = RequestMethod.POST)
	@ResponseBody
	public String updateQuestion(@RequestBody MsgOfUpdateQuestion msg,HttpSession session) {
		AnsweredQuestion aq = null;
		Integer pk = null;
		int flag = 0;
		if(msg.getQuestype()==1||msg.getQuestype()==2)//单选或者多选
		{
			aq = new AnsweredQuestion(null,msg.getPaperResultId(),msg.getQuestype(),msg.getQuesid(),null,null,
					msg.getAnswer(),msg.getRightanswer(),msg.getScore(),msg.getTotalScore(),msg.getIscorrect());
			
		}
		else if(msg.getQuestype()==4)//判断
		{
			aq = new AnsweredQuestion(null,msg.getPaperResultId(),msg.getQuestype(),null,null,msg.getQuesid(),
					msg.getAnswer(),msg.getRightanswer(),msg.getScore(),msg.getTotalScore(),msg.getIscorrect());
		}
		else
		{
			aq = new AnsweredQuestion(null,msg.getPaperResultId(),msg.getQuestype(),null,msg.getQuesid(),null,
					msg.getAnswer(),msg.getRightanswer(),msg.getScore(),msg.getTotalScore(),msg.getIscorrect());
		}
		int i = 0;
		try {
			pk = answeredQuestionService.selectPrimeKey(aq);
		}catch (org.apache.ibatis.binding.BindingException e) {
			// TODO: handle exception
			i = answeredQuestionService.update(aq);
			flag = 1;
		}
		if(flag == 0)
		{
			aq.setAnswerId(pk);
			i = answeredQuestionService.update(aq);
			System.out.println(i);
		}
		return "666";
	}
	/**
	 * 呈现答题情况
	 * @return
	 */
	@RequestMapping(value = "/getDaTiQingKuang", method = RequestMethod.POST)
	@ResponseBody
	public String getDaTiQingKuang(@RequestBody Map val, HttpServletRequest request) {
		
//		request.getSession().setAttribute("report_id", val.get("val").toString());
//	    String reportId = request.getSession().getAttribute("report_id").toString();
//	    int report_id = Integer.parseInt(reportId);
//		reportServiceimpl.getDaTiQingKuang(report_id);
		
		List<test> list = new ArrayList<test>();
		
		test test = new test();
		test.setEmail("erwerwetwetwt");
		list.add(test);
		HashMap map = new HashMap();
		map.put("shitiList", list);
		String str = JSON.toJSONString(map);
		return str;
		
		//int id = 1;
		//List<Object> shitiList = new ArrayList<Object>();
		//shitiList.add(id);
		//HashMap map = new HashMap();
		//map.put("shitiList", shitiList);
		//String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		//return str; //返回字符串
		
//		return val.get("val").toString();
	}
}
