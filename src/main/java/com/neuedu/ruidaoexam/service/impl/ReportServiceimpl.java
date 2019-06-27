package com.neuedu.ruidaoexam.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.ReportMapper;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.service.ReportService;

@Service
public class ReportServiceimpl implements ReportService{
	
	@Autowired
	ReportMapper reportMapper;
	
	
	@Override
	public void addComment(ArrayList<String> reportArray) {
		
		Report report = new Report();
		report.setReportId(Integer.parseInt(reportArray.get(0)));
		report.setPaperId(Integer.parseInt(reportArray.get(1)));
		report.setStuId(Integer.parseInt(reportArray.get(2)));
		report.setAcquiredScore(Integer.parseInt(reportArray.get(3)));
		report.setTotalScore(Integer.parseInt(reportArray.get(4)));
		report.setComment(reportArray.get(5));
		
		//String类型转换为Date类型
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sBeginTimestamp = reportArray.get(6);
        Date dsBeginTimestamp = null;
		try {
			dsBeginTimestamp = simpleDateFormat.parse(sBeginTimestamp);
		} catch (ParseException e1) {
		}
        String sEndTimestamp = reportArray.get(7);
        Date dEndTimestamp = null;
		try {
			dEndTimestamp = simpleDateFormat.parse(sEndTimestamp);
		} catch (ParseException e) {
		}
        
		report.setBeginTimestamp(dsBeginTimestamp);
		report.setEndTimestamp(dEndTimestamp);
		report.setSwitchTimes(Integer.parseInt(reportArray.get(8)));
		report.setIsAllowedToSee(Integer.parseInt(reportArray.get(9)));
		
		reportMapper.updateByPrimaryKey(report);
		
	}

	@Override
	public void deleteReport(int report_id) {
		
		reportMapper.deleteByPrimaryKey(report_id);
		
		
	}

	@Override
	public int getPaper_id(int report_id) {
		int i=reportMapper.getPaper_id(report_id);
		return i;
	}

	@Override
	public int addReport(Report r) {
		// TODO Auto-generated method stub
		int i = reportMapper.updateAndInsert(r);
		return i;
	}

	@Override
	public int getReport(int paper_id, int stu_id) {
		// TODO Auto-generated method stub
		int i = reportMapper.selectPrimeKey(paper_id, stu_id);
		return i;
	}


}
