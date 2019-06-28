package com.neuedu.ruidaoexam.service;

import java.util.HashMap;
import java.util.List;

import com.neuedu.ruidaoexam.entity.Paper;

public interface PaperService {
	//添加卷子并返回其id号
	Integer addPaper(Paper paper);
	String getPaper_name(Integer paper_id);
	//根据教师的id选择其创建和购买的卷子
	HashMap<String, Object> getPaperByTeacherId(Integer TeacherId);
	//获取教师所有的卷子
	public List<Paper> getPapersByTeacherid(Integer TeacherId);
	//删除卷子
	int deletePaperByPaperId(Integer PaperId);
	
	List<Paper> getAllSelledPapers(Integer stuid);//0626 lb 商城展示页 展示所有已卖出的卷子
	
	List<Paper> getCertainTypeSelledPapers(Integer type,Integer stuid); //0626 lb 商城展示页 展示特定类别要卖出的卷子
}
