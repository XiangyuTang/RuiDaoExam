package com.neuedu.ruidaoexam.entity;

import java.util.Date;

public class GradeListVO {

	private String paper_name;
	private String score;
	private int paper_id;
	private String date;
	public String getPaper_name() {
		return paper_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setPaper_name(String paper_name) {
		this.paper_name = paper_name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score+"分";
	}
	public int getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}
	
}
