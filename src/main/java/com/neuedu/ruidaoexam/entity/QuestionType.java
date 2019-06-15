package com.neuedu.ruidaoexam.entity;

public class QuestionType {
    private Integer quesTypeId;

    private String quesType;

    public Integer getQuesTypeId() {
        return quesTypeId;
    }

    public void setQuesTypeId(Integer quesTypeId) {
        this.quesTypeId = quesTypeId;
    }

    public String getQuesType() {
        return quesType;
    }

    public void setQuesType(String quesType) {
        this.quesType = quesType == null ? null : quesType.trim();
    }
}