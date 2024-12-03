package br.com.alura.screenmatch.spring.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
