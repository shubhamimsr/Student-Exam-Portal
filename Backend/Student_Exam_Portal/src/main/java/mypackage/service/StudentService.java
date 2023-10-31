package mypackage.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.*;
import mypackage.repository.*;

@Service
public class StudentService {
	@Autowired
	StudentRepository studrepo;
	
	@Autowired
	AdminRepository adminrepo;
	
	@Autowired
	TopicRepository topicrepo;
	
	@Autowired
	ContentRepository crepo;
	
	@Autowired
	Content_question_repository cqrepo;
	
	@Autowired
	Exam_question_repository eqrepo;
	
	@Autowired
	ExamDetailRepository erepo;
	
	
	public List<Admin>GetAdmins(){
		return adminrepo.findAll();
	}
	
	public Student AddorUpdateStudent(Student st) {
		return studrepo.save(st);	
	}

	public List<Student>GetStudents() {	
		List<Student> lst = new ArrayList<Student>();
		for(Student s:studrepo.findAll()) {
			Student st =  new Student(s.getStudent_id(), s.getStudent_name(),s.getStudent_code(),s.getEmail_address(),s.getMobile_number(),s.getGender(),s.getLocal_address(),s.getPassword(),null);
			lst.add(st);
		}
		return lst;
		
	}
	
	public Student GetStudentbyid(int id) {
		Student s = studrepo.findById(id).get();
		List<Exam_detail>lst = new ArrayList<Exam_detail>() ;
			for(Exam_detail ed : erepo.findAll()) {
				if(s.getStudent_id()== ed.getStudent().getStudent_id()) {
					Exam_detail eds = new Exam_detail(ed.getExam_id(),null,ed.getExam_date(),ed.getStart_time(),ed.getEnd_time(),null);
					lst.add(eds);
				}
			}	
		Student st =  new Student(s.getStudent_id(), s.getStudent_name(),s.getStudent_code(),s.getEmail_address(),s.getMobile_number(),s.getGender(),s.getLocal_address(),s.getPassword(),lst);
		return st;
	}

	//student with exam details
	public StudentFinalModel GetStudentDetailsbyid(int id) {
		Student s = studrepo.findById(id).get();
		
		List<ExamDetailModel>edm = new ArrayList<ExamDetailModel>();
		for(Exam_detail ed : erepo.findAll() ) {
			int total=0,notattempted=0,correct=0,wrong=0;
			if(s.getStudent_id()==ed.getStudent().getStudent_id()) {
				
				List<Exam_question>eqm = new ArrayList<Exam_question>();
				
				for(Exam_question eq:eqrepo.findAll()) {
					if (eq.getExamdetails().getExam_id() == ed.getExam_id()){
						Content_question cq = new Content_question(eq.getContentquestion().getQuestion_id(), null,eq.getContentquestion().getQuestion(), eq.getContentquestion().getOption1(),eq.getContentquestion().getOption2(), eq.getContentquestion().getOption3(),eq.getContentquestion().getOption4(), eq.getContentquestion().getCorrect_option_number(), null);
						Exam_question eqq = new Exam_question(eq.getExam_question_id(),null,cq,eq.getSubmitted_answer_option());
						eqm.add(eqq);
						
						
						 
						 if(eqq.getSubmitted_answer_option()==eq.getContentquestion().getCorrect_option_number()) {
							 correct++;
							
						 }
						 else if (eqq.getSubmitted_answer_option() == -1) 
						 {
							 notattempted++; 
							 wrong++;
		                 }
						 else {
							 wrong++;
						 }
						total++;
						
					}
					
					
				}
				

				
				ExamDetailModel edms= new ExamDetailModel(ed.getExam_id(),ed.getStudent().getStudent_id(),ed.getExam_date(),ed.getStart_time(),ed.getEnd_time(),total,notattempted,correct,wrong,eqm);
				edm.add(edms);
			}
			

		}
	

		StudentFinalModel st = new StudentFinalModel(s.getStudent_id(),s.getStudent_name(),s.getStudent_code(),s.getLocal_address(),edm);
		return st;
	}
	
	
	public Student DeleteStudent(int id) {
		Student st =GetStudentbyid(id);
		studrepo.delete(st);
		return st;
	}
	

	//Topic Model
	
	public Topic AddorUpdateTopic(Topic tp) {
		return topicrepo.save(tp);
	}
	
	public List<Topic>GetTopic(){
		List<Topic>lst =  new ArrayList<Topic>();
		for(Topic t : topicrepo.findAll()) {
			Topic tp = new Topic(t.getTopic_id(), t.getTopic_name(), null);
			lst.add(tp);
		}
		return lst;
	}
	
	public Topic GetTopicByid(int id) {
		Topic tp= topicrepo.findById(id).get();
		List<Content>lst = new ArrayList<Content>();
		for(Content c : crepo.findAll()) {
			if(tp.getTopic_id()==c.getTopic().getTopic_id()) {
				Content cn = new Content(c.getContent_id(),c.getContent_name(), null, null);
				lst.add(cn);
			}
		}
		Topic t = new Topic(tp.getTopic_id(),tp.getTopic_name(),lst);
		return t;
	}
	
	public Topic DeleteTopic(int id) {
	Topic tp = GetTopicByid(id);
	topicrepo.delete(tp);
	return tp; 
		
	}
	
	
	
	//Content Model
	public List<Content>GetContent(){
		List<Content> lst = new ArrayList<Content>();
		for(Content cn:crepo.findAll()) {
			Topic tc= new Topic(cn.getTopic().getTopic_id(),cn.getTopic().getTopic_name(), null);
			Content c = new Content(cn.getContent_id(), cn.getContent_name(),tc, null);
			lst.add(c);
		}
		return lst;
	}
	
	public Content GetcontentByid(int id) {
		Content cp= crepo.findById(id).get();
		List<Content_question>cqs = new ArrayList<Content_question>();
		
		for (Content_question cq :cqrepo.findAll()) {
			if(cq.getContent().getContent_id() == cp.getContent_id()) {
				Content_question cqm = new Content_question(cq.getQuestion_id(),cq.getContent(), cq.getQuestion(), cq.getOption1(), cq.getOption2(),cq.getOption3(),cq.getOption4(),cq.getCorrect_option_number(), null);
				cqs.add(cqm);
			}	
		}
		Content c = new Content(cp.getContent_id(),cp.getContent_name(),null, cqs);
		return c;
		}
	
	
	


	//Content Question Model
	public List<Content_question>GetContentQuestion(){
		List<Content_question> lst = new ArrayList<Content_question>();		
		for(Content_question cq : cqrepo.findAll())
		{		
			Content_question rr= new  Content_question(cq.getQuestion_id(),null, cq.getQuestion(), cq.getOption1(), cq.getOption2(),cq.getOption3(),cq.getOption4(),cq.getCorrect_option_number(), null);
			lst.add(rr);
		}
		return lst;
	}
	
	
	//Exam Question Model

	
	
	
	public Exam_detail AddExamQuestions(Exam_detail eq) {
		Exam_detail ed = new Exam_detail(0,eq.getStudent(),eq.getExam_date(),eq.getStart_time(),eq.getEnd_time(),null);
		Exam_detail eds = erepo.save(ed);
		
		for(Exam_question eqs :eq.getExamquestions() ) {
			Exam_question eqss = new Exam_question(eqs.getExam_question_id(), eds, eqs.getContentquestion(),eqs.getSubmitted_answer_option());
			eqrepo.save(eqss);
		}
		return eds;
		}
	

	public Exam_detail GetExamQuestions(int id) {
		Exam_detail e =  erepo.findById(id).get() ;

		List<Exam_question>eqq = new ArrayList<Exam_question>();
		for(Exam_question  eq: eqrepo.findAll()) {
			
			if(e.getExam_id()==eq.getExamdetails().getExam_id()) {
				Content_question cq = new Content_question(eq.getContentquestion().getQuestion_id(), null,eq.getContentquestion().getQuestion(), eq.getContentquestion().getOption1(),eq.getContentquestion().getOption2(), eq.getContentquestion().getOption3(),eq.getContentquestion().getOption4(), eq.getContentquestion().getCorrect_option_number(), null);
				Exam_question eqs = new Exam_question(eq.getExam_question_id(),null,cq,eq.getSubmitted_answer_option());
				eqq.add(eqs);
			}
		}
		
		Exam_detail ed = new Exam_detail(e.getExam_id(), null, e.getExam_date(),e.getStart_time(),e.getEnd_time(),eqq);
		return ed;
	}
	
	
	public ExamDetailModel GetExam(int id) {
		Exam_detail e =  erepo.findById(id).get() ;
		int total=0,notattempted=0,correct=0,wrong=0;
		List<Exam_question>eqq = new ArrayList<Exam_question>();
		for(Exam_question  eq: eqrepo.findAll()) {
			
			if(e.getExam_id()==eq.getExamdetails().getExam_id()) {
				Content c = new Content(eq.getContentquestion().getContent().getContent_id(),eq.getContentquestion().getContent().getContent_name(), null, null);
				Content_question cq = new Content_question(eq.getContentquestion().getQuestion_id(),c,eq.getContentquestion().getQuestion(), eq.getContentquestion().getOption1(),eq.getContentquestion().getOption2(), eq.getContentquestion().getOption3(),eq.getContentquestion().getOption4(), eq.getContentquestion().getCorrect_option_number(), null);
				Exam_question eqs = new Exam_question(eq.getExam_question_id(),null,cq,eq.getSubmitted_answer_option());
				eqq.add(eqs);
				
				 if (eqs.getSubmitted_answer_option() == eq.getContentquestion().getCorrect_option_number()) {
		             correct++;
		         } 
				 else if (eqs.getSubmitted_answer_option() == -1) {
		             wrong++;
		         } 
				 else {
		              wrong++;
		         }
		        total++;
		           
			}
		}
		 ExamDetailModel ed = new ExamDetailModel(e.getExam_id(),e.getStudent().getStudent_id(),e.getExam_date(),e.getStart_time(),e.getEnd_time(),total,notattempted, correct, wrong, eqq);
		 return ed;
	}
	
}



