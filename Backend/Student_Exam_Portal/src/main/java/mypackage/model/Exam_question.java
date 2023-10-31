package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblexam_questions")
public class Exam_question {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int exam_question_id;
	
	@ManyToOne(fetch = FetchType.LAZY ,optional=false)
	@JoinColumn(name="Exam_id")
	private Exam_detail examdetails;

	
	@ManyToOne(fetch = FetchType.LAZY ,optional=false)
	@JoinColumn(name="question_id")
	private Content_question contentquestion;
	
	private int submitted_answer_option;

	public Exam_question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam_question(int exam_question_id, Exam_detail examdetails, Content_question contentquestion,
			int submitted_answer_option) {
		super();
		this.exam_question_id = exam_question_id;
		this.examdetails = examdetails;
		this.contentquestion = contentquestion;
		this.submitted_answer_option = submitted_answer_option;
	}

	public int getExam_question_id() {
		return exam_question_id;
	}

	public void setExam_question_id(int exam_question_id) {
		this.exam_question_id = exam_question_id;
	}

	public Exam_detail getExamdetails() {
		return examdetails;
	}

	public void setExamdetails(Exam_detail examdetails) {
		this.examdetails = examdetails;
	}

	public Content_question getContentquestion() {
		return contentquestion;
	}

	public void setContentquestion(Content_question contentquestion) {
		this.contentquestion = contentquestion;
	}

	public int getSubmitted_answer_option() {
		return submitted_answer_option;
	}

	public void setSubmitted_answer_option(int submitted_answer_option) {
		this.submitted_answer_option = submitted_answer_option;
	}

	
}
