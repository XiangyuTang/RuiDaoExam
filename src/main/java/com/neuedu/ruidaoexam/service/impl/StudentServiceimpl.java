package com.neuedu.ruidaoexam.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.AnsweredPaperMapper;
import com.neuedu.ruidaoexam.dao.PaperMapper;
import com.neuedu.ruidaoexam.dao.ReportMapper;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.dao.TeacherMapper;
import com.neuedu.ruidaoexam.dao.TradeRecordMapper;
import com.neuedu.ruidaoexam.entity.AnsweredPaperExample;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.ReportExample;
import com.neuedu.ruidaoexam.entity.ReportExample.Criteria;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.StudentDataVO;
import com.neuedu.ruidaoexam.entity.TradeRecord;
import com.neuedu.ruidaoexam.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService{
    @Autowired StudentMapper stumapper;
    @Autowired ReportMapper reportmapper;
    @Autowired AnsweredPaperMapper answeredpapermapper;
    @Autowired TeacherMapper teachermapper;
    @Autowired TradeRecordMapper traderecordmapper;
    @Autowired PaperMapper papermapper;

	@Override
	public int registStudent(Student stu) {
		// TODO Auto-generated method stub
		int i=stumapper.insert(stu);
		return i;
	}
	@Override
	public List<Report> getGradeList(Integer stuid) {
		ReportExample reportExample=new ReportExample();
		Criteria criteria=reportExample.createCriteria();
		criteria.andStuIdEqualTo(stuid);
		criteria.andIsAllowedToSeeEqualTo(1);
		List<Report> reports=reportmapper.selectByExample(reportExample);
		return reports;
		
	}

	@Override
	public Integer getNumberofAnswered(Integer stuid) {
		AnsweredPaperExample answeredPaperExample=new AnsweredPaperExample();
		com.neuedu.ruidaoexam.entity.AnsweredPaperExample.Criteria criteria=answeredPaperExample.createCriteria();
		criteria.andStuIdEqualTo(stuid);
		int numberOfansweredPaper=answeredpapermapper.countByExample(answeredPaperExample);
		return numberOfansweredPaper;
	}
	@Override
	public Integer getNumberofNotAnswered(Integer stuid) {
		List<Paper> notAnsweredPapers=stumapper.showNotAnswered(stuid);
		int numberofNotAnsweredPaper=notAnsweredPapers.size();
		return numberofNotAnsweredPaper;
	}
	@Override
	public List<Paper> getNotAnsweredList(Integer stuid) {
		// TODO Auto-generated method stub
		return stumapper.showNotAnswered(stuid);
	}
	@Override
	public int addPoint(Integer stuid,Integer addNum) {
		int i=stumapper.addPoint(stuid, addNum);
		System.out.println("牛逼嗷增加成功了");
		return i;
	}
	@Override
	public int degradePoint(Integer stuid, Integer degradeNum) {
		int i=stumapper.addPoint(stuid, degradeNum);
		System.out.println("牛逼嗷减少成功了");
		return i;
	}
	@Override
	public List<Map<String,Object>> getBoughtPapers(Integer stuid) {
		List<Map<String,Object>> boughtPapers = stumapper.boughtPapers(stuid);
		return boughtPapers;
	}
	@Override
	public Boolean buyPaper(Integer stuid,Integer paper_id) {
		Integer price=papermapper.selectByPrimaryKey(paper_id).getPointPrice();
		Integer teacher_id=papermapper.selectByPrimaryKey(paper_id).getCreatedbyteacherid();
		 if(stumapper.selectByPrimaryKey(stuid).getPoints()<price) {
			 return false;
		 }
		int i =stumapper.degradePoint(stuid, price);
		int j=teachermapper.addPoint(teacher_id, price);
		TradeRecord record=new TradeRecord();
		record.setSellerId(teacher_id);
		record.setPoints(price);
		record.setTime(new Date());
		record.setProductType(2);
		record.setPaperId(paper_id);
		record.setBuyerType(2);
		record.setBuyerSId(stuid);
		int o=traderecordmapper.insertSelective(record);
		if(i!=0&&j!=0&&o!=0) {
			return true;
		}
		return false;
	}
	@Override
	
	public Student getStudent(Integer stuid) {
		// TODO Auto-generated method stub
		Student student = stumapper.selectByPrimaryKey(stuid);
		return student;
	}
}
