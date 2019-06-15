package com.neuedu.ruidaoexam.entity;

public class Ques_Paper_Mapper {
    private Integer mapperId;

    private Integer paperId;

    private Integer quesType;

    private Integer cqId;

    private Integer eqId;

    private Integer jqId;

    private String score;

    public Integer getMapperId() {
        return mapperId;
    }

    public void setMapperId(Integer mapperId) {
        this.mapperId = mapperId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }
}