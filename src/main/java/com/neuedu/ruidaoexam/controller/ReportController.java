package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.entity.ForChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ForJudgeQuestion;
import com.neuedu.ruidaoexam.entity.ForTianKongQuestion;
import com.neuedu.ruidaoexam.entity.ForWenDaQuestion;
import com.neuedu.ruidaoexam.service.impl.PaperServiceimpl;
import com.neuedu.ruidaoexam.service.impl.ReportServiceimpl;

@Controller
public class ReportController {
	
	@Autowired
	ReportServiceimpl reportServiceimpl;
	@Autowired
	PaperServiceimpl PaperServiceimpl;
	
	@RequestMapping("/report")
	public String getJiBenXinXi(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception{
		
		int report_id = 1;
		
		//获取报告页基本信息数据
		ArrayList<String> studentInof = reportServiceimpl.getJiBenXinXi(report_id);
		String sName = studentInof.get(0);
		String sEmail = studentInof.get(1);
		String sScore = studentInof.get(2);
		String paperTitle = studentInof.get(3);
		String beginTime = studentInof.get(4);
		String endTime = studentInof.get(5);
		String comment = studentInof.get(6);
		String sIsModified = studentInof.get(7);
		int isModified = Integer.parseInt(sIsModified);
		
		model.addAttribute("sName", sName);
		model.addAttribute("sEmail", sEmail);
		model.addAttribute("sScore", sScore);
		model.addAttribute("paperTitle", paperTitle);
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("comment", comment);
		model.addAttribute("isModified", isModified);
		
		//获取报告页全面概括数据
		ArrayList<String> quanMianGaiKuo = reportServiceimpl.getQuanMianGaiKuo(report_id);
		
		String keGuanTiNum = quanMianGaiKuo.get(0);
		String keGuanTiScore = quanMianGaiKuo.get(1);
		String keGuanTiTotalScore = quanMianGaiKuo.get(2);
		
		String xuanZeTiNum = quanMianGaiKuo.get(3);;
		String xuanZeTiWrongNum = quanMianGaiKuo.get(4);
		String xuanZeTiScore = quanMianGaiKuo.get(5);
		String panDuanTiNum = quanMianGaiKuo.get(6);
		String panDuanTiWrongNum = quanMianGaiKuo.get(7);
		String panDuanTiScore = quanMianGaiKuo.get(8);
		
		String zhuGuanTiNum = quanMianGaiKuo.get(9);
		String zhuGuanTiScore = quanMianGaiKuo.get(10);
		String zhuGuanTiTotalScore = quanMianGaiKuo.get(11);
		
		String tianKongTiNum = quanMianGaiKuo.get(12);
		String tianKongTiWrongNum = quanMianGaiKuo.get(13);
		String tianKongTiScore = quanMianGaiKuo.get(14);
		String wenDaTiNum = quanMianGaiKuo.get(15);
		String wenDaTiWrongNum = quanMianGaiKuo.get(16);
		String wenDaTiScore = quanMianGaiKuo.get(17);
		
		String shiTiNum = quanMianGaiKuo.get(18);
		
		model.addAttribute("keGuanTiNum", keGuanTiNum);
		model.addAttribute("keGuanTiScore", keGuanTiScore);
		model.addAttribute("keGuanTiTotalScore", keGuanTiTotalScore);
		model.addAttribute("xuanZeTiNum", xuanZeTiNum);
		model.addAttribute("xuanZeTiWrongNum", xuanZeTiWrongNum);
		model.addAttribute("xuanZeTiScore", xuanZeTiScore);
		model.addAttribute("panDuanTiNum", panDuanTiNum);
		model.addAttribute("panDuanTiWrongNum", panDuanTiWrongNum);
		model.addAttribute("panDuanTiScore", panDuanTiScore);
		model.addAttribute("zhuGuanTiNum", zhuGuanTiNum);
		model.addAttribute("zhuGuanTiScore", zhuGuanTiScore);
		model.addAttribute("zhuGuanTiTotalScore", zhuGuanTiTotalScore);
		model.addAttribute("tianKongTiNum", tianKongTiNum);
		model.addAttribute("tianKongTiWrongNum", tianKongTiWrongNum);
		model.addAttribute("tianKongTiScore", tianKongTiScore);
		model.addAttribute("wenDaTiNum", wenDaTiNum);
		model.addAttribute("wenDaTiWrongNum", wenDaTiWrongNum);
		model.addAttribute("wenDaTiScore", wenDaTiScore);
		model.addAttribute("shiTiNum", shiTiNum);
		
//		//获取报告页选择题答题情况数据
		ArrayList<ForChoiceQuestion> forChoiceQuestionInList = reportServiceimpl.getXuanZeDaTiQingKuang(report_id);
		
		model.addAttribute("forChoiceQuestionInList", forChoiceQuestionInList);
		
//		ArrayList<ForChoiceQuestion> xuanZeDaTiQingKuang = reportServiceimpl.getXuanZeDaTiQingKuang(report_id);
//		
//		ForChoiceQuestion forChoiceQuestion = new ForChoiceQuestion();
//		
//		model.addAttribute("xuanZeDaTiQingKuang", xuanZeDaTiQingKuang);
//		
////		String quesType = daTiQingKuang.get(0);
////		String content = daTiQingKuang.get(1);
////		String choice1 = daTiQingKuang.get(2);
////		String choice2 = daTiQingKuang.get(3);
////		String choice3 = daTiQingKuang.get(4);
////		String choice4 = daTiQingKuang.get(5);
////		String answer = daTiQingKuang.get(6);
////		String analysis = daTiQingKuang.get(7);
////		String abilityType = daTiQingKuang.get(8);
////		
////		model.addAttribute("quesType", quesType);
////		model.addAttribute("content", content);
////		model.addAttribute("choice1", choice1);
////		model.addAttribute("choice2", choice2);
////		model.addAttribute("choice3", choice3);
////		model.addAttribute("choice4", choice4);
////		model.addAttribute("answer", answer);
////		model.addAttribute("analysis", analysis);
////		model.addAttribute("abilityType", abilityType);

		//获取报告页判断题答题情况数据
		ArrayList<ForJudgeQuestion> forJudgeQuestionInList = reportServiceimpl.getPanDuanDaTiQingKuang(report_id);
		
		model.addAttribute("forJudgeQuestionInList", forJudgeQuestionInList);
		
		//获取报告页填空题答题情况数据
		ArrayList<ForTianKongQuestion> forTianKongQuestionInList = reportServiceimpl.getTianKongDaTiQingKuang(report_id);
		
		model.addAttribute("forTianKongQuestionInList", forTianKongQuestionInList);
		
		//获取报告页问答题答题情况数据
		ArrayList<ForWenDaQuestion> forWenDaQuestionInList = reportServiceimpl.getWenDaDaTiQingKuang(report_id);
				
		model.addAttribute("forWenDaQuestionInList", forWenDaQuestionInList);
		
		return "report";
		
	}
}
