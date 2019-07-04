package com.neuedu.ruidaoexam.exportExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcelTool {
	/**
	 * 
	 * @param sheetNames 子表的名称
	 * @param headNames 头栏的名称
	 * @param dataNmaes 数据
	 */
	public void createXslsWithSheet(ArrayList<String> sheetNames, ArrayList<HeadName> headNames,ArrayList<dataName> dataNames,String fileName) {
		//创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        for(int i = 0; i<sheetNames.size(); i++) {
        	//建立新的sheet对象（excel的表单）
            HSSFSheet sheet=wb.createSheet(sheetNames.get(i));
          //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
           
            //HSSFRow row1=sheet.createRow(i);
            //写sheet
          //写表头
            HSSFRow row0=sheet.createRow(0);//row为行数
            for(int k = 0; k<headNames.get(i).getHeadName().size();k++) {//k遍历表头的字符串
            	row0.createCell(k).setCellValue(headNames.get(i).getHeadName().get(k));
            }		
            //写数据
            dataName dn = dataNames.get(i);
            for(int j = 0;j<dn.getDatas().size();j++) {
            	HSSFRow row=sheet.createRow(j+1);
            	for(int m = 0; m<dn.getDatas().get(j).size();m++) {
            		row.createCell(m).setCellValue(dn.getDatas().get(j).get(m));
            	}
            }
            FileSystemView fsv = FileSystemView.getFileSystemView();
   		 	File com=fsv.getHomeDirectory(); 
   		 	String path1 = com.toString();	
            //输出Excel文件
            File file=new File(path1+"\\"+fileName+".xls");
        	try {
        		file.createNewFile();
        		FileOutputStream stream=FileUtils.openOutputStream(file);
        		wb.write(stream);
        		stream.close();
        	} catch (IOException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        }
       
	}
	
//	public static void main(String[] args) {
//		ArrayList<String> sheetNames = new ArrayList<String>();
//		sheetNames.add("我最帅");
//		sheetNames.add("你最丑");
//		
//		
//		ArrayList<HeadName> hds = new ArrayList<HeadName>();
//		HeadName hd1 = new HeadName();
//		ArrayList<String> headName1 = new ArrayList<String>();
//		headName1.add("姓名");
//		headName1.add("性别");
//		hd1.setHeadName(headName1);
//		
//		HeadName hd2 = new HeadName();
//		ArrayList<String> headName2 = new ArrayList<String>();
//		headName2.add("姓名");
//		headName2.add("性别");
//		hd2.setHeadName(headName2);
//		
//		hds.add(hd1);
//		hds.add(hd2);
//		
//		
//		dataName dn1 = new dataName();
//		ArrayList<ArrayList<String>> rens1 = new ArrayList<ArrayList<String>>();
//		ArrayList<String> zuishuai1 = new ArrayList<String>();
//		zuishuai1.add("李一通");
//		zuishuai1.add("男");
//		rens1.add(zuishuai1);
//		dn1.setDatas(rens1);
//		
//		dataName dn2 = new dataName();
//		ArrayList<ArrayList<String>> rens2 = new ArrayList<ArrayList<String>>();
//		ArrayList<String> zuichou2 = new ArrayList<String>();
//		zuichou2.add("王一");
//		zuichou2.add("女");
//		rens2.add(zuichou2);
//		dn2.setDatas(rens2);
//		
//		ArrayList<dataName> dataNames = new ArrayList<dataName>();
//		dataNames.add(dn1);
//		dataNames.add(dn2);
//		
//		createXslsWithSheet(sheetNames,hds,dataNames,"xiangaidelianggeren");
//	}
}
