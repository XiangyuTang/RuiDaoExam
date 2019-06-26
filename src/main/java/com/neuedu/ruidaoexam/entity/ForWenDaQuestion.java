package com.neuedu.ruidaoexam.entity;

public class ForWenDaQuestion {
	private Integer wenDaQuesId;

    private Integer quesTypeId;

    private String content;

    private String abilityType;
    
	private String answer;

    private String rightAnswer;
    
    private Integer score;
    
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

	private Integer totalScore;

    private Integer iscorrect;
    
    public ForWenDaQuestion(){
		
	}
    
	public Integer getWenDaQuesId() {
		return wenDaQuesId;
	}

	public void setWenDaQuesId(Integer wenDaQuesId) {
		this.wenDaQuesId = wenDaQuesId;
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
    

}
