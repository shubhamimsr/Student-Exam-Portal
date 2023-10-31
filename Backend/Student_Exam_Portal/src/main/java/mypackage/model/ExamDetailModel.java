package mypackage.model;

import java.util.List;

public class ExamDetailModel {
	private int exam_id;
	private int student_id;
	private String exam_date;
	private String start_time;
	private String end_time;
	private int total;
	private int notattempted;
	private int correct;
	private int wrong;
	private List<Exam_question> examquestions;
	
	public ExamDetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamDetailModel(int exam_id, int student_id, String exam_date, String start_time, String end_time, int total,
			int notattempted, int correct, int wrong, List<Exam_question> examquestions) {
		super();
		this.exam_id = exam_id;
		this.student_id = student_id;
		this.exam_date = exam_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.total = total;
		this.notattempted = notattempted;
		this.correct = correct;
		this.wrong = wrong;
		this.examquestions = examquestions;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNotattempted() {
		return notattempted;
	}
	public void setNotattempted(int notattempted) {
		this.notattempted = notattempted;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public int getWrong() {
		return wrong;
	}
	public void setWrong(int wrong) {
		this.wrong = wrong;
	}
	public List<Exam_question> getExamquestions() {
		return examquestions;
	}
	public void setExamquestions(List<Exam_question> examquestions) {
		this.examquestions = examquestions;
	}
	
}
