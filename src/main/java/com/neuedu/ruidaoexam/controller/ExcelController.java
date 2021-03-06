package com.neuedu.ruidaoexam.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.excel.ExcelUtil;
import com.neuedu.ruidaoexam.excel.PersonDTO;
import com.neuedu.ruidaoexam.excel.QuestionDTO;
import com.neuedu.ruidaoexam.service.InviteService;
import com.neuedu.ruidaoexam.service.impl.addQuestionServiceimpl;

@Controller
public class ExcelController {

	@Autowired
	InviteService inviteService;
	
	@Autowired
	addQuestionServiceimpl aqsi;
	
	@RequestMapping("/toexceltest")
	public String test1(){
		return "exceltest";
	}
	
	@RequestMapping("/importexcel")
    @ResponseBody
    public String test2(@RequestParam(value = "file", required = false) MultipartFile file,int BankId) {
		String result = "ttttttttttttttttttttttttttttt失败";
		System.out.println(result);
		List<Object> list = ExcelUtil.readExcel(file, new QuestionDTO(),1);
		System.out.println("lallaallaalalalall");
		for (Object o : list) {
			System.out.println(o.toString());
			QuestionDTO q = (QuestionDTO) o;
			ArrayList<String> questionsArray = new ArrayList<String>();
			if(Integer.parseInt(q.getQuestion_type())==1) {
				//加入单选择题
				String atNum = q.getAbility_type_id();
				String qtNum = q.getQuestion_type();
				String tigan = q.getContent();
				String xuanxiangA = q.getChoice1();
				String xuanxiangB = q.getChoice2();
				String xuanxiangC = q.getChoice3();
				String xuanxiangD = q.getChoice4();
				String jiexi = q.getAnalysis();
				String daan = q.getAnswer();
				String nandu = q.getDifficulty();
				questionsArray.add(qtNum);
				questionsArray.add(tigan);
				questionsArray.add(xuanxiangA);
				questionsArray.add(xuanxiangB);
				questionsArray.add(xuanxiangC);
				questionsArray.add(xuanxiangD);
				questionsArray.add(daan);
				questionsArray.add(nandu);
				questionsArray.add(jiexi);
				questionsArray.add(atNum);
				aqsi.addChoiceQuestion(questionsArray,BankId);
			}else if(Integer.parseInt(q.getQuestion_type())==2) {
				//加入多项
				String atNum = q.getAbility_type_id();
				String qtNum = q.getQuestion_type();
				String tigan = q.getContent();
				String xuanxiangA = q.getChoice1();
				String xuanxiangB = q.getChoice2();
				String xuanxiangC = q.getChoice3();
				String xuanxiangD = q.getChoice4();
				String jiexi = q.getAnalysis();
				String daan = q.getAnswer();
				String nandu = q.getDifficulty();
				questionsArray.add(qtNum);
				questionsArray.add(tigan);
				questionsArray.add(xuanxiangA);
				questionsArray.add(xuanxiangB);
				questionsArray.add(xuanxiangC);
				questionsArray.add(xuanxiangD);
				questionsArray.add(daan);
				questionsArray.add(nandu);
				questionsArray.add(jiexi);
				questionsArray.add(atNum);
				aqsi.addChoiceQuestion(questionsArray,BankId);
			}else if(Integer.parseInt(q.getQuestion_type())==3){
				//加入问答
				String atNum = q.getAbility_type_id();
				String qtNum = q.getQuestion_type();
				String tigan = q.getContent();
				String daan = q.getAnswer();
				String nandu = q.getDifficulty();
				questionsArray.add(qtNum);
				questionsArray.add(tigan);
				questionsArray.add(daan);
				questionsArray.add(nandu);
				questionsArray.add(atNum);
				aqsi.addEssayQuestion(questionsArray,BankId);
			}else if(Integer.parseInt(q.getQuestion_type())==4) {
				//加入判断
				String atNum = q.getAbility_type_id();
				String qtNum = q.getQuestion_type();
				String tigan = q.getContent();
				String daan = q.getAnswer();
				String nandu = q.getDifficulty();
				questionsArray.add(qtNum);
				questionsArray.add(tigan);
				questionsArray.add(daan);
				questionsArray.add(nandu);
				questionsArray.add(atNum);
				aqsi.addJudgeQuestion(questionsArray,BankId);
			}else {
				//加入填空
				String atNum = q.getAbility_type_id();
				String qtNum = q.getQuestion_type();
				String tigan = q.getContent();
				String daan = q.getAnswer();
				String nandu = q.getDifficulty();
				questionsArray.add(qtNum);
				questionsArray.add(tigan);
				questionsArray.add(daan);
				questionsArray.add(nandu);
				questionsArray.add(atNum);
				aqsi.addEssayQuestion(questionsArray,BankId);
			}
		}
		result = "tttttttttttttttttttttttttt成功";
		System.out.println("我爱王一"+result);
		return result;
    }
	
	@RequestMapping("/importexcel2")
    @ResponseBody
    public String importexceltoshow(@RequestParam(value = "file", required = false) MultipartFile file,
    		String begintime,
    		String endtime, 
    		Integer cheattimes,
    		Integer teacherid,
    		Integer paperid,
    		Integer informflag,
    		HttpSession session) {        
		List<Object> list = ExcelUtil.readExcel(file, new PersonDTO(),1);//只读sheet1页		
		HashMap map = new HashMap();	
		
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date begin = null;
		Date end = null;
		try {
			begin = format1.parse(begintime);
			end = format1.parse(endtime); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		for (Object o : list) {
			System.out.println(o.toString());
			PersonDTO p = (PersonDTO) o;
			System.out.println(p.getName()+"---"+p.getEmail());
			MsgOfInvite msg = new MsgOfInvite(p.getName(),p.getEmail(),begin,end,cheattimes,teacherid,paperid);
			String invitecode = "";
			if(session.getAttribute("invitecode")==null)//如果session中没有邀请码
			{
				for(int i=0; i<6; i++) {
					invitecode += (int)(Math.random()*10);
				}
				session.setAttribute("invitecode", invitecode);
			}
			else
			{
				invitecode = session.getAttribute("invitecode").toString();
			}
			if(informflag==1)//需要发送邮件
			{
				inviteService.sendEmail(msg,invitecode);
				System.out.println("邮件发送成功！");
			}
			inviteService.addInviteMsg(msg,invitecode);
		}
		map.put("informedList", list);
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
