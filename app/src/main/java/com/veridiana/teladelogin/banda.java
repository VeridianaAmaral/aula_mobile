package com.veridiana.teladelogin;

public class banda {
    String nome;
    String estilo;

    public banda(String nome, String estilo) {
        this.nome = nome;
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Banda: " + nome + ". Estilo: " + estilo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}