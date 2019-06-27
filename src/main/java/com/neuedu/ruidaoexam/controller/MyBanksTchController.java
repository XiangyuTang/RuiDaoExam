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
import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.service.LogAndRegService;
import com.neuedu.ruidaoexam.service.QuestionBankService;
import com.neuedu.ruidaoexam.service.StudentService;
import com.neuedu.ruidaoexam.service.TeacherService;

@Controller
public class MyBanksTchController {

	@Autowired QuestionBankService questionbankservice;
	@Autowired TeacherService teacherservice;
	@Autowired LogAndRegService larservice;
	/*
	 * 方法：获取全部题库
	 * 详细：根据参数-uid（教师id），获取该uid下所有题库
	 * 返回：题库的List
	 */
	@RequestMapping("/getBanks")
	@ResponseBody
	public List<QuestionBank> getBooks(String uid,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		List<QuestionBank> qb = questionbankservice.getQusetionBankByTeacherid((Integer)session.getAttribute("uid"));
		return qb;
	}
	/*
	 * 方法：删除题库
	 * 详细：根据参数-Bank_id（题库id）删除该题库
	 * 返回：1-成功，0-失败
	 */
	@RequestMapping("/deleteBanks")
	@ResponseBody
	public String deleteBank(@RequestBody List<String> SelectBanks,
			HttpServletRequest request) {
		System.out.println("准备删除");
		int rs;
		for(String str: SelectBanks) {
			System.out.println("开始删除");
			rs = questionbankservice.deleteBankByBankId(Integer.parseInt(str));
			if(rs == 0) {
				System.out.println("删除题库出错，未找到！");
				return "0";
			}
		}
		return "1";
		
	}
	
}
