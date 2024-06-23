package br.inatel.Model;

public class Autores {

    private String nomeautor;
    private String nacionalidade;

    public Autores(String nomeautor, String nacionalidade) {
        this.nomeautor = nomeautor;
        this.nacionalidade = nacionalidade;
    }

    public String getNomeautor() {
        return nomeautor;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}
