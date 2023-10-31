package mypackage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import mypackage.model.*;
import mypackage.service.*;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class StudentApiController {
	@Autowired
	StudentService sservice;
	
	@GetMapping("api/getadmin")
	public List<Admin>GetAdminDetail(){
		return sservice.GetAdmins();
	}
	
	@PostMapping("api/student")
	public Student AddStudent(@RequestBody Student st) {
		return sservice.AddorUpdateStudent(st);
	}
	
	@PutMapping("api/student")
	public Student UpdateStudent(@RequestBody Student st) {
		return sservice.AddorUpdateStudent(st);
	}
	
	@GetMapping("api/student")
	public List<Student>GetStudent() {
		return sservice.GetStudents();
	}
	
	@GetMapping("api/student/{student_id}")
	public Student GetStudentById(@PathVariable("student_id") int id) {
		return sservice.GetStudentbyid(id);
	} 
	
	@GetMapping("api/studentdetail/{student_id}")
	public StudentFinalModel GetStudentDetailsbyids(@PathVariable("student_id") int id) {
		return sservice.GetStudentDetailsbyid(id);
	}
	
	@DeleteMapping("api/student/{student_id}")
	public Student DeleteStudentByID (@PathVariable("student_id")int id) {
		return sservice.DeleteStudent(id);
	}
	 
	
	//Topic MOdel
	@GetMapping("api/topic")
	public List<Topic> GetTopics(){
		return sservice.GetTopic();
	}
	
	@PostMapping("api/topic")
	public Topic AddTopic(@RequestBody Topic tp) {
		return sservice.AddorUpdateTopic(tp);
	}
	
	@PutMapping("api/topic")
	public Topic UpdateTopic(@RequestBody Topic tp) {
		return sservice.AddorUpdateTopic(tp);
	}
	
	
	
	
	@GetMapping("api/topic/{topic_id}")
	public Topic GetTopicByid(@PathVariable("topic_id")int id) {
		return  sservice.GetTopicByid(id);
	}
	
	@DeleteMapping("api/topic/{topic_id}")
	public Topic DeleteTopicByid(@PathVariable("topic_id")int id) {
		return  sservice.DeleteTopic(id);
	}
	
	
	@GetMapping("api/content")
	public List<Content>GetContents(){
		return sservice.GetContent();
	}
	
	@GetMapping("api/content/{content_id}")
	public Content GetcontentquestionByid(@PathVariable("content_id")int id) {
		return sservice.GetcontentByid(id);
	}

	
	@GetMapping("api/contentquestions")
	public List<Content_question>GetContentQuestions(){
		return sservice.GetContentQuestion();
}

	
	@PostMapping("api/examquestions")
	public Exam_detail AddExamQuestions(@RequestBody Exam_detail eq) {
		return sservice.AddExamQuestions(eq);
	}
	
	@GetMapping("api/examquestions/{exam_id}")
	public Exam_detail getExamQuestions(@PathVariable("exam_id")int id) {
		return sservice.GetExamQuestions(id);
	}
	
	@GetMapping("api/exam/{exam_id}")
	public ExamDetailModel getExambyid(@PathVariable("exam_id")int id) {
		return sservice.GetExam(id);
	}
	
}
