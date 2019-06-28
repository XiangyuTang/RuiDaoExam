package com.neuedu.ruidaoexam.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.configUtils.FaceDetect;



@Controller
public class handlePhotoController {
	
	@RequestMapping(value="/doPhotoRegister",method = RequestMethod.POST)
	@ResponseBody
	public String doPhotoRegister(String base64url,HttpServletRequest request) {
		System.out.println(base64url);
		//接下来就把base64url写到数据库对应user的facedata里就行了
		String src1 = base64url;
		//从页面获取一个base64编码的字符串
		byte[] b1 = base64topng(src1);
		//将字符串转换为字节数组
		String imgFilePath1 = filePath(request, b1);
		//将字节数组生成图片
		System.out.println("注册时的："+imgFilePath1);
		return "老铁666";
	}
	
	
	@RequestMapping(value="/doPhoto",method = RequestMethod.POST)
	@ResponseBody
	public String doPhoto(String base64url,HttpServletRequest request) {
		System.out.println(base64url);
		String src1 = base64url;
		//从页面获取一个base64编码的字符串
		byte[] b1 = base64topng(src1);
		//将字符串转换为字节数组
		String imgFilePath1 = filePath(request, b1);
		//将字节数组生成图片
		System.out.println(imgFilePath1);
		//FaceDetect.detect(pic1, pic2)
		return "666";
	}
	
	public static byte[] base64topng(String imageBase64) {
		byte[] b1 = null;
		//BASE64Decoder decoder = new BASE64Decoder();
		try{
			if (imageBase64.indexOf("data:image/jpeg;base64,") != -1) {
				//b1 = decoder.decodeBuffer(imageBase64.replaceAll("data:image/jpeg;base64,", ""));
				b1 = Base64.decodeBase64(imageBase64.replaceAll("data:image/jpeg;base64,", ""));
				
			} else {
				if (imageBase64.indexOf("data:image/png;base64,") != -1) {
					b1 = Base64.decodeBase64(imageBase64.replaceAll("data:image/png;base64,", ""));
				} else {
					b1 = Base64.decodeBase64(imageBase64.replaceAll("data:image/jpg;base64,", ""));
				}
			}
			for (int i = 0; i < b1.length; ++i) {
				if (b1[i] < 0) {// 调整异常数据
					b1[i] += 256;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return b1;
	}
	
	public static String filePath(javax.servlet.http.HttpServletRequest request,byte[] b) {
		String imgPath = "";
		try {
			String FilePath =request.getSession().getServletContext().getRealPath("/upload");//新生成的图片  
	    	File f1=new File(FilePath);
	    	if(!f1.exists()){
	        	f1.mkdir();
	        }
	    	imgPath = FilePath+"/"+UUID.randomUUID().toString()+".jpg";
	    	File f2 = new File(imgPath);
	    	if(!f2.exists()) {
	    		f2.createNewFile();
	    	}
	    	OutputStream out = new FileOutputStream(imgPath);
			out.write(b);
			out.flush();
			out.close();
	    	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return imgPath;
	}
	
}
