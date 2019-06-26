package com.neuedu.ruidaoexam.entity;

public class ForJudgeQuestion {
	private Integer judgeQuesId;

    private Integer quesTypeId;

    private String content;

    private String abilityType;
    
    private String choice1;

    private String choice2;
    
	private String answer;

    private String rightAnswer;

    private Integer score;
    
	private Integer totalScore;

    private Integer iscorrect;
    
    public ForJudgeQuestion(){
		
	}
    
    public Integer getJudgeQuesId() {
		return judgeQuesId;
	}

	public void setJudgeQuesId(Integer judgeQuesId) {
		this.judgeQuesId = judgeQuesId;
	}

	public Integer getQuesTypeId() {
		return quesTypeId;
	}

	public void setQuesTypeId(Integer quesTypeId) {
		this.quesTypeId = quesTypeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAbilityType() {
		return abilityType;
	}

	public void setAbilityType(String abilityType) {
		this.abilityType = abilityType;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getIscorrect() {
		return iscorrect;
	}

	public void setIscorrect(Integer iscorrect) {
		this.iscorrect = iscorrect;
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

}
