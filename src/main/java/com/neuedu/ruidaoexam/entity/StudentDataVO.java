package com.neuedu.ruidaoexam.entity;

import java.util.List;

public class StudentDataVO {

	private int numberOfAnswered;
	private int numberOfNotAnswered;
	private List<Paper> notAnsweredPapers;
	public int getNumberOfAnswered() {
		return numberOfAnswered;
	}
	public void setNumberOfAnswered(int numberOfAnswered) {
		this.numberOfAnswered = numberOfAnswered;
	}
	public int getNumberOfNotAnswered() {
		return numberOfNotAnswered;
	}
	public void setNumberOfNotAnswered(int numberOfNotAnswered) {
		this.numberOfNotAnswered = numberOfNotAnswered;
	}
	public List<Paper> getNotAnsweredPapers() {
		return notAnsweredPapers;
	}
	public void setNotAnsweredPapers(List<Paper> notAnsweredPapers) {
		this.notAnsweredPapers = notAnsweredPapers;
	}
	
	
}
