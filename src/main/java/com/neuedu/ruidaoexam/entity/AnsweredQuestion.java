package com.neuedu.ruidaoexam.entity;

public class AnsweredQuestion {
    private Integer answerId;

    private Integer paperResultId;

    private Integer quesType;

    private Integer cqId;

    private Integer eqId;

    private Integer jqId;

    private Integer answer;

    private Integer rightAnswer;

    private Integer score;

    private Integer totalScore;

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

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Integer rightAnswer) {
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
}