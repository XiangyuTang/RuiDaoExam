package com.neuedu.ruidaoexam.entity;

import java.util.Date;

public class Report {
    private Integer reportId;

    private Integer paperId;

    private Integer stuId;

    private Integer acquiredScore;

    private Integer totalScore;

    private String comment;

    private Date beginTimestamp;

    private Date endTimestamp;

    private Integer switchTimes;

    private Integer isAllowedToSee;

    public Report(Integer reportId, Integer paperId, Integer stuId, Integer acquiredScore, Integer totalScore,
			String comment, Date beginTimestamp, Date endTimestamp, Integer switchTimes, Integer isAllowedToSee) {
		super();
		this.reportId = reportId;
		this.paperId = paperId;
		this.stuId = stuId;
		this.acquiredScore = acquiredScore;
		this.totalScore = totalScore;
		this.comment = comment;
		this.beginTimestamp = beginTimestamp;
		this.endTimestamp = endTimestamp;
		this.switchTimes = switchTimes;
		this.isAllowedToSee = isAllowedToSee;
	}

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getAcquiredScore() {
        return acquiredScore;
    }

    public void setAcquiredScore(Integer acquiredScore) {
        this.acquiredScore = acquiredScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getBeginTimestamp() {
        return beginTimestamp;
    }

    public void setBeginTimestamp(Date beginTimestamp) {
        this.beginTimestamp = beginTimestamp;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public Integer getSwitchTimes() {
        return switchTimes;
    }

    public void setSwitchTimes(Integer switchTimes) {
        this.switchTimes = switchTimes;
    }

    public Integer getIsAllowedToSee() {
        return isAllowedToSee;
    }

    public void setIsAllowedToSee(Integer isAllowedToSee) {
        this.isAllowedToSee = isAllowedToSee;
    }
}