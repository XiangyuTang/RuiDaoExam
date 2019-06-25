package com.neuedu.ruidaoexam.entity;

import java.util.List;

public class StudentDataVO {

	private int numberOfAnswered;
	private int numberOfNotAnswered;
	private List<NotAnsweredDataVO> notAnsweredPapers;
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
	public List<NotAnsweredDataVO> getNotAnsweredPapers() {
		return notAnsweredPapers;
	}
	public void setNotAnsweredPapers(List<NotAnsweredDataVO> notAnsweredPapers) {
		this.notAnsweredPapers = notAnsweredPapers;
	}
	
	
}
