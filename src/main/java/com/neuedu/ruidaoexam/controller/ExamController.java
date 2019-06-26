package com.neuedu.ruidaoexam.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;
import com.neuedu.ruidaoexam.service.InviteService;
import com.neuedu.ruidaoexam.service.QuestionPaperService;

import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class ExamController {
	
	@Autowired
	InviteService inviteService;
	
	@Autowired
	QuestionPaperService questionPaperService;
	
	
	
	@RequestMapping(value="/verifyintoexam",method = RequestMethod.POST)
    @ResponseBody
    public String verifyIntoExam(String email,String invitecode,HttpServletResponse response,HttpSession session) {

		String str="";
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();// new Date()为获取当前系统时间
		
		InviteStudent inviteStudent = inviteService.verifyPerson(email,invitecode);
		if(inviteStudent==null)
			return "-1";
		int compareTobegin = now.compareTo(inviteStudent.getBeginTime());//当前时间大于开始时间返回1
		int compareToEnd = now.compareTo(inviteStudent.getEndTime());//当前时间小于结束时间返回-1
		if(compareTobegin==1&&compareToEnd==-1)
		{
			if(inviteStudent!=null)
			{
				str="1";//代表可以参加考试
				session.setAttribute("inviteStudent", inviteStudent);
			}
		}	
		else
			str="0";//代表当前时间不在考试范围内
		return str;
	}
	
	@RequestMapping("/importpaper")
    //@ResponseBody
    public String importPaper(Model m,HttpSession session) {
		//List<ChoiceQuestion> singleChoice =  questionPaperService.selectSingleChoice(1);//和上面的paper_id对接
		InviteStudent inviteStudent = (InviteStudent) session.getAttribute("inviteStudent");
		int paper_id = inviteStudent.getPaperId();
		Date begin = new Date();//获取当前考生进入考试的时间
		Date end = inviteStudent.getEndTime();//获取考试的结束时间
		long interval = (end.getTime() - begin.getTime())/1000;//总秒数
		System.out.println(interval);
		m.addAttribute("interval", interval);
		m.addAttribute("allowedCheat", inviteStudent.getAllowedCheatTimes());
		List<ChoiceQuestion> singleChoice =  questionPaperService.selectSingleChoice(paper_id);
		List<ChoiceQuestion> multipleChoice =  questionPaperService.selectMultipleChoice(paper_id);
		List<JudgeQuestion> judgeQuestion = questionPaperService.selectJudge(paper_id);
		List<EssayQuestion> fillBlankQuestion = questionPaperService.selectFillBlank(paper_id);
		List<EssayQuestion> shortAnswerQuestion = questionPaperService.selectShortAnswer(paper_id);
		m.addAttribute("singleChoice", singleChoice);
		m.addAttribute("multipleChoice", multipleChoice);
		m.addAttribute("judgeQuestion", judgeQuestion);
		m.addAttribute("fillBlankQuestion", fillBlankQuestion);
		m.addAttribute("shortAnswerQuestion", shortAnswerQuestion);
		int singleChoiceTotalScore = 0;
		int multiChoiceTotalScore = 0;
		int judgeChoiceTotalScore = 0;
		int fillBlankTotalScore = 0;
		int shortAnswerTotalScore = 0;
		if(singleChoice!=null)
			for(ChoiceQuestion cq:singleChoice)
			{
				singleChoiceTotalScore += Integer.parseInt(cq.getScore());
				//cq.getChoice1()
			}
		
		if(multipleChoice!=null)
			for(ChoiceQuestion cq:multipleChoice)
			{
				multiChoiceTotalScore += Integer.parseInt(cq.getScore());
			}
		if(judgeQuestion!=null)
			for(JudgeQuestion jq:judgeQuestion)
			{
				judgeChoiceTotalScore += Integer.parseInt(jq.getScore());
			}
		if(fillBlankQuestion!=null)
			for(EssayQuestion eq:fillBlankQuestion)
			{
				fillBlankTotalScore += Integer.parseInt(eq.getScore());
			}
		if(shortAnswerQuestion!=null)
			for(EssayQuestion eq:shortAnswerQuestion)
			{
				shortAnswerTotalScore += Integer.parseInt(eq.getScore());
			}
		
		m.addAttribute("singleChoiceTotalScore",singleChoiceTotalScore);
		m.addAttribute("multiChoiceTotalScore",multiChoiceTotalScore);
		m.addAttribute("judgeChoiceTotalScore",judgeChoiceTotalScore);
		m.addAttribute("fillBlankTotalScore",fillBlankTotalScore);
		m.addAttribute("shortAnswerTotalScore",shortAnswerTotalScore);
		return "examing";
	}
}

