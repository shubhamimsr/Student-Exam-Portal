package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Exam_detail;

public interface ExamDetailRepository extends JpaRepository<Exam_detail, Integer> {

}
