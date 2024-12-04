package br.com.alura.screenmatch.spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(  @JsonAlias("Title") String sTitulo
                            , @JsonAlias("Episode") int iNumeroEpisodio
                            , @JsonAlias("imdbRating") String sAvaliacao
                            , @JsonAlias("Released") String sDataDeLancamento) {

}
