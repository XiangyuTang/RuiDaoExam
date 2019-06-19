package com.neuedu.ruidaoexam.entity;

public class ChoiceQuestion {
    private Integer choiceQuesId;

    private Integer quesTypeId;

    private String content;

    private String choice1;

    private String choice2;

    private String choice3;

    private String choice4;

    private String answer;

    private Integer difficulty;

    private String analysis;

    private Integer abilityTypeId;

    public Integer getChoiceQuesId() {
        return choiceQuesId;
    }

    public void setChoiceQuesId(Integer choiceQuesId) {
        this.choiceQuesId = choiceQuesId;
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

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1 == null ? null : choice1.trim();
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2 == null ? null : choice2.trim();
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3 == null ? null : choice3.trim();
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4 == null ? null : choice4.trim();
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

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    public Integer getAbilityTypeId() {
        return abilityTypeId;
    }

    public void setAbilityTypeId(Integer abilityTypeId) {
        this.abilityTypeId = abilityTypeId;
    }
}