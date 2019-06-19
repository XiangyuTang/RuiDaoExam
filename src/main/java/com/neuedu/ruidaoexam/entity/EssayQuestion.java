package com.neuedu.ruidaoexam.entity;

public class EssayQuestion {
    private Integer quesAnsId;

    private Integer quesTypeId;

    private String content;

    private String answer;

    private Integer difficulty;

    private Integer abilityTypeId;

    public Integer getQuesAnsId() {
        return quesAnsId;
    }

    public void setQuesAnsId(Integer quesAnsId) {
        this.quesAnsId = quesAnsId;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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