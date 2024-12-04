package br.com.alura.screenmatch.spring.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private Integer intTemporada;
    private String sTitulo;
    private Integer intNumeroEpisodio;
    private double dbAvaliacao;
    private LocalDate sDataDeLancamento;

    public Episodio(Integer intNumeroTemporada, DadosEpisodio clDadosEpisodio) {
        this.intTemporada = intNumeroTemporada;
        this.sTitulo = clDadosEpisodio.sTitulo();
        this.intNumeroEpisodio = clDadosEpisodio.iNumeroEpisodio();
        try{
            this.dbAvaliacao = Double.valueOf(clDadosEpisodio.sAvaliacao());
        } catch (NumberFormatException e) {
            this.dbAvaliacao = 0.0;
        }

        try{
            this.sDataDeLancamento = LocalDate.parse(clDadosEpisodio.sDataDeLancamento());
        } catch (DateTimeParseException e) {
            this.sDataDeLancamento = null;
        }
    }
        //Verificar a diferença entre parseDouble e valeuOf

    //Gets
    public Integer getIntTemporada() {
        return intTemporada;
    }

    public String getsTitulo() {
        return sTitulo;
    }

    public Integer getintNumeroEpisodio() {
        return intNumeroEpisodio;
    }

    public double getDbAvaliacao() {
        return dbAvaliacao;
    }

    public LocalDate getsDataDeLancamento() {
        return sDataDeLancamento;
    }

    //Sets
    public void setIntTemporada(Integer intTemporada) {
        this.intTemporada = intTemporada;
    }

    public void setsTitulo(String sTitulo) {
        this.sTitulo = sTitulo;
    }

    public void setintNumeroEpisodio(Integer intNumeroEpisodio) {
        this.intNumeroEpisodio = intNumeroEpisodio;
    }

    public void setDbAvaliacao(double dbAvaliacao) {
        this.dbAvaliacao = dbAvaliacao;
    }

    public void setsDataDeLancamento(LocalDate sDataDeLancamento) {
        this.sDataDeLancamento = sDataDeLancamento;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "intTemporada=" + intTemporada +
                ", sTitulo='" + sTitulo + '\'' +
                ", intNumeroEpisodio=" + intNumeroEpisodio +
                ", dbAvaliacao=" + dbAvaliacao +
                ", sDataDeLancamento=" + sDataDeLancamento +
                '}';
    }
}
