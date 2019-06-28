package com.neuedu.ruidaoexam.service.impl;
import static org.hamcrest.CoreMatchers.nullValue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuedu.ruidaoexam.dao.AbilityTypeMapper;
import com.neuedu.ruidaoexam.dao.AnsweredPaperMapper;
import com.neuedu.ruidaoexam.dao.AnsweredQuestionMapper;
import com.neuedu.ruidaoexam.dao.ChoiceQuestionMapper;
import com.neuedu.ruidaoexam.dao.EssayQuestionMapper;
import com.neuedu.ruidaoexam.dao.JudgeQuestionMapper;
import com.neuedu.ruidaoexam.dao.PaperMapper;
import com.neuedu.ruidaoexam.dao.QuestionTypeMapper;
import com.neuedu.ruidaoexam.dao.ReportMapper;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.entity.AbilityType;
import com.neuedu.ruidaoexam.entity.AnsweredPaper;
import com.neuedu.ruidaoexam.entity.AnsweredQuestion;
import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.ForChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ForJudgeQuestion;
import com.neuedu.ruidaoexam.entity.ForTianKongQuestion;
import com.neuedu.ruidaoexam.entity.ForWenDaQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.service.ReportService;

@Service
public class ReportServiceimpl implements ReportService{
	@Autowired
	PaperMapper paperMapper;
	@Autowired
	ReportMapper reportMapper;
	
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	AnsweredPaperMapper answeredPaperMapper;
	@Autowired
	AnsweredQuestionMapper answeredQuestionMapper;
	@Autowired
	ChoiceQuestionMapper choiceQuestionMapper;
	@Autowired
	JudgeQuestionMapper judgeQuestionMapper;
	@Autowired
	EssayQuestionMapper essayQuestionMapper;
	@Autowired
	QuestionTypeMapper questionTypeMapper;
	@Autowired
	AbilityTypeMapper abilityTypeMapper;
	@Override
	public void addComment(ArrayList<String> reportArray) {
		
		Report report = new Report();
		report.setReportId(Integer.parseInt(reportArray.get(0)));
//		report.setPaperId(Integer.parseInt(reportArray.get(1)));
//		report.setStuId(Integer.parseInt(reportArray.get(2)));
//		report.setAcquiredScore(Integer.parseInt(reportArray.get(3)));
//		report.setTotalScore(Integer.parseInt(reportArray.get(4)));
		report.setComment(reportArray.get(1));
		
//		//String类型转换为Date类型
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String sBeginTimestamp = reportArray.get(6);
//        Date dsBeginTimestamp = null;
//		try {
//			dsBeginTimestamp = simpleDateFormat.parse(sBeginTimestamp);
//		} catch (ParseException e1) {
//		}
//        String sEndTimestamp = reportArray.get(7);
//        Date dEndTimestamp = null;
//		try {
//			dEndTimestamp = simpleDateFormat.parse(sEndTimestamp);
//		} catch (ParseException e) {
//		}
//        
//		report.setBeginTimestamp(dsBeginTimestamp);
//		report.setEndTimestamp(dEndTimestamp);
//		report.setSwitchTimes(Integer.parseInt(reportArray.get(8)));
//		report.setIsAllowedToSee(Integer.parseInt(reportArray.get(9)));
		
		reportMapper.updateByPrimaryKeySelective(report);
		
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
	public ArrayList<String> getJiBenXinXi(int report_id) {
		Report report = reportMapper.selectByPrimaryKey(report_id);
		//ArrayList<String> reportInfoArrayList = new ArrayList<>();
		
		int stuId = report.getStuId();
		int ansPaperId = report.getPaperId();
		String stuIdTag = report.getStuId().toString();
		String ansPaperIdTag = report.getPaperId().toString();
//		Date beginTime = report.getBeginTimestamp();
//		Date endTime = report.getEndTimestamp();
		
		Student student = studentMapper.selectByPrimaryKey(stuId);
		AnsweredPaper answeredPaper = answeredPaperMapper.selectByPrimaryKey(ansPaperId);
		int paperId = answeredPaper.getPaperId();
		Paper paper = paperMapper.selectByPrimaryKey(paperId);
		
		ArrayList<String> studentInfoArrayList = new ArrayList<>();
		studentInfoArrayList.add(student.getName().toString());
		studentInfoArrayList.add(student.getEmail().toString());
		studentInfoArrayList.add(report.getAcquiredScore().toString());
		studentInfoArrayList.add(paper.getPaperName().toString());
		Date beginTime = report.getBeginTimestamp();
		Date endTime = report.getEndTimestamp();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		studentInfoArrayList.add(sdf.format(beginTime));
		studentInfoArrayList.add(sdf.format(endTime));
		String comment = report.getComment();
		studentInfoArrayList.add(comment);
		studentInfoArrayList.add(answeredPaper.getIsModifiedByTeacher().toString());
		studentInfoArrayList.add(ansPaperIdTag);
		studentInfoArrayList.add(stuIdTag);
		
		return studentInfoArrayList;
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
	
	@Override
	public ArrayList<String> getQuanMianGaiKuo(int report_id) {
		Report report = reportMapper.selectByPrimaryKey(report_id);
		int paperResultId = report.getPaperId();
		
		Integer keGuanTiNum = answeredQuestionMapper.countKeGuanTiNum(paperResultId); 
		Integer keGuanTiScore = answeredQuestionMapper.sumKeGuanTiScore(paperResultId);
		if (keGuanTiScore == null) {
			keGuanTiScore = 0;
		}
		Integer keGuanTiTotalScore = answeredQuestionMapper.sumKeGuanTiTotalScore(paperResultId);
		if (keGuanTiTotalScore == null) {
			keGuanTiTotalScore = 0;
		}
		
		Integer xuanZeTiNum = answeredQuestionMapper.countXuanZeTiNum(paperResultId);
		Integer xuanZeTiWrongNum = answeredQuestionMapper.countXuanZeTiWrongNum(paperResultId);
		Integer xuanZeTiScore = answeredQuestionMapper.sumXuanZeTiScore(paperResultId);
		if (xuanZeTiScore == null) {
			xuanZeTiScore = 0;
		}
		Integer panDuanTiNum = answeredQuestionMapper.countPanDuanTiNum(paperResultId);
		Integer panDuanTiWrongNum = answeredQuestionMapper.countPanDuanTiWrongNum(paperResultId);
		Integer panDuanTiScore = answeredQuestionMapper.sumPanDuanTiScore(paperResultId);
		if (panDuanTiScore == null) {
			panDuanTiScore = 0;
		}
		
		Integer zhuGuanTiNum = answeredQuestionMapper.countZhuGuanTiNum(paperResultId); 
		Integer zhuGuanTiScore = answeredQuestionMapper.sumZhuGuanTiScore(paperResultId);
		if (zhuGuanTiScore == null) {
			zhuGuanTiScore = 0;
		}
		Integer zhuGuanTiTotalScore = answeredQuestionMapper.sumZhuGuanTiTotalScore(paperResultId);
		if (zhuGuanTiTotalScore == null) {
			zhuGuanTiTotalScore = 0;
		}
		
		Integer tianKongTiNum = answeredQuestionMapper.countTianKongTiNum(paperResultId);
		Integer tianKongTiWrongNum = answeredQuestionMapper.countTianKongTiWrongNum(paperResultId);
		Integer tianKongTiScore = answeredQuestionMapper.sumTianKongTiScore(paperResultId);
		if (tianKongTiScore == null) {
			tianKongTiScore = 0;
		}
		Integer wenDaTiNum = answeredQuestionMapper.countWenDaTiNum(paperResultId);
		Integer wenDaTiWrongNum = answeredQuestionMapper.countWenDaTiWrongNum(paperResultId);
		Integer wenDaTiScore = answeredQuestionMapper.sumWenDaTiScore(paperResultId);
		if (wenDaTiScore == null) {
			wenDaTiScore = 0;
		}
		
		Integer shiTiNum = keGuanTiNum + zhuGuanTiNum;
		
		ArrayList<String> quanMianGaiKuoList = new ArrayList<>();
		quanMianGaiKuoList.add(Integer.toString(keGuanTiNum));
		quanMianGaiKuoList.add(Integer.toString(keGuanTiScore));
		quanMianGaiKuoList.add(Integer.toString(keGuanTiTotalScore));
		quanMianGaiKuoList.add(Integer.toString(xuanZeTiNum));
		quanMianGaiKuoList.add(Integer.toString(xuanZeTiWrongNum));
		quanMianGaiKuoList.add(Integer.toString(xuanZeTiScore));
		quanMianGaiKuoList.add(Integer.toString(panDuanTiNum));
		quanMianGaiKuoList.add(Integer.toString(panDuanTiWrongNum));
		quanMianGaiKuoList.add(Integer.toString(panDuanTiScore));
		quanMianGaiKuoList.add(Integer.toString(zhuGuanTiNum));
		quanMianGaiKuoList.add(Integer.toString(zhuGuanTiScore));
		quanMianGaiKuoList.add(Integer.toString(zhuGuanTiTotalScore));
		quanMianGaiKuoList.add(Integer.toString(tianKongTiNum));
		quanMianGaiKuoList.add(Integer.toString(tianKongTiWrongNum));
		quanMianGaiKuoList.add(Integer.toString(tianKongTiScore));
		quanMianGaiKuoList.add(Integer.toString(wenDaTiNum));
		quanMianGaiKuoList.add(Integer.toString(wenDaTiWrongNum));
		quanMianGaiKuoList.add(Integer.toString(wenDaTiScore));
		quanMianGaiKuoList.add(Integer.toString(shiTiNum));
		
		return quanMianGaiKuoList;
	}
	
	public ArrayList<ForChoiceQuestion> getXuanZeDaTiQingKuang(int report_id) {
		
		List<AnsweredQuestion> answeredQuestionInList = answeredQuestionMapper.getAnsweredQuestionsByPaperResultId(1);
		if (answeredQuestionInList.size()==0) {
			return null;
		}
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (AnsweredQuestion ans:answeredQuestionInList) {
			
			idList.add(ans.getCqId());
			
		}
		
		List<ChoiceQuestion> choiceQuestionsInList = choiceQuestionMapper.getChoiceQuestionsInList(idList);
		
		ArrayList<ForChoiceQuestion> forChoiceQuestionInList = new ArrayList<ForChoiceQuestion>();
		for (AnsweredQuestion ans:answeredQuestionInList) {
			
			ForChoiceQuestion forChoiceQuestion = new ForChoiceQuestion();
			
			forChoiceQuestion.setQuesTypeId(ans.getQuesType());
			String getAnswer = ans.getAnswer();
			String getRightAnswerString = ans.getRightAnswer();
			String answer = null;
			String rightAnswer = null;
			switch (getAnswer) {
			case "1 0 0 0":
				answer = "A";
				break;
			case "0 1 0 0":
				answer = "B";
				break;
			case "0 0 1 0":
				answer = "C";
				break;
			case "0 0 0 1":
				answer = "D";
				break;
			case "1 1 0 0":
				answer = "AB";
				break;
			case "1 0 1 0":
				answer = "AC";
				break;
			case "1 0 0 1":
				answer = "AD";
				break;
			case "0 1 1 0":
				answer = "BC";
				break;
			case "0 1 0 1":
				answer = "BD";
				break;
			case "0 0 1 1":
				answer = "CD";
				break;
			case "1 1 1 0":
				answer = "ABC";
				break;
			case "1 1 0 1":
				answer = "ABD";
				break;
			case "1 0 1 1":
				answer = "ACD";
				break;
			case "0 1 1 1":
				answer = "BCD";
				break;
			case "1 1 1 1":
				answer = "ABCD";
				break;
			}
			switch (getRightAnswerString) {
			case "1 0 0 0":
				rightAnswer = "A";
				break;
			case "0 1 0 0":
				rightAnswer = "B";
				break;
			case "0 0 1 0":
				rightAnswer = "C";
				break;
			case "0 0 0 1":
				rightAnswer = "D";
				break;
			case "1 1 0 0":
				rightAnswer = "AB";
				break;
			case "1 0 1 0":
				rightAnswer = "AC";
				break;
			case "1 0 0 1":
				rightAnswer = "AD";
				break;
			case "0 1 1 0":
				rightAnswer = "BC";
				break;
			case "0 1 0 1":
				rightAnswer = "BD";
				break;
			case "0 0 1 1":
				rightAnswer = "CD";
				break;
			case "1 1 1 0":
				rightAnswer = "ABC";
				break;
			case "1 1 0 1":
				rightAnswer = "ABD";
				break;
			case "1 0 1 1":
				rightAnswer = "ACD";
				break;
			case "0 1 1 1":
				rightAnswer = "BCD";
				break;
			case "1 1 1 1":
				rightAnswer = "ABCD";
				break;
			}
			forChoiceQuestion.setAnswer(answer);
			forChoiceQuestion.setRightAnswer(rightAnswer);
			forChoiceQuestion.setScore(ans.getScore());
			forChoiceQuestion.setTotalScore(ans.getTotalScore());
			forChoiceQuestion.setIscorrect(ans.getIscorrect());
			
			forChoiceQuestionInList.add(forChoiceQuestion);
		}
		
		int index  = 0;
		for (ChoiceQuestion cho:choiceQuestionsInList) {
			
			ForChoiceQuestion forChoiceQuestion = forChoiceQuestionInList.get(index);
			
			forChoiceQuestion.setChoiceQuesId(cho.getChoiceQuesId());
			forChoiceQuestion.setQuesTypeId(cho.getQuesTypeId());
			forChoiceQuestion.setContent(cho.getContent());
			forChoiceQuestion.setChoice1(cho.getChoice1());
			forChoiceQuestion.setChoice2(cho.getChoice2());
			forChoiceQuestion.setChoice3(cho.getChoice3());
			forChoiceQuestion.setChoice4(cho.getChoice4());
			forChoiceQuestion.setAnalysis(cho.getAnalysis());
			Integer abilityTypeId = cho.getAbilityTypeId();
			String abilityType = null;
			switch (abilityTypeId) {
			case 1:
				abilityType = "表达能力";
				break;
			case 2:
				abilityType = "理解能力";
				break;
			case 3:
				abilityType = "思辨能力";
				break;
			case 4:
				abilityType = "速读能力";
				break;
			case 5:
				abilityType = "记忆能力";
				break;
			case 6:
				abilityType = "交流能力";
				break;
			case 7:
				abilityType = "综合能力";
				break;
			}
			forChoiceQuestion.setAbilityType(abilityType);
			
			index++;
		}
		
//		int i = forChoiceQuestionInList.size();
//		for (int j = 0; j < i; j++) {
//			System.out.println("pppppppppppppppppppppppppppppppp" + forChoiceQuestionInList.get(j).getIscorrect());
//			System.out.println("pppppppppppppppppppppppppppppppp" + forChoiceQuestionInList.get(j).getScore());
//		}
		
		return forChoiceQuestionInList;
		
	}

	@Override
	public ArrayList<ForJudgeQuestion> getPanDuanDaTiQingKuang(int report_id) {

		List<AnsweredQuestion> answeredQuestionInList = answeredQuestionMapper.getJudgeQuestionsByPaperResultId(1);
		if (answeredQuestionInList.size()==0) {
			return null;
		}
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (AnsweredQuestion ans:answeredQuestionInList) {
			idList.add(ans.getJqId());
		}
		
		List<JudgeQuestion> judgeQuestionsInList = judgeQuestionMapper.getJudgeQuestionsInList(idList);
		
		ArrayList<ForJudgeQuestion> forJudgeQuestionInList = new ArrayList<ForJudgeQuestion>();
		for (AnsweredQuestion ans:answeredQuestionInList) {
			
			ForJudgeQuestion forJudgeQuestion = new ForJudgeQuestion();
			
			forJudgeQuestion.setQuesTypeId(ans.getQuesType());
			String getAnswer = ans.getAnswer();
			String getRightAnswerString = ans.getRightAnswer();
			String answer = null;
			String rightAnswer = null;
			switch (getAnswer) {
			case "1":
				answer = "A";
				break;
			case "0":
				answer = "B";
				break;
			}
			switch (getRightAnswerString) {
			case "1":
				rightAnswer = "A";
				break;
			case "0":
				rightAnswer = "B";
				break;
			}
			String choice1 = "正确";
			String choice2 = "错误";
			forJudgeQuestion.setAnswer(answer);
			forJudgeQuestion.setRightAnswer(rightAnswer);
			forJudgeQuestion.setChoice1(choice1);
			forJudgeQuestion.setChoice2(choice2);
			forJudgeQuestion.setScore(ans.getScore());
			forJudgeQuestion.setTotalScore(ans.getTotalScore());
			forJudgeQuestion.setIscorrect(ans.getIscorrect());
			
			forJudgeQuestionInList.add(forJudgeQuestion);
		}
		
		int index  = 0;
		for (JudgeQuestion cho:judgeQuestionsInList) {
			
			ForJudgeQuestion forJudgeQuestion = forJudgeQuestionInList.get(index);
			
			forJudgeQuestion.setJudgeQuesId(cho.getJudgeId());
			forJudgeQuestion.setQuesTypeId(cho.getQuesTypeId());
			forJudgeQuestion.setContent(cho.getContent());
			Integer abilityTypeId = cho.getAbilityTypeId();
			String abilityType = null;
			switch (abilityTypeId) {
			case 1:
				abilityType = "表达能力";
				break;
			case 2:
				abilityType = "理解能力";
				break;
			case 3:
				abilityType = "思辨能力";
				break;
			case 4:
				abilityType = "速读能力";
				break;
			case 5:
				abilityType = "记忆能力";
				break;
			case 6:
				abilityType = "交流能力";
				break;
			case 7:
				abilityType = "综合能力";
				break;
			}
			forJudgeQuestion.setAbilityType(abilityType);
			
			index++;
		}
		
//		int i = forJudgeQuestionInList.size();
//		for (int j = 0; j < i; j++) {
//			System.out.println("pppppppppppppppppppppppppppppppp" + forJudgeQuestionInList.get(j).getAnswer());
//			System.out.println("pppppppppppppppppppppppppppppppp" + forJudgeQuestionInList.get(j).getRightAnswer());
//			System.out.println("pppppppppppppppppppppppppppppppp" + forJudgeQuestionInList.get(j).getChoice1());
//			System.out.println("pppppppppppppppppppppppppppppppp" + forJudgeQuestionInList.get(j).getChoice2());
//		}
		
		return forJudgeQuestionInList;
		
	}

	@Override
	public ArrayList<ForTianKongQuestion> getTianKongDaTiQingKuang(int report_id) {
		List<AnsweredQuestion> answeredQuestionInList = answeredQuestionMapper.getTianKongQuestionsByPaperResultId(1);
		if (answeredQuestionInList.size()==0) {
			return null;
		}
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (AnsweredQuestion ans:answeredQuestionInList) {
			idList.add(ans.getEqId());
		}
		
		List<EssayQuestion> tianKongQuestionsInList = essayQuestionMapper.getTianKongQuestionsInList(idList);
		
		ArrayList<ForTianKongQuestion> forTianKongQuestionInList = new ArrayList<ForTianKongQuestion>();
		for (AnsweredQuestion ans:answeredQuestionInList) {
			
			ForTianKongQuestion forTianKongQuestion = new ForTianKongQuestion();
			
			forTianKongQuestion.setQuesTypeId(ans.getQuesType());
			forTianKongQuestion.setAnswer(ans.getAnswer());
			forTianKongQuestion.setRightAnswer(ans.getRightAnswer());
			forTianKongQuestion.setScore(ans.getScore());
			forTianKongQuestion.setTotalScore(ans.getTotalScore());
			forTianKongQuestion.setIscorrect(ans.getIscorrect());
			
			forTianKongQuestionInList.add(forTianKongQuestion);
		}
		
		int index  = 0;
		for (EssayQuestion cho:tianKongQuestionsInList) {
			
			ForTianKongQuestion forTianKongQuestion = forTianKongQuestionInList.get(index);
			
			forTianKongQuestion.setTianKongQuesId(cho.getQuesAnsId());
			forTianKongQuestion.setQuesTypeId(cho.getQuesTypeId());
			forTianKongQuestion.setContent(cho.getContent());
			Integer abilityTypeId = cho.getAbilityTypeId();
			String abilityType = null;
			switch (abilityTypeId) {
			case 1:
				abilityType = "表达能力";
				break;
			case 2:
				abilityType = "理解能力";
				break;
			case 3:
				abilityType = "思辨能力";
				break;
			case 4:
				abilityType = "速读能力";
				break;
			case 5:
				abilityType = "记忆能力";
				break;
			case 6:
				abilityType = "交流能力";
				break;
			case 7:
				abilityType = "综合能力";
				break;
			}
			forTianKongQuestion.setAbilityType(abilityType);
			
			index++;
		}
		
//		int i = forTianKongQuestionInList.size();
//		for (int j = 0; j < i; j++) {
//			System.out.println("pppppppppppppppppppppppppppppppp" + forTianKongQuestionInList.get(j).getAnswer());
//			System.out.println("pppppppppppppppppppppppppppppppp" + forTianKongQuestionInList.get(j).getRightAnswer());
//		}
		
		return forTianKongQuestionInList;
	}

	@Override
	public ArrayList<ForWenDaQuestion> getWenDaDaTiQingKuang(int report_id) {
		List<AnsweredQuestion> answeredQuestionInList = answeredQuestionMapper.getWenDaQuestionsByPaperResultId(1);
		if (answeredQuestionInList.size()==0) {
			return null;
		}
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (AnsweredQuestion ans:answeredQuestionInList) {
			idList.add(ans.getEqId());
		}
		
		List<EssayQuestion> wenDaQuestionsInList = essayQuestionMapper.getWenDaQuestionsInList(idList);
		
		ArrayList<ForWenDaQuestion> forWenDaQuestionInList = new ArrayList<ForWenDaQuestion>();
		for (AnsweredQuestion ans:answeredQuestionInList) {
			
			ForWenDaQuestion forWenDaQuestion = new ForWenDaQuestion();
			
			forWenDaQuestion.setQuesTypeId(ans.getQuesType());
			forWenDaQuestion.setAnswer(ans.getAnswer());
			forWenDaQuestion.setRightAnswer(ans.getRightAnswer());
			forWenDaQuestion.setScore(ans.getScore());
			forWenDaQuestion.setTotalScore(ans.getTotalScore());
			forWenDaQuestion.setIscorrect(ans.getIscorrect());
			
			forWenDaQuestionInList.add(forWenDaQuestion);
		}
		
		int index  = 0;
		for (EssayQuestion cho:wenDaQuestionsInList) {
			
			ForWenDaQuestion forWenDaQuestion = forWenDaQuestionInList.get(index);
			
			forWenDaQuestion.setWenDaQuesId(cho.getQuesAnsId());
			forWenDaQuestion.setQuesTypeId(cho.getQuesTypeId());
			forWenDaQuestion.setContent(cho.getContent());
			Integer abilityTypeId = cho.getAbilityTypeId();
			String abilityType = null;
			switch (abilityTypeId) {
			case 1:
				abilityType = "表达能力";
				break;
			case 2:
				abilityType = "理解能力";
				break;
			case 3:
				abilityType = "思辨能力";
				break;
			case 4:
				abilityType = "速读能力";
				break;
			case 5:
				abilityType = "记忆能力";
				break;
			case 6:
				abilityType = "交流能力";
				break;
			case 7:
				abilityType = "综合能力";
				break;
			}
			forWenDaQuestion.setAbilityType(abilityType);
			
			index++;
		}
		
//		int i = forTianKongQuestionInList.size();
//		for (int j = 0; j < i; j++) {
//			System.out.println("pppppppppppppppppppppppppppppppp" + forTianKongQuestionInList.get(j).getAnswer());
//			System.out.println("pppppppppppppppppppppppppppppppp" + forTianKongQuestionInList.get(j).getRightAnswer());
//		}
		
		return forWenDaQuestionInList;
	}

	@Override
	public HashMap<String, Object> getReportsByPaperId(Integer paper_id) {
		List<AnsweredPaper> answeredPapers = answeredPaperMapper.getAnsweredPaperByPaper_id(paper_id);
		List<Integer> ans_paper_list = new ArrayList<Integer>();
		List<Integer> student_idList = new ArrayList<Integer>();
		List<Report> reports = new ArrayList<Report>();
		List<Student> students = new ArrayList<Student>();
//		List<ReportandAnswered> reportandAnswereds = new ArrayList<ReportandAnswered>();
		for (AnsweredPaper answeredPaper : answeredPapers) {
//			System.out.println(answeredPaper.getAnsPaperId());
			if (answeredPaper.getAnsPaperId() != null) {
				ans_paper_list.add(answeredPaper.getAnsPaperId());
//				System.out.println(answeredPaper.getAnsPaperId());
			}
			if (answeredPaper.getStuId() != null) {
				student_idList.add(answeredPaper.getStuId());
//				System.out.println(answeredPaper.getStuId());
			}
		}
		if (!ans_paper_list.isEmpty()) {
			reports = reportMapper.getReportsInList(ans_paper_list);
		}
		if (!student_idList.isEmpty()) {
			students = studentMapper.getStudentsinList(student_idList);
		}
//		for (Student student:students) {
//			System.out.println(student.getName());
//		}
//		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
//		for (Report report:reports) {
//			System.out.println(report.getAcquiredScore());
//		}
//		for (Student student:students) {
//			System.out.println(student.getName());
//		}
//		for (AnsweredPaper answeredPaper:answeredPapers) {
//			ReportandAnswered reportandAnswered = new ReportandAnswered();
//			System.out.println(answeredPaper.getAnsPaperId());
//			System.out.println(answeredPaper.getStuId());
////			System.out.println(answeredPaper.getAnsPaperId());
//			System.out.println(answeredPaper.getIsModifiedByTeacher());
//			System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWW");
//			reportandAnswered.setAnsweredpaper_id(answeredPaper.getAnsPaperId());
//			reportandAnswered.setPaper_id(paper_id);
//			reportandAnswered.setStudent_id(answeredPaper.getStuId());
//			reportandAnswered.setModify(answeredPaper.getIsModifiedByTeacher());
//			reportandAnswereds.add(reportandAnswered);
//		}
//		for (Report report:reports) {
//			System.out.println(report.getAcquiredScore());
//			int i = 0;
//			ReportandAnswered reportandAnswered = reportandAnswereds.get(i);
//			reportandAnswereds.get(i).setReport_id(report.getReportId());
//			reportandAnswereds.get(i).setEndtime(report.getEndTimestamp());
//			reportandAnswereds.get(i).setAcquiredScore(report.getAcquiredScore());
//			reportandAnswereds.get(i).setTotalScore(report.getTotalScore());
//			System.out.println(reportandAnswereds.get(i).getAcquiredScore());
//			i++;
//		}
//		for (Student student:students) {
//			int j = 0;
//			reportandAnswereds.get(j).setStudentname(student.getName());
//			System.out.println(student.getName());
//			System.out.println(reportandAnswereds.get(j).getStudentname());
//			System.out.println(reportandAnswereds.get(j).getAcquiredScore());
//			j++;
//		}
//		for (Report report : reports) {
//			System.out.println(report.getPaperId());
//		}
		
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("answeredpapers", answeredPapers);
		hashMap.put("reports", reports);
		hashMap.put("students", students);
		return hashMap;
	}
	
	@Override
	public void modified(ArrayList<String> modifiedArray) {
		
		AnsweredPaper answeredPaper = new AnsweredPaper();
		answeredPaper.setAnsPaperId(Integer.parseInt(modifiedArray.get(0)));
		answeredPaper.setIsModifiedByTeacher(modifiedArray.get(1));
		
		answeredPaperMapper.updateByPrimaryKeySelective(answeredPaper);
		
	}

//	@Override
//	public ArrayList<ForChoiceQuestion> getXuanZeDaTiQingKuang(int report_id) {
//		Report report = reportMapper.selectByPrimaryKey(report_id);
//		int paperResultId = report.getPaperId();
//		
//		AnsweredQuestion answeredQuestion = answeredQuestionMapper.selectByPaperResultId(paperResultId);
//		int cpId = answeredQuestion.getCqId();
//		
//		
//		ChoiceQuestion choiceQuestion = choiceQuestionMapper.selectByPrimaryKey(cpId);
//		int abilityTypeId = choiceQuestion.getAbilityTypeId();
//		
////		QuestionType questionType = questionTypeMapper.selectByPrimaryKey(quesTypeId);
//		AbilityType abilityType = abilityTypeMapper.selectByPrimaryKey(abilityTypeId);
//		
//		ArrayList<ForChoiceQuestion> forChoiceQuesntionList = new ArrayList<>();
//		int i = forChoiceQuesntionList.size();
//		ForChoiceQuestion forChoiceQuestion = new ForChoiceQuestion();
//		for (int j = 0; j < i; j++) {
//			forChoiceQuestion.setChoiceQuesId(choiceQuestion.getChoiceQuesId());
//			forChoiceQuestion.setQuesTypeId(choiceQuestion.getQuesTypeId());
//			forChoiceQuestion.setContent(choiceQuestion.getContent());
//			forChoiceQuestion.setChoice1(choiceQuestion.getChoice1());
//			forChoiceQuestion.setChoice2(choiceQuestion.getChoice2());
//			forChoiceQuestion.setChoice3(choiceQuestion.getChoice3());
//			forChoiceQuestion.setChoice4(choiceQuestion.getChoice4());
//			forChoiceQuestion.setAnswer(answeredQuestion.getAnswer());
//			forChoiceQuestion.setRightAnswer(answeredQuestion.getRightAnswer());
//			forChoiceQuestion.setAnalysis(choiceQuestion.getAnalysis());
//			forChoiceQuestion.setScore(answeredQuestion.getScore());
//			forChoiceQuestion.setTotalScore(answeredQuestion.getTotalScore());
//			forChoiceQuestion.setAbilityType(abilityType.getAbilityType());
//			forChoiceQuestion.setIscorrect(answeredQuestion.getIscorrect());
//		}
//		
//		return forChoiceQuesntionList;
//	}

}
