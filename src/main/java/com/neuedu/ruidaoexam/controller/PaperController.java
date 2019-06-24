package com.neuedu.ruidaoexam.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Ques_Paper_Mapper;
import com.neuedu.ruidaoexam.service.PaperMapperService;
import com.neuedu.ruidaoexam.service.PaperService;
@Controller
public class PaperController {
	List<Ques_Paper_Mapper> Mappers = new ArrayList<Ques_Paper_Mapper>();
	@Autowired
	PaperService paperService;
	@Autowired
	PaperMapperService paperMapperService;
	
	//记录选取了哪些题目（此处防止重复选题，前台很难实现刷新是记录已选题目）
	@RequestMapping("/addquestomapper")
	@ResponseBody
	public String addquestomapper(Integer questype, Integer quesid, String score) {
//		System.out.println("wwwwwwwwwwwwwwwwwwwwwwwww");
		for (Ques_Paper_Mapper mapper:Mappers) {
			System.out.println(mapper.getQuesType());
			if (mapper.getQuesType() == questype && (mapper.getCqId()==quesid || mapper.getEqId()==quesid || mapper.getJqId()==quesid)) {
				return "false";
			}
		}
		if (questype == 1 || questype == 2) {
			Ques_Paper_Mapper ques_Paper_Mapper = new Ques_Paper_Mapper();
			ques_Paper_Mapper.setQuesType(questype);
			ques_Paper_Mapper.setCqId(quesid);
			ques_Paper_Mapper.setScore(score);
			Mappers.add(ques_Paper_Mapper);
		}else if (questype == 4) {
			Ques_Paper_Mapper ques_Paper_Mapper = new Ques_Paper_Mapper();
			ques_Paper_Mapper.setQuesType(questype);
			ques_Paper_Mapper.setJqId(quesid);;
			ques_Paper_Mapper.setScore(score);
			Mappers.add(ques_Paper_Mapper);
		}else {
			Ques_Paper_Mapper ques_Paper_Mapper = new Ques_Paper_Mapper();
			ques_Paper_Mapper.setQuesType(questype);
			ques_Paper_Mapper.setEqId(quesid);;
			ques_Paper_Mapper.setScore(score);
			Mappers.add(ques_Paper_Mapper);
		}
		return "true";
	}
	
	//添加试卷，此处可以尝试使用activemq
	@RequestMapping("/addpaper")
	@ResponseBody
	public String addpaper(String papername, Integer papertime) {
		Integer total_score = 0;
//		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
		if (Mappers.isEmpty()) {
			return "false1";
		}
		for (Ques_Paper_Mapper mapper:Mappers) {
			Integer score = Integer.parseInt(mapper.getScore());
			total_score += score;
		}
		Paper paper = new Paper();
		paper.setPaperName(papername);
		paper.setCreatedbyteacherid(1);
		paper.setPaperTime(papertime);
		paper.setTotalScore(total_score);
		Integer paperid = paperService.addPaper(paper);
		for (Ques_Paper_Mapper mapper:Mappers) {
			mapper.setPaperId(paperid);
			int i = paperMapperService.addMapper(mapper);
		}
		Mappers.clear();
		return "true";
	}
}
