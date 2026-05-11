package org.yash.springbootemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.yash.springbootemail.service.EmailService;

@SpringBootApplication
public class SpringbootEmailApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container=SpringApplication.run(SpringbootEmailApplication.class, args);
		
		EmailService emailservice=container.getBean(EmailService.class);
		emailservice.SendHtmlemail();
		
	}

}
