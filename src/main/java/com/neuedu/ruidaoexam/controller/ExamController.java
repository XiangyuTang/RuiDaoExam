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
		
		InviteStudent inviteStudent = inviteService.verifyPerson(email,invitecode);
		if(inviteStudent!=null)
		{
			str="1";
			session.setAttribute("inviteStudent", inviteStudent);
			
		}	
		else
			str="0";
		return str;
	}
	
	@RequestMapping("/importpaper")
    //@ResponseBody
    public String importPaper(Model m,HttpSession session) {
		//List<ChoiceQuestion> singleChoice =  questionPaperService.selectSingleChoice(1);//和上面的paper_id对接
		InviteStudent inviteStudent = (InviteStudent) session.getAttribute("inviteStudent");
		int paper_id = inviteStudent.getPaperId();
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

/*System.out.println("单选题：");		
for(ChoiceQuestion cq:singleChoice)
{
	System.out.println(cq.toString());
}
System.out.println("多选题：");
for(ChoiceQuestion cq:multipleChoice)
{
	System.out.println(cq.toString());
}
System.out.println("判断题：");
for(JudgeQuestion jq:judgeQuestion)
{
	System.out.println(jq.toString());
}
System.out.println("填空题：");
for(EssayQuestion eq:fillBlankQuestion)
{
	System.out.println(eq.toString());
}
System.out.println("简答题：");
for(EssayQuestion eq:shortAnswerQuestion)
{
	System.out.println(eq.toString());
}*/
