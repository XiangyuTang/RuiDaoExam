package com.neuedu.ruidaoexam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.exportExcel.HeadName;
import com.neuedu.ruidaoexam.exportExcel.WriteExcelTool;
import com.neuedu.ruidaoexam.exportExcel.dataName;
import com.neuedu.ruidaoexam.service.impl.ExcelExportServiceimpl;

@Controller
public class excelExportController {
	
	@Autowired
	ExcelExportServiceimpl  excelExportServiceimpl;
	
	@RequestMapping("/export")
	public String exportExcel() {//把试卷的名字和ID传进来,导出考试详情
		int paper_id = 1;
		ArrayList<String> sheetNames = excelExportServiceimpl.sheetNames();
		ArrayList<HeadName> headNames = excelExportServiceimpl.headNames();
		ArrayList<dataName> dataNames = excelExportServiceimpl.dataNames(paper_id);
		
		
		System.out.println("testststststststststststst"+dataNames.get(0).getDatas().size());
		WriteExcelTool wet = new WriteExcelTool();
		wet.createXslsWithSheet(sheetNames, headNames, dataNames, "diyiciceshi");
		
		return "addQuestion";
	}
	
	@RequestMapping("/export1")
	public String exportExcel1() {//导出考试总结
		int paper_id = 1;
		WriteExcelTool wet = new WriteExcelTool();
		ArrayList<String> sheetNames1 = excelExportServiceimpl.allSheetNames();
		ArrayList<HeadName> headName1 = excelExportServiceimpl.allHeadNames();
		ArrayList<dataName> dataNames1 = excelExportServiceimpl.allDataNames(paper_id);
		wet.createXslsWithSheet(sheetNames1, headName1, dataNames1, "dierciceshi");
		return "addQuestion";
	}
}
