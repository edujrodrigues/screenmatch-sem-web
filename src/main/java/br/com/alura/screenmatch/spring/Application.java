package br.com.alura.screenmatch.spring;

import br.com.alura.screenmatch.spring.model.DadosSerie;
import br.com.alura.screenmatch.spring.service.ConsumoAPI;
import br.com.alura.screenmatch.spring.service.ConverteDados;
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
		var clConsumoAPI = new ConsumoAPI();
		var json = clConsumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=39603e78");
		System.out.println(json);
//		json = clConsumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
		ConverteDados clConversor = new ConverteDados();
		DadosSerie clDados = clConversor.obterDados(json, DadosSerie.class);
		System.out.println(clDados);
	}
}
