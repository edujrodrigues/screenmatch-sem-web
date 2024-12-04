package br.com.alura.screenmatch.spring.principal;

import br.com.alura.screenmatch.spring.model.DadosEpisodio;
import br.com.alura.screenmatch.spring.model.DadosSerie;
import br.com.alura.screenmatch.spring.model.DadosTemporada;
import br.com.alura.screenmatch.spring.model.Episodio;
import br.com.alura.screenmatch.spring.service.ConsumoAPI;
import br.com.alura.screenmatch.spring.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=39603e78";
    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoAPI clConsumoAPI = new ConsumoAPI();
    private ConverteDados clConversor = new ConverteDados();

    public void exibiMenu(){
        var sEnderecoFinal = "";
        List<DadosTemporada> liTemporadas = new ArrayList<>();

        System.out.println("Digite o nome da série para a pesquisa:");
        String sNomeSerie = leitura.nextLine();
        if (sNomeSerie.equalsIgnoreCase("")){
            sNomeSerie = "euphoria";
        }
        sEnderecoFinal = ENDERECO + sNomeSerie.replace(" ", "+") + API_KEY;
        var json = clConsumoAPI.obterDados(sEnderecoFinal);
        DadosSerie clDados = clConversor.obterDados(json, DadosSerie.class);
        System.out.println(clDados);

        for (int i = 1; i <= clDados.iTotalTemporadas(); i++){
            json = clConsumoAPI.obterDados(ENDERECO + sNomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada clDadosTemporada = clConversor.obterDados(json, DadosTemporada.class);
            liTemporadas.add(clDadosTemporada);
        }
        //System.out.println(liTemporadas);
        liTemporadas.forEach(System.out::println);

        //For For normal
//        for(int i = 0; i < clDados.iTotalTemporadas(); i++){
//            List<DadosEpisodio> clEpisodiosTemporada = liTemporadas.get(i).liEpisodio();
//            for(int j = 0; j< clEpisodiosTemporada.size(); j++){
//                System.out.println(clEpisodiosTemporada.get(j).sTitulo());
//            }
//        }
        //For for melhorado
        liTemporadas.forEach(t -> t.liEpisodio().forEach(e -> System.out.println(e.sTitulo())));

        List<DadosEpisodio> liDadosEpisodio = liTemporadas.stream()
                .flatMap(t -> t.liEpisodio().stream())
                .collect(Collectors.toList());
        //Com collect(Collectors.toList()) = podemos alterar a lista depois.
        //Só o .toList() = a lista é imutável.

        System.out.println("************************************");
        liDadosEpisodio.stream()
                .filter(e -> !e.sAvaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::sAvaliacao).reversed())
                .limit(5)
        .forEach(System.out::println);

        List<Episodio> liEpisodio = liTemporadas.stream()
                .flatMap(t -> t.liEpisodio().stream()
                        .map(d -> new Episodio(t.iNumero(), d)))
                .collect(Collectors.toList());

        liEpisodio.forEach(System.out::println);
    }
}
