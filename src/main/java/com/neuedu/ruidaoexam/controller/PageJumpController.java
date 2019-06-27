package com.neuedu.ruidaoexam.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.service.QuestionBankService;
import com.neuedu.ruidaoexam.service.Trade_recordService;
import com.neuedu.ruidaoexam.service.impl.QuestionServiceimpl;

@Controller
public class PageJumpController {
	@Autowired
	QuestionBankService questionBankService;
	@Autowired
	Trade_recordService trade_recordService;
	@Autowired
	QuestionServiceimpl questionServiceimpl;

	// 这个controller测试放行静态资源的
	@RequestMapping("/to11")
	public String to111() {
		// System.out.println("f-----------------");
		return "addQuestion";
	}

	@RequestMapping("/test")
	public String test() {
		return "examOver";
	}

	// 学生个人中心
	@RequestMapping("/toindex")
	public String toindex() {
		return "index";
	}
//	//考生录入界面
//	@RequestMapping("/toinvite")
//	public String toinvite() {
//		return "invite";
//	}

	//考试结束页面
	@RequestMapping("/toExamOver")
	public String toExamOver() {
		return "examOver";
	}
	// 注册页
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "user/reg";
	}

	// 登录页
	@RequestMapping("tologin")
	public String toLogin() {
		return "user/login";
	}
	//跳转到组卷界面
	@RequestMapping("/toshoudong")
	public String toshoudong(Model model) {
		// 此处的teacher_id应该是session中的内容
		List<QuestionBank> questionBanks = questionBankService.getQusetionBankByTeacherid(1);
		List<QuestionBank> questionBanks2 = trade_recordService.getQusetionBankByTeacherid(1);
		for (QuestionBank questionbank : questionBanks2) {
			questionBanks.add(questionbank);
		}
		for (QuestionBank questionBank : questionBanks) {
			System.out.println(questionBank.getQuesBankName());
		}
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWW");
		model.addAttribute("questionbanks", questionBanks);
//		model.addAttribute("test", "我被取用了");
		return "shoudongzujuan";
	}

	@RequestMapping("/toentrance")
	public String toentercode() {

		return "examEntrance";
	}

	@RequestMapping("/toquestion")//通过题库id选取题库中的题，并向前台呈现
	public String toquestion(HttpServletRequest request,Model model) {
//		System.out.println(quesbankid);
//		System.out.println(request.getParameter("quesbankid"));
		int Bank_id = Integer.parseInt(request.getParameter("quesbankid"));
		HashMap<String,Object> questionByBankid = questionServiceimpl.getQuestionByBankid(Bank_id);
		model.addAttribute("questions", questionByBankid);
//		System.out.println("我被调了");
		return "chioceques";
	}

	// 主页
	@RequestMapping("/tohomePage")
	public String tohomepage() {
		return "user/homePage";
	}
	
	//游客主页
	@RequestMapping("/tohome")
	public String tohome() {
		return "home";
	}
	
	// 教师个人中心
	@RequestMapping("/toindexteacher")
	public String toindexteacher(HttpServletRequest request) {
		if (request.getSession().getValue("role") == "teacher") {
			return "indexteacher";
		} else {
			return "user/login";
		}
	}

	/*
	 * 以下homeTch,myLibraryTch,myPaperTch, 
	 * 内嵌在教师个人中心indextercher中
	 */
	// 教师主页(展示/欢迎页)
	@RequestMapping("/tohomeTch")
	public String toteacherhome() {
		return "teacher/homeTch";
	}

	// 教师-我的题库
	@RequestMapping("/tomyBanksTch")
	public String tomylibrary() {
		return "teacher/myBanksTch";
	}

	// 教师-我的试卷
	@RequestMapping("/tomyPaperTch")
	public String tomyPaperTch() {
		return "teacher/myPaperTch";
	}
	//教师-题库商户
	@RequestMapping("/tomyBanksaleTch")
	public String tomyBanksaleTch() {
		return "teacher/myBanksaleTch";
	}
	//教师-卷子商户
	@RequestMapping("/tomyPapersaleTch")
	public String tomyPapersaleTch() {
		return "teacher/myPapersaleTch";
	}
	// 考试页
	@RequestMapping("/toexam")
	public String toexam() {
		return "examing";
	}
	//到达教师主页，测试时使用，后续删除即可
	@RequestMapping("/toshoudongjuan")
	public String toshoudong() {
		return "indexteacher";
	}
	
	 //学生主页
		@RequestMapping("tohomeStu")
		public String tostudenthome() {
			return "student/homeStu";
			}
		//学生 我的考试
		@RequestMapping("toMyExam")
		public String toMyExam() {
			return "detail";
			
		}
		
	    //学生 个人中心
		@RequestMapping("toStuBaseInfo")
		public String toStuBaseInfo() {
			return "student/baseinfo";
		}
		
		
		//学生忘记密码
		@RequestMapping("toStuModifyPassword")
		public String toStuForget() {
			return "password";
		}
		//跳转到添加填写试卷信息页面
		@RequestMapping("/toaddpaper")
		public String toaddpaper() {
			return "addpaper";
		}
//		//跳转到教师的我的考试界面
//		@RequestMapping("/toMyPapers")
//		public String toMyPapers() {
//			return "papers";
//		}
		//跳转到学生购买记录界面
		@RequestMapping("/toStuOrder")
		public String toStuOrder() {
			return "student/order";
		}
		
		//跳转到商城界面
		@RequestMapping("toShop")
	    public String toShop() {
			return "user/goodslist";
		}
				
				//登出
		@RequestMapping("logout")
		public String logout(Model m,HttpServletRequest req) {
			req.getSession().removeAttribute("uid");
			req.getSession().removeAttribute("name");
			req.getSession().removeAttribute("role");
					
		return "redirect:tologin";
				
				}
		//跳转到添加题目界面
		@RequestMapping("/toaddquestion")
		public String toaddquestion(Integer bank_id, String bank_name,Model model) {
			model.addAttribute("bank_id", bank_id);
			model.addAttribute("bank_name", bank_name);
//			return "addQuestion";
			return "addQuestion";
		}
		//到教师主页，测试用，后期删掉
		@RequestMapping("/tozhuye")
		public String tozhuye() {
			return "reportlist";
		}
		
}
