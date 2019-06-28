package com.neuedu.ruidaoexam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.service.LogAndRegService;
import com.neuedu.ruidaoexam.service.PaperService;
import com.neuedu.ruidaoexam.service.QuestionBankService;
import com.neuedu.ruidaoexam.service.StudentService;
import com.neuedu.ruidaoexam.service.TeacherService;

@Controller
public class ShopController {
	
	@Autowired QuestionBankService questionbankservice;
	@Autowired PaperService paperservice;
	@Autowired TeacherService teacherservice;
	@Autowired StudentService studentservice;
	@Autowired LogAndRegService larservice;
	/*
	 * 方法：获取全部售卖中的题库/某一类题库
	 * 详细：根据参数-uid（教师id），获取除自己创造或购买外的所有未出售题库
	 * 返回：题库的List
	 */
	@RequestMapping("/getShopBanks")
	@ResponseBody
	public List<QuestionBank> getBanks(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String itemtype = request.getParameter("itemtype");
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		if(!itemtype.equals("false")) {
			System.out.println("展示全部");
			int type = Integer.parseInt(itemtype);
			List<QuestionBank> asb = questionbankservice.getCertainTypeSelledBanks(type, uid_new);
			return asb;
		}else {
			//展示所有贩卖的题库
			List<QuestionBank> asb = questionbankservice.getAllSelledBanks(uid_new);
			for (QuestionBank qbb : asb) {
				System.out.println(qbb.getQuesBankId());
			}
			
			System.out.println("itemtype:"+itemtype);
			return asb;
		}
		
		
		//展示贩卖特定类型题库
//		List<QuestionBank> asb = questionbankservice.getCertainTypeSelledBanks(2);
//		for (QuestionBank qbb : asb) {
//			System.out.println(qbb.getQuesBankId());
//		}
	}
	/*
	 * 方法：获取全部售卖中的题库/某一类考卷
	 * 详细：根据参数-uid（教师id），获取除自己创造或购买外的所有未出售考卷
	 * 返回：考卷的List
	 */
	@RequestMapping("/getShopPapers")
	@ResponseBody
	public List<Paper> getPapers(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String itemtype = request.getParameter("itemtype");
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		if(!itemtype.equals("false")) {
			int type = Integer.parseInt(itemtype);
			List<Paper> asb = paperservice.getCertainTypeSelledPapers(type, uid_new);
			return asb;
		}else {
			//展示所有贩卖的考卷
			List<Paper> asb = paperservice.getAllSelledPapers(uid_new);
			System.out.println("itemtype:"+itemtype);
			return asb;
		}
		
		
		//展示贩卖特定类型题库
//		List<QuestionBank> asb = questionbankservice.getCertainTypeSelledBanks(2);
//		for (QuestionBank qbb : asb) {
//			System.out.println(qbb.getQuesBankId());
//		}
	}
	/*
	 * 方法：购买题库
	 * 详细：根据参数-uid（教师id）和题库类型，获取除自己创造或购买外的所有未出售题库
	 * 返回：题库的List
	 */
	@RequestMapping("/buyBank")
	@ResponseBody
	public String buyBank(String itemid,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		System.out.println("准备购买");
		Boolean rs;
		System.out.println("购买时：uid:"+uid_new+",itemid:"+Integer.parseInt(itemid));
		rs = teacherservice.buyBanks(uid_new, Integer.parseInt(itemid));// questionbankservice.deleteBankByBankId(Integer.parseInt(itemid));
		if(!rs) {
			System.out.println("购买题库出错！");
			return "0";
		}
		return "1";
		
	}
	/*
	 * 方法：购买考卷
	 * 详细：根据参数-uid（教师id）和考卷类型，获取除自己创造或购买外的所有未出售考卷
	 * 返回：考卷的List
	 */
	@RequestMapping("/buyPaper")
	@ResponseBody
	public String buyPaper(String itemid,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		System.out.println("准备购买");
		Boolean rs;
		System.out.println("购买时：uid:"+uid_new+",itemid:"+Integer.parseInt(itemid));
		rs = studentservice.buyPaper(uid_new, Integer.parseInt(itemid));// questionbankservice.deleteBankByBankId(Integer.parseInt(itemid));
		if(!rs) {
			System.out.println("购买考卷出错！");
			return "0";
		}
		return "1";
		
	}
	/*
	 * 方法：关键字搜索
	 * 详细：根据keyword参数，搜索name包含关键字的卷子
	 * 返回：卷子的List
	 */
	@RequestMapping("/keywordSearchPaper")
	@ResponseBody
	public List<Paper> keywordSearchPaper(String keyword, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		List<Paper> papers = paperservice.keywordSearchPaper(keyword,uid_new);
		return papers;
	}
	
	/*
	 * 方法：关键字搜索
	 * 详细：根据keyword参数，搜索name包含关键字的题库
	 * 返回：题库的List
	 */
	@RequestMapping("/keywordSearchBank")
	@ResponseBody
	public List<QuestionBank> keywordSearchBank(String keyword, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		List<QuestionBank> questionbank = questionbankservice.keywordSearchBank(keyword,uid_new);
		return questionbank;
	}
	
	/*
	 * 方法：获取全部出售题库
	 * 详细：根据参数-uid（教师id），获取该uid下所有出售题库
	 * 返回：题库的List
	 */
//	@RequestMapping("/getSaledBanks")
//	@ResponseBody
//	public List<QuestionBank> getSaledBanks(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		System.out.println("在getbooks里独到的session："+session.getAttribute("uid"));
//		int uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
//		//获取贩卖列表
//		 List<QuestionBank> saledbanks = teacherservice.getSelledBanksByTeacherid(uid_new);
//		return saledbanks;
//	}

}
