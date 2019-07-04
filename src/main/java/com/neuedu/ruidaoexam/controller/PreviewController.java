package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ForChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ForJudgeQuestion;
import com.neuedu.ruidaoexam.entity.ForTianKongQuestion;
import com.neuedu.ruidaoexam.entity.ForWenDaQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;
import com.neuedu.ruidaoexam.service.PreviewService;

@Controller
public class PreviewController {
	
	@Autowired
	PreviewService previewService;
	
	@RequestMapping("/preview")
	public String getDaTiQingKuang(Integer paper_id, Model model) throws Exception{
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
		System.out.println(paper_id);
//		model.addAttribute("paper_id", paper_id);
		int paperId = paper_id;
		
		//获取报告页选择题答题情况数据
		ArrayList<String> getNum = previewService.getNum(paperId);
		String getXuanZeNum = getNum.get(0);
		String getPanDuanNum = getNum.get(1);
		String getTianKongNum = getNum.get(2);
		String getWenDaNum = getNum.get(3);
		
		model.addAttribute("getXuanZeNum", getXuanZeNum);
		model.addAttribute("getPanDuanNum", getPanDuanNum);
		model.addAttribute("getTianKongNum", getTianKongNum);
		model.addAttribute("getWenDaNum", getWenDaNum);
		
		
		//获取选择题答题情况数据
		ArrayList<ForChoiceQuestion> forChoiceQuestion = previewService.getXuanZe(paperId);
						
		model.addAttribute("forChoiceQuestion", forChoiceQuestion);
		
		//获取判断题答题情况数据
		ArrayList<ForJudgeQuestion> forJudgeQuestion = previewService.getPanDuan(paperId);
						
		model.addAttribute("forJudgeQuestion", forJudgeQuestion);
						
		//获取填空题答题情况数据
		ArrayList<ForTianKongQuestion> forTianKongQuestion = previewService.getTianKong(paperId);
						
		model.addAttribute("forTianKongQuestion", forTianKongQuestion);
						
		//获取问答题答题情况数据
		ArrayList<ForWenDaQuestion> forWenDaQuestion = previewService.getWenDa(paperId);
								
		model.addAttribute("forWenDaQuestion", forWenDaQuestion);
		
		
		return "preview";
		
	}
}
