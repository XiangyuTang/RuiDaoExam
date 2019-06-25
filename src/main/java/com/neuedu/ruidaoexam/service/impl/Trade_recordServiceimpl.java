package com.neuedu.ruidaoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.QuestionBankMapper;
import com.neuedu.ruidaoexam.dao.TradeRecordMapper;
import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.entity.TradeRecord;
import com.neuedu.ruidaoexam.entity.TradeRecordExample;
import com.neuedu.ruidaoexam.entity.TradeRecordExample.Criteria;
import com.neuedu.ruidaoexam.service.Trade_recordService;
@Service
public class Trade_recordServiceimpl implements Trade_recordService {
	@Autowired
	TradeRecordMapper tradeRecordMapper;
	@Autowired
	QuestionBankMapper questionBankMapper;
	
	//通过老师的id查询其购买的题库
	@Override
	public List<QuestionBank> getQusetionBankByTeacherid(Integer Teacher_id) {
		TradeRecordExample tradeRecordExample = new TradeRecordExample();
		Criteria createCriteria = tradeRecordExample.createCriteria();
		createCriteria.andBuyerTIdEqualTo(Teacher_id);
		List<TradeRecord> trade_records= tradeRecordMapper.selectByExample(tradeRecordExample);
		List<QuestionBank> questionBanks = new ArrayList<QuestionBank>();
		for(TradeRecord tradeRecord:trade_records) {
//			System.out.println(tradeRecord.getTradeId());
//			System.out.println(tradeRecord.getTime());
//			System.out.println(tradeRecord.getBankId());
			if (tradeRecord.getBankId() != null) {
				QuestionBank questionBank = questionBankMapper.selectByPrimaryKey(tradeRecord.getBankId());
				questionBanks.add(questionBank);	
			}
//			QuestionBank questionBank = questionBankMapper.selectByPrimaryKey(tradeRecord.getBankId());
////			System.out.println(questionBank.getQuesBankName());
//			questionBanks.add(questionBank);
		}
		return questionBanks;
	}

}
