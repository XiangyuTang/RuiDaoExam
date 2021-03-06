package com.neuedu.ruidaoexam.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.service.LogAndRegService;
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
	@Autowired
	LogAndRegService logandregservice;

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
	public String toindex(HttpServletRequest request) {
		if (request.getSession().getValue("role") == "student") {
			return "index";
		} else {
			return "redirect:tologin";
		}
	}
	
	@RequestMapping("/tophoto")
	public String takephoto()
	{
		return "TakePhoto";
	}

	// 注册页
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "user/reg";
	}

	// 登录页
	@RequestMapping("tologin")
	public String toLogin(Model model,HttpServletRequest req,HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();
		HttpSession session = req.getSession();
		String uid=null,name=null,role=null;
		for(Cookie ck:cookies) {
			if(ck.getName().equals("uid")) {
				System.out.println("堵到了cookie："+ck.getValue());
				uid = ck.getValue();
			}else if(ck.getName().equals("name")){
				name = ck.getValue();
				if(name != null)
				role = logandregservice.getUserType(name);
			}
//			else if(ck.getName() == "role") {
//				role = ck.getValue();
//			}
		}
		if(uid == null || uid.equals("undefined") || uid.equals("null")) {
			System.out.println("此时cookie name:"+name);
			return "user/login";
		}else {
			System.out.println("在cookie登录中，uid,name,role为："+uid+","+name+","+role);
			session.setAttribute("uid", uid);
			session.setAttribute("name", name);
			session.setAttribute("role", role);
			if(role.equals("teacher"))
				return "indexteacher";
			else if(role.equals("student"))
				return "index";
			else
				return "toRegister";
		}
	}
	//跳转到组卷界面
	@RequestMapping("/toshoudong")
	public String toshoudong(Model model,HttpServletRequest request) {
		// 此处的teacher_id应该是session中的内容
		HttpSession session = request.getSession();
		Integer uid_new = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
		List<QuestionBank> questionBanks = questionBankService.getQusetionBankByTeacherid(uid_new);
		List<QuestionBank> questionBanks2 = trade_recordService.getQusetionBankByTeacherid(uid_new);
		for (QuestionBank questionbank : questionBanks2) {
			questionBanks.add(questionbank);
		}
		for (QuestionBank questionBank : questionBanks) {
			System.out.println(questionBank.getQuesBankName());
		}
//		System.out.println("WWWWWWWWWWWWWWWWWWWWWWW");
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
	@RequestMapping("/")
	public ModelAndView tohome(ModelMap model, RedirectAttributes attr) {
		return new ModelAndView("redirect:/Home");

//		return "/Home";
	}
	
	@RequestMapping("/tohome")
	public String tostuhome() {
		return "/Home";
	}
	
	// 教师个人中心
	@RequestMapping("/toindexteacher")
	public String toindexteacher(HttpServletRequest request) {
		if (request.getSession().getValue("role") == "teacher") {
			return "indexteacher";
		} else {
			return "redirect:tologin";
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
	//个人信息-基本资料
	@RequestMapping("/toUserbaseinfo")
	public String toUserbaseinfo() {
		return "user/baseinfo";
	}
	//个人信息-修改密码
	@RequestMapping("/toUserchangepwd")
	public String toUserchangepwd() {
		return "user/changepwd";
	}
	//忘记密码
	@RequestMapping("/toforget")
	public String toforget() {
		return "user/forget";
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
		
	    // 个人中心
		@RequestMapping("toBaseInfo")
		public String toStuBaseInfo() {
			return "user/baseinfo";
		}
		
		
		//修改密码
		@RequestMapping("toChangePassword")
		public String toStuForget() {
			return "user/changepwd";
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
	    public String toShop(HttpServletRequest request) {
			if (request.getSession().getValue("role") == "student") {
				return "student/goodslist";
			} else if(request.getSession().getValue("role") == "teacher") {
				return "teacher/goodslist";
			}else {
				return "redirect:tologin";
			}
		}
		//跳转到测试商城
		@RequestMapping("totext")
	    public String totext(HttpServletRequest request) {
			
				return "user/goodslist";
		}
		//登出
		@RequestMapping("logout")
		public String logout(Model m,
				HttpServletRequest req,
				HttpServletResponse res) {
			req.getSession().removeAttribute("uid");
			req.getSession().removeAttribute("name");
			req.getSession().removeAttribute("role");
			Cookie[] cookies = req.getCookies();
			HttpSession session = req.getSession();
			String uid=null,name=null,role = null;
			for(Cookie ck:cookies) {
				if(ck.getName().equals("uid")||
						ck.getName().equals("name")) {
					ck.setValue(null);
					ck.setMaxAge(0);
					res.addCookie(ck);
				}
			}
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

		@RequestMapping("/toshangcheng")
		public String toshangcheng() {
			return "user/goodslist";
		}
		
		@RequestMapping("/todenglu")
		public String todenglu() {
			return "user/login";
		}
		
		@RequestMapping("/tozhuce")
		public String tozhuce() {
			return "user/reg";
		}
		@RequestMapping("/toaddbank")
		public String toaddbank() {
			return "addbank";
		}
		
}



