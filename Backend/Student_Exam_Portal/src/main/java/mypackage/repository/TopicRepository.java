package mypackage.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.*;

public interface TopicRepository extends JpaRepository<Topic, Integer>  {

}
