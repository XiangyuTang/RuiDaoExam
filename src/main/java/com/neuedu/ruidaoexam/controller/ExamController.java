package com.neuedu.ruidaoexam.controller;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.ruidaoexam.configUtils.FaceDetect;
import com.neuedu.ruidaoexam.entity.AnsweredPaper;
import com.neuedu.ruidaoexam.entity.AnsweredQuestion;
import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;
import com.neuedu.ruidaoexam.entity.MsgOfExamEnd;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.entity.MsgOfUpdateQuestion;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.service.AnsweredPaperService;
import com.neuedu.ruidaoexam.service.AnsweredQuestionService;
import com.neuedu.ruidaoexam.service.InviteService;
import com.neuedu.ruidaoexam.service.QuestionPaperService;
import com.neuedu.ruidaoexam.service.ReportService;
import com.neuedu.ruidaoexam.service.StudentService;

import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class ExamController {
	
	@Autowired
	InviteService inviteService;
	
	@Autowired
	QuestionPaperService questionPaperService;
	
	@Autowired
	AnsweredPaperService answeredPaperService;
	
	@Autowired
	AnsweredQuestionService answeredQuestionService;
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/verifyintoexam",method = RequestMethod.POST)
    @ResponseBody
    public String verifyIntoExam(String email,String invitecode,String base64url,HttpSession session,HttpServletRequest request) {

		String str="";
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();// new Date()为获取当前系统时间
		
		InviteStudent inviteStudent = inviteService.verifyPerson(email,invitecode);
		if(inviteStudent==null)
			return "-3";
		int compareTobegin = now.compareTo(inviteStudent.getBeginTime());//当前时间大于开始时间返回1
		int compareToEnd = now.compareTo(inviteStudent.getEndTime());//当前时间小于结束时间返回-1
		if(compareTobegin==1&&compareToEnd==-1)
		{
			if(inviteStudent!=null)
			{
				Student student = studentService.getStudentByEmail(email);
				
				byte[] b1 = base64topng(base64url);//将Base64编码字符串转换为字节数组
				String savePic1Path = filePath(request, b1);//将字节数组生成图片,并返回图片地址
				
				String faceDataBase64 = student.getFaceData();//从数据库获取用户人脸数据的base64编码的字符串
				byte[] b2 = base64topng(faceDataBase64);//将字符串转换为字节数组
				String savePic2Path = filePath(request, b2);//将字节数组生成图片,并返回图片地址
				String result = FaceDetect.detect(savePic1Path, savePic2Path);
				System.out.println("人脸对比结果："+result);
				
				JSONObject jsonObject = JSON.parseObject(result);
		        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的
				
		        System.out.println(jsonObject.getString("error_msg")+":"+jsonObject.getString("result"));
		        if(jsonObject.getString("error_msg").equals("SUCCESS"))
		        {
		        	JSONObject resultObject = JSON.parseObject(jsonObject.getString("result"));
		        	if(resultObject.getInteger("score")>=80)//人脸对比成功
		        	{
		        		str="1";//代表可以参加考试
		        	}
		        	else
		        	{
		        		str="-1";//人脸不匹配
		        	}
		        }
		        else
		        {
		        	str="-2";//图片清晰度太低，或者没有人脸
		        }
		        session.setAttribute("inviteStudent", inviteStudent);
			}
		}
		else
			str="0";//代表当前时间不在考试范围内
		return str;
	}
	
	//为了浏览器跨域，降低安全性验证，跳过人脸对比验证
	@RequestMapping(value="/verifyintoexam1",method = RequestMethod.POST)
    @ResponseBody
    public String verifyIntoExam1(String email,String invitecode,String base64url,HttpSession session,HttpServletRequest request) {

		String str="";
		Date now = new Date();// new Date()为获取当前系统时间
		
		InviteStudent inviteStudent = inviteService.verifyPerson(email,invitecode);
		if(inviteStudent==null)
			return "-1";
		int compareTobegin = now.compareTo(inviteStudent.getBeginTime());//当前时间大于开始时间返回1
		int compareToEnd = now.compareTo(inviteStudent.getEndTime());//当前时间小于结束时间返回-1
		if(compareTobegin==1&&compareToEnd==-1)
		{
			if(inviteStudent!=null)
			{
		        session.setAttribute("inviteStudent", inviteStudent);
		        str="1";
			}
		}
		else
			str="0";//代表当前时间不在考试范围内
		return str;
	}
	
	@RequestMapping("/importpaper")
    //@ResponseBody
    public String importPaper(Model m,HttpSession session) {
		//List<ChoiceQuestion> singleChoice =  questionPaperService.selectSingleChoice(1);//和上面的paper_id对接
		InviteStudent inviteStudent = (InviteStudent) session.getAttribute("inviteStudent");
		int paper_id = inviteStudent.getPaperId();
		Date begin = new Date();//获取当前考生进入考试的时间
		Date end = inviteStudent.getEndTime();//获取考试的结束时间
		long interval = (end.getTime() - begin.getTime())/1000;//总秒数
		System.out.println(interval);
		m.addAttribute("student_id",inviteStudent.getStudentId());
		m.addAttribute("teacher_id",inviteStudent.getTeacherId());
		m.addAttribute("begin_tstamp", begin);
		m.addAttribute("paper_id",paper_id);
		m.addAttribute("interval", interval);
		m.addAttribute("allowedCheat", inviteStudent.getAllowedCheatTimes());
		List<ChoiceQuestion> singleChoice =  questionPaperService.selectSingleChoice(paper_id);
		List<ChoiceQuestion> multipleChoice =  questionPaperService.selectMultipleChoice(paper_id);
		List<JudgeQuestion> judgeQuestion = questionPaperService.selectJudge(paper_id);
		List<EssayQuestion> fillBlankQuestion = questionPaperService.selectFillBlank(paper_id);
		List<EssayQuestion> shortAnswerQuestion = questionPaperService.selectShortAnswer(paper_id);
		m.addAttribute("singleChoice", singleChoice);
		m.addAttribute("multipleChoice", multipleChoice);
		m.addAttribute("judgeQuestion", judgeQuestion);
		m.addAttribute("fillBlankQuestion", fillBlankQuestion);
		m.addAttribute("shortAnswerQuestion", shortAnswerQuestion);
		int singleChoiceTotalScore = 0;
		int multiChoiceTotalScore = 0;
		int judgeChoiceTotalScore = 0;
		int fillBlankTotalScore = 0;
		int shortAnswerTotalScore = 0;
		if(singleChoice!=null)
			for(ChoiceQuestion cq:singleChoice)
			{
				singleChoiceTotalScore += Integer.parseInt(cq.getScore());
			}
		if(multipleChoice!=null)
			for(ChoiceQuestion cq:multipleChoice)
			{
				multiChoiceTotalScore += Integer.parseInt(cq.getScore());
			}
		if(judgeQuestion!=null)
			for(JudgeQuestion jq:judgeQuestion)
			{
				
				judgeChoiceTotalScore += Integer.parseInt(jq.getScore());
			}
		if(fillBlankQuestion!=null)
			for(EssayQuestion eq:fillBlankQuestion)
			{
				fillBlankTotalScore += Integer.parseInt(eq.getScore());
			}
		if(shortAnswerQuestion!=null)
			for(EssayQuestion eq:shortAnswerQuestion)
			{
				
				shortAnswerTotalScore += Integer.parseInt(eq.getScore());
			}
		int totalScore = singleChoiceTotalScore+multiChoiceTotalScore+judgeChoiceTotalScore+fillBlankTotalScore+shortAnswerTotalScore;
		m.addAttribute("totalScore", totalScore);
		m.addAttribute("singleChoiceTotalScore",singleChoiceTotalScore);
		m.addAttribute("multiChoiceTotalScore",multiChoiceTotalScore);
		m.addAttribute("judgeChoiceTotalScore",judgeChoiceTotalScore);
		m.addAttribute("fillBlankTotalScore",fillBlankTotalScore);
		m.addAttribute("shortAnswerTotalScore",shortAnswerTotalScore);
		
		//下面的逻辑用于添加一条answered_paper记录
		AnsweredPaper answerpaper = new AnsweredPaper(null,paper_id,inviteStudent.getStudentId(),inviteStudent.getTeacherId(),"0");
		//answeredPaperService.insert(answerpaper);
		int i = 0;
		Integer pk = null; 
		int flag = 0;
		try {
			pk = answeredPaperService.selectPrimeKey(answerpaper);
		}catch (org.apache.ibatis.binding.BindingException e) {
			// TODO: handle exception
			i = answeredPaperService.insert(answerpaper);
			
			System.out.println(answerpaper.getAnsPaperId());
			//pk = answeredPaperService.selectPrimeKey(answerpaper);
			//answerpaper.setAnsPaperId(pk);
			m.addAttribute("ans_paper_id",answerpaper.getAnsPaperId());
			flag = 1;
		}
		if(flag == 0)
		{
			answerpaper.setAnsPaperId(pk);
			i = answeredPaperService.insert(answerpaper);
			m.addAttribute("ans_paper_id",pk);			
			System.out.println(i);
		}
		return "examing";
	}
	
	//考试结束页面
	@RequestMapping("/toExamOver")
	public String toExamOver(HttpServletRequest request) {
		
		return "examOver";
	}
	
	@RequestMapping(value="/analysePaper",method = RequestMethod.POST)
	@ResponseBody
	public String analysePaper(@RequestBody MsgOfExamEnd msg,HttpSession session) {
		//System.out.println(msg.getBeginTimeStamp());
		//String s = "Thu Jun 27 15:47:14 CST 2019";
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp begin_time = null;
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String es = sdf.format(date1);//时间存储为字符串
		Timestamp end_time = null;
		end_time = Timestamp.valueOf(es);
		try {
			String ts = sdf2.format(sdf1.parse(msg.getBeginTimeStamp()));
			begin_time = Timestamp.valueOf(ts);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int acquired_score = answeredQuestionService.selectScores(msg.getPaper_id());
		Report r = new Report(null,msg.getPaper_id(),msg.getStu_id(),acquired_score,msg.getTotalScores(),msg.getComment(),begin_time,end_time,msg.getSwitch_time(),1);
		int flag = 0;
		int pk = 0;
		try {
			pk = reportService.getReport(msg.getPaper_id(), msg.getStu_id());
		}catch(org.apache.ibatis.binding.BindingException e){
			reportService.addReport(r);
			flag = 1;
		}
		if(flag == 0)
		{
			r.setReportId(pk);
			reportService.addReport(r);
		}
		Student s = studentService.getStudent(msg.getStu_id());
		String name = s.getName();
		session.setAttribute("stu_score", acquired_score);
		session.setAttribute("stu_name", name);
		session.setAttribute("paper_total_score", msg.getTotalScores());
		//System.out.println(msg.toString());
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


