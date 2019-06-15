package com.neuedu.ruidaoexam.controller;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 单文件上传的控制器
 * @author Administrator
 *
 */
@Controller
public class UploadController {

	// @RequestMapping 
	// @GetMapping  @PostMapping 这两个注解需要请求的方式必须是get /post  ,urlmapping一致, 才能进入该方法
	@GetMapping("/toupload")
    public String upload() {
        return "upload";
    }

    /**
     * @RequestParam  指定了前页面中某个控件name属性的值
     * @param file
     * @param request
     * @return
     */
	@PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        //fileName可以用自己的生成方案，我这里只简单用的原始文件名称
        String fileName = file.getOriginalFilename();
        String filePath = request.getServletContext().getRealPath("/upload");
	    //如果没有该文件夹,创建文件夹,有,就跳过
        File fileFolder = new File(filePath);
		if (!fileFolder.exists()) {
			fileFolder.mkdirs();
		}
		
		//目标文件的路径和文件名
        File dest=new File(filePath,fileName);
        try {
            file.transferTo(dest);// transferTo() 将二进制流写入到某个目标文件上
            return "上传成功";
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return "上传失败！";
    }
}
