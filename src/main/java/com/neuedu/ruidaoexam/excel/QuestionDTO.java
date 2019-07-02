package com.neuedu.ruidaoexam.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;



public class QuestionDTO extends BaseRowModel {
	
	@ExcelProperty(index=0, value="题目类型")
	private String question_type;
	
	@ExcelProperty(index=1, value="题干")
	private String content;
	
	@ExcelProperty(index=2, value="选项一")
	private String choice1;
	
	@ExcelProperty(index=3, value="选项二")
	private String choice2;
	
	@ExcelProperty(index=4, value="选项三")
	private String choice3;
	
	@ExcelProperty(index=5, value="选项四")
	private String choice4;
	
	@ExcelProperty(index=6, value="答案")
	private String answer;
	
	@ExcelProperty(index=7, value="难度")
	private String difficulty;
	
	@ExcelProperty(index=8, value="解析")
	private String analysis;
	
	@ExcelProperty(index=9, value="能力类型")
	private String ability_type_id;

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getAbility_type_id() {
		return ability_type_id;
	}

	public void setAbility_type_id(String ability_type_id) {
		this.ability_type_id = ability_type_id;
	}
	
	public QuestionDTO() {
		super();
	}
	

	
}
