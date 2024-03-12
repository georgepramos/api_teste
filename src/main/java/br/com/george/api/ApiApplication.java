package br.com.george.api;

import br.com.george.api.domain.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiApplication.class, args);

		Usuario usuario = new Usuario(1,"George Ramos","georgepramos@gmail.com","");
	}

}
