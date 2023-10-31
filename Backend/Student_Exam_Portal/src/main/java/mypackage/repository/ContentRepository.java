package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Content;

public interface ContentRepository extends JpaRepository<Content,Integer> {

}
