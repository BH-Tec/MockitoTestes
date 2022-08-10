package com.brunodorea.testesmockito.MockitoTestes;

import java.time.LocalDate;

public class Pessoa {

    private String nome;

    private String documento;

    private LocalDate nascimento;

    private DadosLocalizacao endereco;

    public Pessoa(final String nome, final String documento, final LocalDate nascimento) {
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
    }

    public void adicionaDadosDeEndereco(DadosLocalizacao endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public DadosLocalizacao getEndereco() {
        return endereco;
    }
    
}
