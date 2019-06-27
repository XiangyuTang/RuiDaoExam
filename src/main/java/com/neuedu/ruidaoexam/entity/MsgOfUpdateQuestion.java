package com.neuedu.ruidaoexam.entity;

public class MsgOfUpdateQuestion {
	private Integer paperResultId;
	private Integer questype;
	private Integer quesid;
	private Integer score;
	private Integer totalScore;
	private String answer;
	private String rightanswer;
	private Integer iscorrect;
	public Integer getPaperResultId() {
		return paperResultId;
	}
	public void setPaperResultId(Integer paperResultId) {
		this.paperResultId = paperResultId;
	}
	public Integer getQuestype() {
		return questype;
	}
	public void setQuestype(Integer questype) {
		this.questype = questype;
	}
	public Integer getQuesid() {
		return quesid;
	}
	public void setQuesid(Integer quesid) {
		this.quesid = quesid;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRightanswer() {
		return rightanswer;
	}
	public void setRightanswer(String rightanswer) {
		this.rightanswer = rightanswer;
	}
	public Integer getIscorrect() {
		return iscorrect;
	}
	public void setIscorrect(Integer iscorrect) {
		this.iscorrect = iscorrect;
	}
}
