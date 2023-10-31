package mypackage.model;

import java.util.List;

public class TopicModel {
	private int topic_id;
	private String topic_name;
	private List<Contentmodel>contents;
	public TopicModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TopicModel(int topic_id, String topic_name, List<Contentmodel> contents) {
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
	public List<Contentmodel> getContents() {
		return contents;
	}
	public void setContents(List<Contentmodel> contents) {
		this.contents = contents;
	}
	
	
	
	
}
