package com.neuedu.ruidaoexam.controller;

import java.text.SimpleDateFormat;
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
public class MarkingController {
	
	@Autowired
	ReportServiceimpl reportServiceimpl;
	@Autowired
	PaperServiceimpl PaperServiceimpl;
	
	@RequestMapping("/marking")
	public String getJiBenXinXi(Integer report_id,Integer answeredpaper_id,  Model model) throws Exception{
//		System.out.println("WWWWWWWWWWWWWWWWWWWWWWW");
//		System.out.println(report_id);
//		System.out.println(answeredpaper_id);
		//获取判卷页基本信息数据
		model.addAttribute("report_id", report_id);
		model.addAttribute("answeredpaper_id", answeredpaper_id);
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
		String ansPaperIdTag = studentInof.get(8);
		String stuIdTag = studentInof.get(9);
		int ansPaperId = Integer.parseInt(ansPaperIdTag);
		int stuId = Integer.parseInt(stuIdTag);
//		request.getSession().setAttribute("sName", sName);
//		request.getSession().setAttribute("sEmail", sEmail);
//		request.getSession().setAttribute("sScore", sScore);
//		request.getSession().setAttribute("paperTitle", paperTitle);
//		request.getSession().setAttribute("beginTime", beginTime);
//		request.getSession().setAttribute("endTime", endTime);
		
		model.addAttribute("sName", sName);
		model.addAttribute("sEmail", sEmail);
		model.addAttribute("sScore", sScore);
		model.addAttribute("paperTitle", paperTitle);
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("comment", comment);
		model.addAttribute("isModified", isModified);
		model.addAttribute("reportId", report_id);
		model.addAttribute("ansPaperId", ansPaperId);
		model.addAttribute("stuId", stuId);
		
		//获取判卷页全面概括数据
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
		
//		request.getSession().setAttribute("keGuanTiNum", keGuanTiNum);
//		request.getSession().setAttribute("keGuanTiScore", keGuanTiScore);
//		request.getSession().setAttribute("keGuanTiTotalScore", keGuanTiTotalScore);
//		request.getSession().setAttribute("xuanZeTiNum", xuanZeTiNum);
//		request.getSession().setAttribute("xuanZeTiWrongNum", xuanZeTiWrongNum);
//		request.getSession().setAttribute("xuanZeTiScore", xuanZeTiScore);
//		request.getSession().setAttribute("panDuanTiNum", panDuanTiNum);
//		request.getSession().setAttribute("panDuanTiWrongNum", panDuanTiWrongNum);
//		request.getSession().setAttribute("panDuanTiScore", panDuanTiScore);
//		request.getSession().setAttribute("zhuGuanTiNum", zhuGuanTiNum);
//		request.getSession().setAttribute("zhuGuanTiScore", zhuGuanTiScore);
//		request.getSession().setAttribute("zhuGuanTiTotalScore", zhuGuanTiTotalScore);
//		request.getSession().setAttribute("tianKongTiNumum", tianKongTiNum);
//		request.getSession().setAttribute("tianKongTiWrongNum", tianKongTiWrongNum);
//		request.getSession().setAttribute("tianKongTiScore", tianKongTiScore);
//		request.getSession().setAttribute("wenDaTiNum", wenDaTiNum);
//		request.getSession().setAttribute("wenDaTiWrongNum", wenDaTiWrongNum);
//		request.getSession().setAttribute("wenDaTiScore", wenDaTiScore);
//		request.getSession().setAttribute("shiTiNum", shiTiNum);
		
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
		
		//获取报告页选择题答题情况数据
		ArrayList<ForChoiceQuestion> forChoiceQuestionInList = reportServiceimpl.getXuanZeDaTiQingKuang(report_id);
				
		model.addAttribute("forChoiceQuestionInList", forChoiceQuestionInList);
		
		//获取报告页判断题答题情况数据
		ArrayList<ForJudgeQuestion> forJudgeQuestionInList = reportServiceimpl.getPanDuanDaTiQingKuang(report_id);
				
		model.addAttribute("forJudgeQuestionInList", forJudgeQuestionInList);
				
		//获取报告页填空题答题情况数据
		ArrayList<ForTianKongQuestion> forTianKongQuestionInList = reportServiceimpl.getTianKongDaTiQingKuang(report_id);
				
		model.addAttribute("forTianKongQuestionInList", forTianKongQuestionInList);
				
		//获取报告页问答题答题情况数据
		ArrayList<ForWenDaQuestion> forWenDaQuestionInList = reportServiceimpl.getWenDaDaTiQingKuang(report_id);
						
		model.addAttribute("forWenDaQuestionInList", forWenDaQuestionInList);
		
		//提交判卷结果
//		String ansPaperIdString = "1";
		String isModifiedByTeacher = "1";
		String answeredpaper_idString = answeredpaper_id.toString();		 
		ArrayList<String> modifiedArray = new ArrayList<String>();
		modifiedArray.add(answeredpaper_idString);
		modifiedArray.add(isModifiedByTeacher);
				
		reportServiceimpl.modified(modifiedArray);
				
		return "marking";
		
	}
	
//	/**
//	 * 获取判卷页全面概括数据
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/marking")
//	public String getQuanMianGaiKuo(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		
//		int report_id = 1;
//		ArrayList<String> quanMianGaiKuo = reportServiceimpl.getQuanMianGaiKuo(report_id);
//		
//		String keGuanTiNum = quanMianGaiKuo.get(0);
//		String keGuanTiScore = quanMianGaiKuo.get(1);
//		String keGuanTiTotalScore = quanMianGaiKuo.get(2);
//		
//		String xuanZeTiNum = quanMianGaiKuo.get(3);;
//		String xuanZeTiWrongNum = quanMianGaiKuo.get(4);
//		String xuanZeTiScore = quanMianGaiKuo.get(5);
//		String panDuanTiNum = quanMianGaiKuo.get(6);
//		String panDuanTiWrongNum = quanMianGaiKuo.get(7);
//		String panDuanTiScore = quanMianGaiKuo.get(8);
//		
//		String zhuGuanTiNum = quanMianGaiKuo.get(9);
//		String zhuGuanTiScore = quanMianGaiKuo.get(10);
//		String zhuGuanTiTotalScore = quanMianGaiKuo.get(11);
//		
//		String tianKongTiNum = quanMianGaiKuo.get(12);
//		String tianKongTiWrongNum = quanMianGaiKuo.get(13);
//		String tianKongTiScore = quanMianGaiKuo.get(14);
//		String wenDaTiNum = quanMianGaiKuo.get(15);
//		String wenDaTiWrongNum = quanMianGaiKuo.get(16);
//		String wenDaTiScore = quanMianGaiKuo.get(17);
//		
//		request.getSession().setAttribute("keGuanTiNum", keGuanTiNum);
//		request.getSession().setAttribute("keGuanTiScore", keGuanTiScore);
//		request.getSession().setAttribute("keGuanTiTotalScore", keGuanTiTotalScore);
//		request.getSession().setAttribute("xuanZeTiNum", xuanZeTiNum);
//		request.getSession().setAttribute("xuanZeTiWrongNum", xuanZeTiWrongNum);
//		request.getSession().setAttribute("xuanZeTiScore", xuanZeTiScore);
//		request.getSession().setAttribute("panDuanTiNum", panDuanTiNum);
//		request.getSession().setAttribute("panDuanTiWrongNum", panDuanTiWrongNum);
//		request.getSession().setAttribute("panDuanTiScore", panDuanTiScore);
//		request.getSession().setAttribute("zhuGuanTiNum", zhuGuanTiNum);
//		request.getSession().setAttribute("zhuGuanTiScore", zhuGuanTiScore);
//		request.getSession().setAttribute("zhuGuanTiTotalScore", zhuGuanTiTotalScore);
//		request.getSession().setAttribute("keGuanTiNtianKongTiNumum", tianKongTiNum);
//		request.getSession().setAttribute("tianKongTiWrongNum", tianKongTiWrongNum);
//		request.getSession().setAttribute("tianKongTiScore", tianKongTiScore);
//		request.getSession().setAttribute("wenDaTiNum", wenDaTiNum);
//		request.getSession().setAttribute("wenDaTiWrongNum", wenDaTiWrongNum);
//		request.getSession().setAttribute("wenDaTiScore", wenDaTiScore);
//		
//		return "marking";
//		
//	}
}
