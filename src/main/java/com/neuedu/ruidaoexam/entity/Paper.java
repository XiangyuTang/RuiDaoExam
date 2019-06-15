package com.neuedu.ruidaoexam.entity;

public class Paper {
    private Integer paperId;

    private String paperName;

    private Integer paperType;

    private Integer createdbyteacherid;

    private Integer paperTime;

    private Integer totalScore;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    public Integer getCreatedbyteacherid() {
        return createdbyteacherid;
    }

    public void setCreatedbyteacherid(Integer createdbyteacherid) {
        this.createdbyteacherid = createdbyteacherid;
    }

    public Integer getPaperTime() {
        return paperTime;
    }

    public void setPaperTime(Integer paperTime) {
        this.paperTime = paperTime;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}