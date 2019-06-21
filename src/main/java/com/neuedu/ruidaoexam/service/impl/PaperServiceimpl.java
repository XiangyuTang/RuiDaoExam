package com.neuedu.ruidaoexam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.QuestionBankMapper;
import com.neuedu.ruidaoexam.dao.TradeRecordMapper;
import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.entity.QuestionBankExample;
import com.neuedu.ruidaoexam.entity.QuestionBankExample.Criteria;
import com.neuedu.ruidaoexam.entity.TradeRecordExample;
import com.neuedu.ruidaoexam.service.PaperService;
@Service
public class PaperServiceimpl implements PaperService {
	@Autowired
	TradeRecordMapper tradeRecordMapper;
	@Autowired
	QuestionBankMapper questionBankMapper;
	@Override
	public List<QuestionBank> getQusetionBankByTeacherid(Integer Teacher_id) {
		QuestionBankExample questionBankExample = new QuestionBankExample();
		Criteria createCriteria = questionBankExample.createCriteria();
		createCriteria.andCreatedbyteacheridEqualTo(Teacher_id);
		List<QuestionBank> questionBanks = questionBankMapper.selectByExample(questionBankExample);
//		for (QuestionBank questionBank:questionBanks) {
//			System.out.println(questionBank.getQuesBankName());
//		}
		return questionBanks;
	}

}
