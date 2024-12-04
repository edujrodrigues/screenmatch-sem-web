package br.com.alura.screenmatch.spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada( @JsonAlias("Season") int iNumero
                            , @JsonAlias("Episodes") List<DadosEpisodio> liEpisodio) {
}
