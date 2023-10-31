package mypackage.model;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tblstudent_details")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int student_id;
	private String student_name;
	private String student_code;
	@Column(unique = true, nullable = false)
	private String email_address;
	private String mobile_number;
	private String gender;
	private String local_address;
	private String password; 
	
	@OneToMany(mappedBy="student" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("student")
	private List<Exam_detail>examdetails;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int student_id, String student_name, String student_code, String email_address, String mobile_number,
			String gender, String local_address, String password, List<Exam_detail> examdetails) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_code = student_code;
		this.email_address = email_address;
		this.mobile_number = mobile_number;
		this.gender = gender;
		this.local_address = local_address;
		this.password = password;
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

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocal_address() {
		return local_address;
	}

	public void setLocal_address(String local_address) {
		this.local_address = local_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Exam_detail> getExamdetails() {
		return examdetails;
	}

	public void setExamdetails(List<Exam_detail> examdetails) {
		this.examdetails = examdetails;
	}

	
}
