package br.com.api.residencia.terapiy.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.api.residencia.terapiy.domains.Profissional;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Configuration
@Service
public class EmailService {
	@Autowired
	JavaMailSender emailSender;
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();
		
		emailSender.setHost("smtp.gmail.com");
		emailSender.setPort(587);
		emailSender.setUsername("");
		emailSender.setPassword("");
		
		prop.put("mail.smtp.auth", false);
		prop.put("mail.smtp.starttls.enable", true);
		
		emailSender.setJavaMailProperties(prop);
		
		return emailSender;
	}
	public void envioEmailCadastro(String email, Profissional p){
		this.emailSender = javaMailSender();
		MimeMessage messageProfissional = emailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(messageProfissional,true);
			helper.setFrom("james.hector.maclean@gmail.com");
			helper.setTo(p.getEmail());
			helper.setSubject(email);
			
			StringBuilder builder = new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			<h1>Cadastro concluido</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			Status: "+ p.isPrecoSocial());
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");
			
			helper.setText(builder.toString(),true);
			emailSender.send(messageProfissional);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
