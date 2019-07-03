package com.neuedu.ruidaoexam.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.NewsMapper;
import com.neuedu.ruidaoexam.dao.PaperMapper;
import com.neuedu.ruidaoexam.dao.QuestionBankMapper;
import com.neuedu.ruidaoexam.dao.TeacherMapper;
import com.neuedu.ruidaoexam.dao.TradeRecordMapper;
import com.neuedu.ruidaoexam.entity.News;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.PaperExample;
import com.neuedu.ruidaoexam.entity.Ques_Bank_Mapper;
import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.entity.QuestionBankExample;
import com.neuedu.ruidaoexam.entity.Teacher;
import com.neuedu.ruidaoexam.entity.TradeRecord;
import com.neuedu.ruidaoexam.entity.QuestionBankExample.Criteria;
import com.neuedu.ruidaoexam.service.TeacherService;
@Service
public class TeacherServiceimpl implements TeacherService{
 
	@Autowired TeacherMapper mapper;
    @Autowired QuestionBankMapper questionBankMapper;
    @Autowired PaperMapper paperMapper;
    @Autowired BankMapperServiceimpl bankmapperservice;
    @Autowired TradeRecordMapper traderecordmapper;
    @Autowired NewsMapper newsmapper;
	@Override
	public int registTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		int i = mapper.insertSelective(teacher);
		return i;
	}
	@Override
	public String getTeacherNameByPaper(Integer created_id) {
			return mapper.selectByPrimaryKey(created_id).getName();
	}
	@Override
	public int addPoint(Integer teacherid, Integer addNum) {
		int i=mapper.addPoint(teacherid, addNum);
		return i;
	}
	@Override
	public int degradePoint(Integer teacherid, Integer degradeNum) {
		int i=mapper.degradePoint(teacherid, degradeNum);
		return i;
	}
	@Override
	public List<QuestionBank> getSelledBanksByTeacherid(Integer teacher_id) {
		QuestionBankExample questionBankExample = new QuestionBankExample();
		Criteria createCriteria = questionBankExample.createCriteria();
		createCriteria.andCreatedbyteacheridEqualTo(teacher_id);
		createCriteria.andPointPriceGreaterThan(0);
		List<QuestionBank> questionBanks = questionBankMapper.selectByExample(questionBankExample);
		for (QuestionBank questionBank:questionBanks) {
			System.out.println(questionBank.getQuesBankName());
		}
		return questionBanks;
	}
	@Override
	public int cancelSellBank(Integer bank_id, Integer teacher_id) {
		return questionBankMapper.cancelSellBank(bank_id, teacher_id);
	}
	
	@Override
	public List<Paper> getSelledPapersByTeacherid(Integer teacher_id) {
		PaperExample paperExample = new PaperExample();
		com.neuedu.ruidaoexam.entity.PaperExample.Criteria paperCriteria = paperExample.createCriteria();
		paperCriteria.andCreatedbyteacheridEqualTo(teacher_id);
		paperCriteria.andPointPriceGreaterThan(0);
		List<Paper> selledPapers=paperMapper.selectByExample(paperExample);
		return selledPapers;
	}
	@Override
	public int cancelSellPaper(Integer paper_id, Integer teacher_id) {
		return paperMapper.cancelSellPaper(paper_id, teacher_id);
	}
	@Override
	public int sellPaper(Integer paper_id, Integer price, Integer teacher_id) {
		return paperMapper.sellPaper(paper_id, price, teacher_id);
	}
	@Override
	public int sellBank(Integer bank_id, Integer price, Integer teacher_id) {
		return questionBankMapper.sellBank(bank_id, price, teacher_id);

	}
	@Override
	public Boolean buyBanks(Integer buyer_id,  Integer bank_id) {
		Integer seller_id=questionBankMapper.selectByPrimaryKey(bank_id).getCreatedbyteacherid();
		 Integer price=questionBankMapper.selectByPrimaryKey(bank_id).getPointPrice();
		 if(mapper.selectByPrimaryKey(buyer_id).getPoints()<price) {
			 return false;
		 }
		mapper.addPoint(seller_id, price);
		mapper.degradePoint(buyer_id, price);
		 
		QuestionBank bank=questionBankMapper.selectByPrimaryKey(bank_id);
		bank.setCreatedbyteacherid(buyer_id);
		bank.setQuesBankId(null);
		bank.setPointPrice(0);
		questionBankMapper.addBank(bank);
		int newID =bank.getQuesBankId();
		System.out.println(newID);
		List<Ques_Bank_Mapper> mappers = bankmapperservice.getMappersByPaperid(bank_id);
		Boolean copyMapper = bankmapperservice.copyMapper(newID, mappers);
		TradeRecord record=new TradeRecord();
		record.setSellerId(seller_id);
		record.setPoints(price);
		record.setTime(new Date());
		record.setProductType(1);
		record.setBankId(bank_id);
		record.setBuyerType(1);
		record.setBuyerTId(buyer_id);
		int i=traderecordmapper.insertSelective(record);
		News news=new News();
		news.setReceiveTypeId(1);
		news.setReceiveTeacherId(seller_id);
		news.setSendTypeId(1);
		news.setSendTeacherId(buyer_id);
		news.setSendName(mapper.selectByPrimaryKey(buyer_id).getName());
		news.setNewsType(1);
		news.setNewsTime(new Date());
		news.setNewsContent("老师发送");
		news.setIsRead(0);
		int j=newsmapper.insertSelective(news);
		if(copyMapper&&i!=0&&j!=0)
			return true;
		
		return false;
	}
	@Override
	public List<QuestionBank> getUnselledBankByTeacherid(Integer teacher_id) {
		QuestionBankExample questionBankExample = new QuestionBankExample();
		Criteria createCriteria = questionBankExample.createCriteria();
		createCriteria.andCreatedbyteacheridEqualTo(teacher_id);
		createCriteria.andPointPriceEqualTo(0);
		List<QuestionBank> questionBanks = questionBankMapper.selectByExample(questionBankExample);
		for (QuestionBank questionBank:questionBanks) {
			System.out.println(questionBank.getQuesBankName());
		}
		return questionBanks;
	}
	@Override
	public List<Paper> getUnselledPaperByTeacherid(Integer teacher_id) {
		PaperExample paperExample = new PaperExample();
		com.neuedu.ruidaoexam.entity.PaperExample.Criteria paperCriteria = paperExample.createCriteria();
		paperExample.setOrderByClause("paper_id desc");
		paperCriteria.andCreatedbyteacheridEqualTo(teacher_id);
		paperCriteria.andPointPriceEqualTo(0);
		List<Paper> selledPapers=paperMapper.selectByExample(paperExample);
		return selledPapers;
	}
	
	@Override
	public Teacher getTeacher(Integer teacherid) {
		return mapper.selectByPrimaryKey(teacherid);
	}
}
