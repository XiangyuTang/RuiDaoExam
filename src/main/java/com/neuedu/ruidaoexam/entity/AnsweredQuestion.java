package com.neuedu.ruidaoexam.entity;

public class AnsweredQuestion {
    private Integer answerId;

    private Integer paperResultId;

    private Integer quesType;

    private Integer cqId;

    private Integer eqId;

    private Integer jqId;

    private String answer;

    private String rightAnswer;

    private Integer score;

    private Integer totalScore;

    private Integer iscorrect;

    public AnsweredQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnsweredQuestion(Integer answerId, Integer paperResultId, Integer quesType, Integer cqId, Integer eqId,
			Integer jqId, String answer, String rightAnswer, Integer score, Integer totalScore, Integer iscorrect) {
		super();
		this.answerId = answerId;
		this.paperResultId = paperResultId;
		this.quesType = quesType;
		this.cqId = cqId;
		this.eqId = eqId;
		this.jqId = jqId;
		this.answer = answer;
		this.rightAnswer = rightAnswer;
		this.score = score;
		this.totalScore = totalScore;
		this.iscorrect = iscorrect;
	}

	public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getPaperResultId() {
        return paperResultId;
    }

    public void setPaperResultId(Integer paperResultId) {
        this.paperResultId = paperResultId;
    }

    public Integer getQuesType() {
        return quesType;
    }

    public void setQuesType(Integer quesType) {
        this.quesType = quesType;
    }

    public Integer getCqId() {
        return cqId;
    }

    public void setCqId(Integer cqId) {
        this.cqId = cqId;
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public Integer getJqId() {
        return jqId;
    }

    public void setJqId(Integer jqId) {
        this.jqId = jqId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer == null ? null : rightAnswer.trim();
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
}