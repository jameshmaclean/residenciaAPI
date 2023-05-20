package br.com.residencia.api.springclothes;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	@Value("${terapiy.swagger.dev-url}")
	private String devUrl;
	@Bean
	public OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL - Ambiente Desenvolvimento");
		
		Contact contact = new Contact();
		contact.setName("James Maclean");
		contact.setEmail("james.hector.maclean@gmail.com");
		contact.setUrl("https://github.com/jameshmaclean/residenciaAPI");
		
		License license = new License()
				.name("Apache license version 2.0")
				.url("https://www.apache.org/license/LICENSE-2.0");
		
		Info info = new Info()
				.title("Documentação API - Spring Clothes")
				.version("1.0.0")
				.contact(contact)
				.license(license)
				.termsOfService("https://www.springclothes.com/terms");
		
		
		return new OpenAPI().info(info).servers(List.of(devServer));
				
				
				
		
		
	}
}
