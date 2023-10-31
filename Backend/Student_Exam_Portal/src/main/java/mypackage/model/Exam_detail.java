package mypackage.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tblstudent_exams")
public class Exam_detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exam_id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name="student_id")
	private Student student;
	
	private String exam_date;
	private String start_time;
	private String end_time;
	
	@OneToMany(mappedBy = "examdetails" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("examdetails")
	private List<Exam_question>examquestions;

	public Exam_detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam_detail(int exam_id, Student student, String exam_date, String start_time, String end_time,
			List<Exam_question> examquestions) {
		super();
		this.exam_id = exam_id;
		this.student = student;
		this.exam_date = exam_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.examquestions = examquestions;
	}

	public int getExam_id() {
		return exam_id;
	}

	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public List<Exam_question> getExamquestions() {
		return examquestions;
	}

	public void setExamquestions(List<Exam_question> examquestions) {
		this.examquestions = examquestions;
	}

	
}
