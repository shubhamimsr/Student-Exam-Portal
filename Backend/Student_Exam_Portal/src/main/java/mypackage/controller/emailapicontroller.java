package mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Email;
import mypackage.service.EmailService;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class emailapicontroller {
	@Autowired
	EmailService emserivce;
	
	@PostMapping("api/sendemail")
	public String sendEmail(@RequestBody Email m) {
		  String em = emserivce.SendEmail(m);
		  return em;
	}
}
