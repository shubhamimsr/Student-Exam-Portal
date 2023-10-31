package mypackage.model;

import java.util.List;

public class Contentmodel {
	private int content_id;
	private String content_name;
	private List<ContentQuestionModel>cquestions;

	public Contentmodel() {
		super();

	}
	public Contentmodel(int content_id, String content_name, List<ContentQuestionModel> cquestions) {
		super();
		this.content_id = content_id;
		this.content_name = content_name;
		this.cquestions = cquestions;
	}
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getContent_name() {
		return content_name;
	}
	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}
	public List<ContentQuestionModel> getCquestions() {
		return cquestions;
	}
	public void setCquestions(List<ContentQuestionModel> cquestions) {
		this.cquestions = cquestions;
	}
	
}
