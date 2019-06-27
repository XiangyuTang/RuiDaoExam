package com.neuedu.ruidaoexam.entity;

public class ForChoiceQuestion {
	 	private Integer choiceQuesId;

	    private Integer quesTypeId;

	    private String content;

	    private String choice1;

	    private String choice2;

	    private String choice3;

	    private String choice4;

	    private String analysis;

	    private String abilityType;

		private String answer;

	    private String rightAnswer;

	    private Integer score;

	    private Integer totalScore;

	    private Integer iscorrect;
	    
	    public ForChoiceQuestion(){
			
		}

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
			this.content = content;
		}

		public String getChoice1() {
			return choice1;
		}

		public void setChoice1(String choice1) {
			this.choice1 = choice1;
		}

		public String getChoice2() {
			return choice2;
		}

		public void setChoice2(String choice2) {
			this.choice2 = choice2;
		}

		public String getChoice3() {
			return choice3;
		}

		public void setChoice3(String choice3) {
			this.choice3 = choice3;
		}

		public String getChoice4() {
			return choice4;
		}

		public void setChoice4(String choice4) {
			this.choice4 = choice4;
		}

		public String getAnalysis() {
			return analysis;
		}

		public void setAnalysis(String analysis) {
			this.analysis = analysis;
		}

		public String getAbilityType() {
			return abilityType;
		}

		public void setAbilityType(String abilityType) {
			this.abilityType = abilityType;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public String getRightAnswer() {
			return rightAnswer;
		}

		public void setRightAnswer(String rightAnswer) {
			this.rightAnswer = rightAnswer;
		}

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;
		}

		public Integer getTotalScore() {
			return totalScore;
		}

		public void setTotalScore(Integer totalScore) {
			this.totalScore = totalScore;
		}

		public Integer getIscorrect() {
			return iscorrect;
		}

		public void setIscorrect(Integer iscorrect) {
			this.iscorrect = iscorrect;
		}

}
