package com.neuedu.ruidaoexam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.neuedu.ruidaoexam.excel.ExcelUtil;
import com.neuedu.ruidaoexam.excel.PersonDTO;

@Controller
public class ExcelController {

	@RequestMapping("/toexceltest")
	public String test1(){
		return "exceltest";
	}
	
	@RequestMapping("/importexcel")
    @ResponseBody
    public Object test2(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        
		List<Object> list = ExcelUtil.readExcel(file, new PersonDTO(),1);
		
		
		for (Object o : list) {
			System.out.println(o.toString());
		}
		
		return "exceltest-import-success";
    }
	
	@RequestMapping("/importexceltoshow")
    @ResponseBody
    public String test4(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        
		List<Object> list = ExcelUtil.readExcel(file, new PersonDTO(),1);
		
		HashMap map = new HashMap();
		
		for (Object o : list) {
			System.out.println(o.toString());
		}
		map.put("list", list);
		String str = JSON.toJSONString(map); // 利用fastjson转换字符串
		return str; //返回字符串
    }
	
    /**
     * 导出 Excel（一个 sheet）
     */
    @RequestMapping("/exportexcel")
    public void test3(HttpServletResponse response) throws IOException {
        List<PersonDTO> list = getList();//模拟从数据库中得到一个数据集合
        String fileName = "export01";
        String sheetName = "sheet01";

        ExcelUtil.writeExcel(response, list, fileName, sheetName, new PersonDTO());
    }
	

    private List<PersonDTO> getList() {
        List<PersonDTO> list = new ArrayList<>();
        PersonDTO model1 = new PersonDTO();
        model1.setName("昆凌");
        model1.setEmail("123456789@gmail.com");
        list.add(model1);
        PersonDTO model2 = new PersonDTO();
        model2.setName("周杰伦");
        model2.setEmail("198752233@gmail.com");
        list.add(model2);
        return list;
    }
}
