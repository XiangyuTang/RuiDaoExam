package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.service.impl.addQuestionServiceimpl;

@Controller
public class addQuestionControllerPage {
	
	@Autowired
	addQuestionServiceimpl aqsi;
	
	@RequestMapping("/submitForm")
	public String submitForm(HttpServletRequest request) {
		int bank_id = 1;
		ArrayList<String> questionsArray = new ArrayList<String>();
		String atNum = request.getSession().getAttribute("atNum").toString();
		String qtNum = request.getSession().getAttribute("qtNum").toString();
		int questionType = Integer.parseInt(qtNum);//dan duo wen pan tian
		if(questionType == 1) {
			String tigan = request.getParameter("tigan");
			String xuanxiangA = request.getParameter("xuanxiangA");
			String xuanxiangB = request.getParameter("xuanxiangB");
			String xuanxiangC = request.getParameter("xuanxiangC");
			String xuanxiangD = request.getParameter("xuanxiangD");
			String jiexi = request.getParameter("jiexi");
			String daan = request.getParameter("daan");
			String nandu = request.getParameter("score");
			questionsArray.add(qtNum);
			questionsArray.add(tigan);
			questionsArray.add(xuanxiangA);
			questionsArray.add(xuanxiangB);
			questionsArray.add(xuanxiangC);
			questionsArray.add(xuanxiangD);
			questionsArray.add(daan);
			questionsArray.add(nandu);
			questionsArray.add(jiexi);
			questionsArray.add(atNum);
			System.out.println("ppppppppppppppp"+nandu);
			aqsi.addChoiceQuestion(questionsArray,bank_id);
		}else if(questionType==2){
			String tigan = request.getParameter("tigan1");
			String xuanxiangA = request.getParameter("xuanxiangA1");
			String xuanxiangB = request.getParameter("xuanxiangB1");
			String xuanxiangC = request.getParameter("xuanxiangC1");
			String xuanxiangD = request.getParameter("xuanxiangD1");
			String jiexi = request.getParameter("jiexi1");
			String daan = request.getParameter("daan1");
			String nandu = request.getParameter("score1");
			questionsArray.add(qtNum);
			questionsArray.add(tigan);
			questionsArray.add(xuanxiangA);
			questionsArray.add(xuanxiangB);
			questionsArray.add(xuanxiangC);
			questionsArray.add(xuanxiangD);
			questionsArray.add(daan);
			questionsArray.add(nandu);
			questionsArray.add(jiexi);
			questionsArray.add(atNum);
			aqsi.addChoiceQuestion(questionsArray,bank_id);
		}else if(questionType==3) {
			String tigan = request.getParameter("tigan2");
			String daan = request.getParameter("daan2");
			String nandu = request.getParameter("score2");
			questionsArray.add(qtNum);
			questionsArray.add(tigan);
			questionsArray.add(daan);
			questionsArray.add(nandu);
			questionsArray.add(atNum);
			aqsi.addEssayQuestion(questionsArray,bank_id);
		}else if(questionType==4) {
			String tigan = request.getParameter("tigan3");
			String xuanxiangA = request.getParameter("xuanxiangA3");
			String xuanxiangB = request.getParameter("xuanxiangB3");
			String daan = request.getParameter("daan3");
			String nandu = request.getParameter("score3");
			questionsArray.add(qtNum);
			questionsArray.add(tigan);
			questionsArray.add(daan);
			questionsArray.add(nandu);
			questionsArray.add(atNum);
			aqsi.addJudgeQuestion(questionsArray,bank_id);
		}else {
			String tigan = request.getParameter("tigan4");
			String daan = request.getParameter("daan4");
			String nandu = request.getParameter("score4");
			questionsArray.add(qtNum);
			questionsArray.add(tigan);
			questionsArray.add(daan);
			questionsArray.add(nandu);
			questionsArray.add(atNum);
			aqsi.addEssayQuestion(questionsArray,bank_id);
		}
		return "addQuestion";
	}
}
