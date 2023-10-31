package mypackage.model;

import java.util.List;

public class StudentFinalModel {
	private int student_id;
	private String student_name;
	private String student_code;
	private String local_address;
	private List<ExamDetailModel>examdetails;
	
	public StudentFinalModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentFinalModel(int student_id, String student_name, String student_code, String local_address,
			List<ExamDetailModel> examdetails) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_code = student_code;
		this.local_address = local_address;
		this.examdetails = examdetails;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_code() {
		return student_code;
	}
	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}
	public String getLocal_address() {
		return local_address;
	}
	public void setLocal_address(String local_address) {
		this.local_address = local_address;
	}
	public List<ExamDetailModel> getExamdetails() {
		return examdetails;
	}
	public void setExamdetails(List<ExamDetailModel> examdetails) {
		this.examdetails = examdetails;
	}
	
	
}
