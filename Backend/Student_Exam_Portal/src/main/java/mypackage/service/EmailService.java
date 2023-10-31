package mypackage.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.*;
import mypackage.model.*;
import mypackage.repository.EmailRepository;
import mypackage.repository.StudentRepository;

@Service
public class EmailService implements EmailRepository {

	@Autowired 
	StudentRepository srepo;
	
	@Autowired
	private JavaMailSender mailsender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#";
	private static final int passwordLength = 8;
	
	public String SendEmail(Email em) {
			String password = generatePassword();
			OtpModel om = null;
			SimpleMailMessage s=new SimpleMailMessage();
			s.setFrom(sender);
			s.setTo(em.getEmail_address());
			s.setSubject("Account creation Confirmation");
			s.setText("Your account has been created successfully with Infiniti Tech \n\n You can access your account by using following credentials  \n\n  Email:  " + em.getEmail_address() + "  Password is  = " + password);
			mailsender.send(s);
			om =new OtpModel(password);
			return password;
	}

	private String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i <= passwordLength; i++) {
        	int randomIndex = random.nextInt(CHARACTERS.length());
        	char randomChar = CHARACTERS.charAt(randomIndex);
        	 password.append(randomChar);
        }

        return password.toString();
    }
	


	
	
}
