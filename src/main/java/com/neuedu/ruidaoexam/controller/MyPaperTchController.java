package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.service.LogAndRegService;
import com.neuedu.ruidaoexam.service.PaperService;
import com.neuedu.ruidaoexam.service.QuestionBankService;
import com.neuedu.ruidaoexam.service.StudentService;
import com.neuedu.ruidaoexam.service.TeacherService;

@Controller
public class MyPaperTchController {

	@Autowired QuestionBankService questionbankservice;
	@Autowired PaperService paperservice;
	@Autowired TeacherService teacherservice;
	@Autowired LogAndRegService larservice;
	/*
	 * 方法：获取全部题库
	 * 详细：根据参数-uid（教师id），获取该uid下所有题库
	 * 返回：题库的List
	 */
	@RequestMapping("/getPapersTch")
	@ResponseBody
	public List<Paper> getPapers(String uid,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("在getbooks里独到的session："+session.getAttribute("uid"));
		int uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		List<Paper> asb = teacherservice.getUnselledPaperByTeacherid(uid_new);

		return asb;
	}
	/*
	 * 方法：获取全部出售卷子
	 * 详细：根据参数-uid（教师id），获取该uid下所有出售卷子
	 * 返回：题库的List
	 */
	@RequestMapping("/getSaledPapers")
	@ResponseBody
	public List<Paper> getSaledPapers(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("在getbooks里独到的session："+session.getAttribute("uid"));
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		//获取贩卖列表
		 List<Paper> saledpapers = teacherservice.getSelledPapersByTeacherid(uid_new);
		return saledpapers;
	}

	/*
	 * 方法：删除卷子
	 * 详细：根据参数-SelectPapers（卷子id）删除卷子
	 * 返回：1-成功，0-失败
	 */
	@RequestMapping("/deletePapersTch")
	@ResponseBody
	public String deleteBank(@RequestBody List<String> SelectPapers,
			HttpServletRequest request) {
		System.out.println("准备删除卷子");
		int rs;
		for(String str: SelectPapers) {
			System.out.println("开始删除卷子");
			rs = paperservice.deletePaperByPaperId(Integer.parseInt(str));
			if(rs == 0) {
				System.out.println("删除卷子出错，未找到！");
				return "0";
			}
		}
		return "1";
		
	}
	/*
	 * 方法：出售卷子
	 * 详细：根据参数-Bank_id（题库id）和积分出售该卷子
	 * 返回：1-成功，0-失败
	 */
	@RequestMapping("/salePaper")
	@ResponseBody
	public String salePaper(@RequestParam(value="score" ,required=false)String score,
			@RequestParam(value="SelectPapers" ,required=true)String SelectPapers,
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		System.out.println("准备出售");
		int rs;
		String strs[] = SelectPapers.split("\"");
		int i;
		for(i=1; i<strs.length; i+=2) {
			strs[(i+1)/2-1] = strs[i];
		}
		i = (i+1)/2;
		String uid_new = String.valueOf(session.getAttribute("uid"));
		
		for(int j=0; j<i; j++) {
			rs = teacherservice.sellPaper(Integer.parseInt(strs[j]), Integer.parseInt(score), Integer.parseInt(uid_new.trim()));
			if(rs == 0) {
				System.out.println("出售卷子出错，未找到！");
				return "0";
			}
		}
		return "1";
	}
	/*
	 * 方法：取消出售
	 * 详细：根据参数-Bank_id（题库id）取消该题库出售状态
	 * 返回：1-成功，0-失败
	 */
	@RequestMapping("/cancelSalePapers")
	@ResponseBody
	public String cancelSalePaper(@RequestBody List<String> SelectPapers,
			HttpServletRequest request) {
		System.out.println("准备撤销");
		HttpSession session = request.getSession();
		int uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		int rs;
		for(String str: SelectPapers) {
			rs = teacherservice.cancelSellPaper(Integer.parseInt(str), uid_new);
			if(rs == 0) {
				System.out.println("撤销出售出错，未找到！");
				return "0";
			}
		}
		return "1";
		
	}
	

	
}
