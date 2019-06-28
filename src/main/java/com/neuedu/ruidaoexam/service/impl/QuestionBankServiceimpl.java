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
import com.neuedu.ruidaoexam.service.QuestionBankService;
@Service
public class QuestionBankServiceimpl implements QuestionBankService {
	@Autowired
	TradeRecordMapper tradeRecordMapper;
	@Autowired
	QuestionBankMapper questionBankMapper;
	
	//通过老师id查询其创建的题库
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
	@Override
	public int deleteBankByBankId(Integer Bank_id) {
		int rs = questionBankMapper.deleteByPrimaryKey(Bank_id);
		return rs;
	}
	@Override
	public List<QuestionBank> getAllSelledBanks(Integer teacherid) {
		QuestionBankExample questionBankExample = new QuestionBankExample();
		Criteria createCriteria = questionBankExample.createCriteria();
		createCriteria.andPointPriceGreaterThan(0);
		createCriteria.andCreatedbyteacheridNotEqualTo(teacherid);
		List<Integer> boughtBankIDs = tradeRecordMapper.getBoughtBankIDs(teacherid);
		for (Integer integer : boughtBankIDs) {
			System.out.println(integer);
		}
		if(tradeRecordMapper.getBoughtBankIDs(teacherid).size()>0) {
			createCriteria.andQuesBankIdNotIn(tradeRecordMapper.getBoughtBankIDs(teacherid));
		}
		
		List<QuestionBank> questionBanks = questionBankMapper.selectByExample(questionBankExample);
		for (QuestionBank questionBank:questionBanks) {
			System.out.println(questionBank.getQuesBankName());
		}
		return questionBanks;
	}

	@Override
	public List<QuestionBank> getCertainTypeSelledBanks(Integer type,Integer teacherid) {
		QuestionBankExample questionBankExample = new QuestionBankExample();
		Criteria createCriteria = questionBankExample.createCriteria();
		createCriteria.andPointPriceGreaterThan(0);
		createCriteria.andQuesBankFiledEqualTo(type);
		createCriteria.andCreatedbyteacheridNotEqualTo(teacherid);
		if(tradeRecordMapper.getBoughtBankIDs(teacherid).size()>0) {
		createCriteria.andQuesBankIdNotIn(tradeRecordMapper.getBoughtBankIDs(teacherid));
		}
		List<QuestionBank> questionBanks = questionBankMapper.selectByExample(questionBankExample);
		for (QuestionBank questionBank:questionBanks) {
			System.out.println(questionBank.getQuesBankName());
		}
		return questionBanks;
	}

	@Override
	public Integer addQuestBank(QuestionBank bank) {
		
		return questionBankMapper.addBank(bank);
	}
}
