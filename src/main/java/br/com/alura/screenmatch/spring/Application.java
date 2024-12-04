package br.com.alura.screenmatch.spring;

import br.com.alura.screenmatch.spring.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//O Run passa a ser o metodo Main.
	@Override
	public void run(String... args) throws Exception {
		Principal clPrincipal = new Principal();
		clPrincipal.exibiMenu();
	}
}
