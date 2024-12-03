package br.com.alura.screenmatch.spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie( @JsonAlias("Title") String sTitulo
                        , @JsonAlias("totalSeasons") int iTotalTemporadas
                        , @JsonAlias("imdbRating") String sAvaliacao) {
}
