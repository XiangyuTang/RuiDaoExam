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
import com.neuedu.ruidaoexam.service.ModifyPaperService;
import com.neuedu.ruidaoexam.service.QueryAbilityService;
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
	@Autowired
	QueryAbilityService queryAbilityService;
	@Autowired
	ModifyPaperService modifyPaperService;
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

	@RequestMapping(value = "/ajaxModifyScore1", method = RequestMethod.POST)
	@ResponseBody
	public String modifyScore1(@RequestBody Map val, HttpServletRequest request) {
//		System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		String oldScore = val.get("oldScore").toString();
		String newScore = val.get("newScore").toString();
		String getReportId = val.get("getReportId").toString();
		String getAnsPaperId = val.get("getAnsPaperId").toString();
		String getStuId = val.get("getStuId").toString();
		String getChoiceTypeId = val.get("getChoiceTypeId").toString();
		String getChoiceId = val.get("getChoiceId").toString();
		String getScore = val.get("getScore").toString();
		String zongScore = val.get("zongScore").toString();
		String getStuAnswer = val.get("getStuAnswer").toString();
		
		int getReportId1 = Integer.parseInt(getReportId);
		int getAnsPaperId1 = Integer.parseInt(getAnsPaperId);
		int getChoiceId1 = Integer.parseInt(getChoiceId);
		int getScore1 = Integer.parseInt(getScore);
		int oldScore1 = Integer.parseInt(oldScore);
		int newScore1 = Integer.parseInt(newScore);
		int zongScore1 = Integer.parseInt(zongScore);
		getScore1 = getScore1 + (newScore1-oldScore1);
		
		int isCorrect = 0;
		if (newScore1 == zongScore1) {
			isCorrect = 1;
		}
		
//		ArrayList<String> updateScoreArray = new ArrayList<String>();
//		updateScoreArray.add(getReportId);
//		updateScoreArray.add(getScore2);
//				
//		reportService.updateScore(updateScoreArray);
		
//		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		System.out.println(newScore+oldScore);
//		System.out.println(getReportId+getAnsPaperId+getStuId);
//		System.out.println(getChoiceTypeId+getChoiceId);
//		System.out.println(getScore1 +" "+ isCorrect);
		
		modifyPaperService.modifyChoiceQue(getReportId1,getScore1,getAnsPaperId1,getChoiceId1,getStuAnswer,newScore1,isCorrect);
		
		return "";
		
	}
	
	@RequestMapping(value = "/ajaxModifyScore2", method = RequestMethod.POST)
	@ResponseBody
	public String modifyScore2(@RequestBody Map val, HttpServletRequest request) {
//		System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		String oldScore = val.get("oldScore").toString();
		String newScore = val.get("newScore").toString();
		String getReportId = val.get("getReportId").toString();
		String getAnsPaperId = val.get("getAnsPaperId").toString();
		String getStuId = val.get("getStuId").toString();
		String getJudgeTypeId = val.get("getJudgeTypeId").toString();
		String getJudgeId = val.get("getJudgeId").toString();
		String getScore = val.get("getScore").toString();
		String zongScore = val.get("zongScore").toString();
		String getStuAnswer = val.get("getStuAnswer").toString();
		
		int getReportId1 = Integer.parseInt(getReportId);
		int getAnsPaperId1 = Integer.parseInt(getAnsPaperId);
		int getJudgeId1 = Integer.parseInt(getJudgeId);
		int getScore1 = Integer.parseInt(getScore);
		int oldScore1 = Integer.parseInt(oldScore);
		int newScore1 = Integer.parseInt(newScore);
		int zongScore1 = Integer.parseInt(zongScore);
		getScore1 = getScore1 + (newScore1-oldScore1);
		
		int isCorrect = 0;
		if (newScore1 == zongScore1) {
			isCorrect = 1;
		}
		
//		System.out.println("huilaile-------------------"+newScore+oldScore+getReportId+getAnsPaperId+getStuId);
//		System.out.println(getJudgeTypeId+getJudgeId);
//		System.out.println(getScore1 +" "+ isCorrect);
//		System.out.println("判断题"+getStuAnswer);
		
		modifyPaperService.modifyJudgeQue(getReportId1, getScore1, getAnsPaperId1, getJudgeId1, getStuAnswer, newScore1, isCorrect);
	
		return "";
		
	}
	
	
	@RequestMapping(value = "/ajaxModifyScore3", method = RequestMethod.POST)
	@ResponseBody
	public String modifyScore3(@RequestBody Map val, HttpServletRequest request) {
//		System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		String oldScore = val.get("oldScore").toString();
		String newScore = val.get("newScore").toString();
		String getReportId = val.get("getReportId").toString();
		String getAnsPaperId = val.get("getAnsPaperId").toString();
		String getStuId = val.get("getStuId").toString();
		String getTianKongTypeId = val.get("getTianKongTypeId").toString();
		String getTianKongId = val.get("getTianKongId").toString();
		String getScore = val.get("getScore").toString();
		String zongScore = val.get("zongScore").toString();
		
		int getReportId1 = Integer.parseInt(getReportId);
		int getAnsPaperId1 = Integer.parseInt(getAnsPaperId);
		int getEssayId1 = Integer.parseInt(getTianKongId);
		int getScore1 = Integer.parseInt(getScore);
		int oldScore1 = Integer.parseInt(oldScore);
		int newScore1 = Integer.parseInt(newScore);
		int zongScore1 = Integer.parseInt(zongScore);
		getScore1 = getScore1 + (newScore1-oldScore1);
//		System.out.println("===================================="+getScore1);
		int isCorrect = 0;
		if (newScore1 == zongScore1) {
			isCorrect = 1;
		}
		
//		System.out.println("huilaile-------------------"+newScore+oldScore+getReportId+getAnsPaperId+getStuId);
//		System.out.println(getTianKongTypeId+getTianKongId);
//		System.out.println(getScore1 +" "+ isCorrect);
		
		modifyPaperService.modifyEssayQue(getReportId1, getScore1, getAnsPaperId1, getEssayId1, newScore1, isCorrect);
		
		return "";
		
	}
	
	@RequestMapping(value = "/ajaxModifyScore4", method = RequestMethod.POST)
	@ResponseBody
	public String modifyScore4(@RequestBody Map val, HttpServletRequest request) {
//		System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		String oldScore = val.get("oldScore").toString();
		String newScore = val.get("newScore").toString();
		String getReportId = val.get("getReportId").toString();
		String getAnsPaperId = val.get("getAnsPaperId").toString();
		String getStuId = val.get("getStuId").toString();
		String getWenDaTypeId = val.get("getWenDaTypeId").toString();
		String getWenDaId = val.get("getWenDaId").toString();
		String getScore = val.get("getScore").toString();
		String zongScore = val.get("zongScore").toString();
		
		int getReportId1 = Integer.parseInt(getReportId);
		int getAnsPaperId1 = Integer.parseInt(getAnsPaperId);
		int getEssayId1 = Integer.parseInt(getWenDaId);
		int getScore1 = Integer.parseInt(getScore);
		int oldScore1 = Integer.parseInt(oldScore);
		int newScore1 = Integer.parseInt(newScore);
		int zongScore1 = Integer.parseInt(zongScore);
		getScore1 = getScore1 + (newScore1-oldScore1);
		
		int isCorrect = 0;
		if (newScore1 == zongScore1) {
			isCorrect = 1;
		}
		
//		System.out.println("huilaile-------------------"+newScore+oldScore+getReportId+getAnsPaperId+getStuId);
//		System.out.println(getWenDaTypeId+getWenDaId);
//		System.out.println(getScore1 +" "+ isCorrect);
		
		modifyPaperService.modifyEssayQue(getReportId1, getScore1, getAnsPaperId1, getEssayId1, newScore1, isCorrect);
		
		return "";
		
	}
	

	@RequestMapping(value="/querydata",method = RequestMethod.POST)
	@ResponseBody
	public List<Double> querydata(HttpSession session) {
		
		Integer stu_id = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		System.out.println(stu_id);
		//int stu_id = 6;
		int rightsingle = queryAbilityService.getTotalRightQues(stu_id, 1);
		int rightmultiple = queryAbilityService.getTotalRightQues(stu_id, 2);
		int rightJudge = queryAbilityService.getTotalRightQues(stu_id, 4);
		int rightTiankong = queryAbilityService.getTotalRightQues(stu_id, 5);
		int rightJianda = queryAbilityService.getTotalRightQues(stu_id, 3);
		
		int totalsingle = queryAbilityService.getTotalQues(stu_id, 1);
		int totalmultiple = queryAbilityService.getTotalQues(stu_id, 2);
		int totalJudge = queryAbilityService.getTotalQues(stu_id, 4);
		int totalTiankong = queryAbilityService.getTotalQues(stu_id, 5);
		int totalJianda = queryAbilityService.getTotalQues(stu_id, 3);
		
		Double rate1 = (double) (rightsingle/totalsingle);
		Double rate2 = (double) (rightmultiple/totalmultiple);
		Double rate3 = (double) (rightJudge/totalJudge);
		Double rate4 = (double) (rightTiankong/totalTiankong);
		Double rate5 = (double) (rightJianda/totalJianda);
		ArrayList<Double> arrayList = new ArrayList<Double>();
		arrayList.add(rate1);
		arrayList.add(rate2);
		arrayList.add(rate3);
		arrayList.add(rate4);
		arrayList.add(rate5);
		
		return arrayList;
	}
	

}
