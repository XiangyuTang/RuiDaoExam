package com.neuedu.ruidaoexam.entity;

import java.util.Date;

public class ReportandAnswered {
	private Integer report_id;
	private Integer answeredpaper_id;
	private Integer paper_id;
	private String studentname;
	private Date endtime;
	private Integer acquiredScore;
	private Integer totalScore;
	private Integer modify;
	public ReportandAnswered() {
		
	}
	public Integer getReport_id() {
		return report_id;
	}
	public void setReport_id(Integer report_id) {
		this.report_id = report_id;
	}
	public Integer getAnsweredpaper_id() {
		return answeredpaper_id;
	}
	public void setAnsweredpaper_id(Integer answeredpaper_id) {
		this.answeredpaper_id = answeredpaper_id;
	}
	public Integer getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(Integer paper_id) {
		this.paper_id = paper_id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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
	public Integer getModify() {
		return modify;
	}
	public void setModify(Integer modify) {
		this.modify = modify;
	}
}
