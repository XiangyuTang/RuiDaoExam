package com.neuedu.ruidaoexam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.PaperMapper;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.ReportExample;
import com.neuedu.ruidaoexam.entity.ReportExample.Criteria;
import com.neuedu.ruidaoexam.service.PaperService;
@Service
public class PaperServiceimpl implements PaperService{
	@Autowired
	PaperMapper paperMapper;
	@Override//向试卷表中插入一条数据，同时返回其id值
	public Integer addPaper(Paper paper) {
		paperMapper.addPaper(paper);
		return paper.getPaperId();
	}
	@Override
	public String getPaper_name(Integer paper_id) {
		Paper paper=paperMapper.selectByPrimaryKey(paper_id);
		return paper.getPaperName();
	}

}
