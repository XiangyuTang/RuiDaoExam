package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.formula.IStabilityClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.neuedu.ruidaoexam.service.impl.QuestionServiceimpl;
import com.neuedu.ruidaoexam.service.impl.ReportServiceimpl;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.excel.test;

@RestController
public class AjaxController {
//	@Autowired
//	QuestionServiceimpl questionServiceimpl;
//	
//	//通过bank_id查询其所属的所有题目并返回前端
//	@RequestMapping("/toquestion1")
//	public Map<String, List<Object>> test(){
//		questionServiceimpl.getQuestionByBankid(2);
//		return null;
//	}
	
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
	
//	/**
//	 * 呈现基本信息
//	 * @return
//	 */
//	@RequestMapping(value = "/getJiBenXinXi", method = RequestMethod.POST)
//	@ResponseBody
//	public String getJiBenXinXi(@RequestBody Map val, HttpServletRequest request) {
//		
//		request.getSession().setAttribute("report_id", val.get("val").toString());
//	    String reportId = request.getSession().getAttribute("report_id").toString();
//	    int report_id = Integer.parseInt(reportId);
//		reportServiceimpl.getJiBenXinXi(report_id);
//		
//		
//		String sName = studentInfoArrayList.get
//		List<Student> list = new ArrayList<>();
//		list.add(e);
//		
//		
//		return val.get("val").toString();
//	}
//	
//	/**
//	 * 呈现全面概括
//	 * @return
//	 */
//	@RequestMapping(value = "/getQuanMianGaiKuo", method = RequestMethod.POST)
//	@ResponseBody
//	public String getQuanMianGaiKuo(@RequestBody Map val, HttpServletRequest request) {
//		
//		request.getSession().setAttribute("report_id", val.get("val").toString());
//		
//	    String reportId = request.getSession().getAttribute("report_id").toString();
//	    
//	    int report_id = Integer.parseInt(reportId);
//	    
//		reportServiceimpl.getJiBenXinXi(report_id);
//		
//		
//		
//		return val.get("val").toString();
//	}
	
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
