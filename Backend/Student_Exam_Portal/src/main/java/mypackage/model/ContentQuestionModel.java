package mypackage.model;

import java.util.List;

public class ContentQuestionModel {
	private int question_id;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
    private int correct_option_number;
	public ContentQuestionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContentQuestionModel(int question_id, String question, String option1, String option2, String option3,
			String option4, int correct_option_number) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correct_option_number = correct_option_number;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public int getCorrect_option_number() {
		return correct_option_number;
	}
	public void setCorrect_option_number(int correct_option_number) {
		this.correct_option_number = correct_option_number;
	}
    
}
