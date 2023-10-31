package mypackage.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbltopics")
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topic_id;
	private String topic_name;
	
	@OneToMany(mappedBy ="topic" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("topic")
	private List<Content>contents;

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(int topic_id, String topic_name, List<Content> contents) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.contents = contents;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

	
}
