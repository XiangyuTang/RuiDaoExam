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
	 * 方法：获取全部未出售题库
	 * 详细：根据参数-uid（教师id），获取该uid下所有未出售题库
	 * 返回：题库的List
	 */
	@RequestMapping("/getBanks")
	@ResponseBody
	public List<QuestionBank> getBanks(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("在getbooks里独到的session："+session.getAttribute("uid"));
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		//商城购买
		//teacherservice.buyBanks(1, 2, 5, 8);
		//设置贩卖
		//teacherservice.sellBank(5, 20, 2);
		//取消贩卖
		//teacherservice.cancelSellBank(5, 2);
		//获取贩卖列表
//		 List<QuestionBank> test = teacherservice.getSelledBanksByTeacherid(2);
//		for (QuestionBank qbb : test) {
//			System.out.println(qbb.getQuesBankId());
//		}
		//展示所有贩卖的题库
//		List<QuestionBank> asb = questionbankservice.getAllSelledBanks();
//		for (QuestionBank qbb : asb) {
//			System.out.println(qbb.getQuesBankId());
//		}
		//展示贩卖特定类型题库
//		List<QuestionBank> asb = questionbankservice.getCertainTypeSelledBanks(2);
//		for (QuestionBank qbb : asb) {
//			System.out.println(qbb.getQuesBankId());
//		}
		//展示我的题库中未贩卖的
		List<QuestionBank> asb = teacherservice.getUnselledBankByTeacherid(uid_new);

		return asb;
		//展示题库中所有题库

//		List<QuestionBank> qb = questionbankservice.getQusetionBankByTeacherid(Integer.parseInt(uid_new.trim()));
//		return qb;
	}
	/*
	 * 方法：获取全部出售题库
	 * 详细：根据参数-uid（教师id），获取该uid下所有出售题库
	 * 返回：题库的List
	 */
	@RequestMapping("/getSaledBanks")
	@ResponseBody
	public List<QuestionBank> getSaledBanks(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("在getbooks里独到的session："+session.getAttribute("uid"));
		int uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		//获取贩卖列表
		 List<QuestionBank> saledbanks = teacherservice.getSelledBanksByTeacherid(uid_new);
		return saledbanks;
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
	/*
	 * 方法：出售题库
	 * 详细：根据参数-Bank_id（题库id）和积分出售该题库
	 * 返回：1-成功，0-失败
	 */
	@RequestMapping("/saleBank")
	@ResponseBody
	public String saleBank(@RequestParam(value="score" ,required=false)String score,
			@RequestParam(value="SelectBanks" ,required=true)String SelectBanks,
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		System.out.println("准备出售");
		int rs;
		String strs[] = SelectBanks.split("\"");
		int i;
		for(i=1; i<strs.length; i+=2) {
			strs[(i+1)/2-1] = strs[i];
		}
		i = (i+1)/2;
		String uid_new = String.valueOf(session.getAttribute("uid"));
		//for(int )
		for(int j=0; j<i; j++) {
			rs = teacherservice.sellBank(Integer.parseInt(strs[j]), Integer.parseInt(score), Integer.parseInt(uid_new.trim()));
			if(rs == 0) {
				System.out.println("出售题库出错，未找到！");
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
	@RequestMapping("/cancelSaleBanks")
	@ResponseBody
	public String cancelSaleBank(@RequestBody List<String> SelectBanks,
			HttpServletRequest request) {
		System.out.println("准备撤销");
		HttpSession session = request.getSession();
		int uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		int rs;
		for(String str: SelectBanks) {
			rs = teacherservice.cancelSellBank(Integer.parseInt(str), uid_new);
			if(rs == 0) {
				System.out.println("撤销出售出错，未找到！");
				return "0";
			}
		}
		return "1";
		
	}
	
	
	
}
