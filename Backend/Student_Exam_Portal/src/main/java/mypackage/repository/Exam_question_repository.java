package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Exam_question;

public interface Exam_question_repository extends JpaRepository<Exam_question, Integer> {

}
