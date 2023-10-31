package mypackage.model;

public class Email {
	   	private String email_address;
	   	private String subject;
	   	private String message_body;
		public Email() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Email(String email_address, String subject, String message_body) {
			super();
			this.email_address = email_address;
			this.subject = subject;
			this.message_body = message_body;
		}
		public String getEmail_address() {
			return email_address;
		}
		public void setEmail_address(String email_address) {
			this.email_address = email_address;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getMessage_body() {
			return message_body;
		}
		public void setMessage_body(String message_body) {
			this.message_body = message_body;
		}
}
