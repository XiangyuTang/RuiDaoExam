package com.neuedu.ruidaoexam.entity;

public class JudgeQuestion {
    private Integer judgeId;

    private Integer quesTypeId;

    private String content;

    private Integer answer;

    private Integer difficulty;

    private Integer abilityTypeId;

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
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
        this.content = content == null ? null : content.trim();
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getAbilityTypeId() {
        return abilityTypeId;
    }

    public void setAbilityTypeId(Integer abilityTypeId) {
        this.abilityTypeId = abilityTypeId;
    }
}