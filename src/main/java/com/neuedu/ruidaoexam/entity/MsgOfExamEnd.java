package com.neuedu.ruidaoexam.entity;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MsgOfExamEnd {
	private Integer paper_id;
	private Integer stu_id;
	private Integer totalScores;
	private String comment;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Berlin")
	private String beginTimeStamp;
	private Integer switch_time;
	
	@Override
	public String toString() {
		return "MsgOfExamEnd [paperId=" + paper_id + ", stu_id=" + stu_id + ", totalScores=" + totalScores + ", comment="
				+ comment + ", beginTimeStamp=" + beginTimeStamp + ", switch_time=" + switch_time + "]";
	}
	
	public Integer getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(Integer paper_id) {
		this.paper_id = paper_id;
	}

	public Integer getStu_id() {
		return stu_id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public Integer getTotalScores() {
		return totalScores;
	}
	public void setTotalScores(Integer totalScores) {
		this.totalScores = totalScores;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getBeginTimeStamp() {
		return beginTimeStamp;
	}
	public void setBeginTimeStamp(String beginTimeStamp) {
		this.beginTimeStamp = beginTimeStamp;
	}
	public Integer getSwitch_time() {
		return switch_time;
	}
	public void setSwitch_time(Integer switch_time) {
		this.switch_time = switch_time;
	}
	
}
