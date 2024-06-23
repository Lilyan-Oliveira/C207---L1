package br.inatel.Model;

public class LivrosHasGeneros {
    private int tombo;
    private String editora;
    private String nomeGenero;

    public LivrosHasGeneros(int tombo, String editora, String nomeGenero) {
        this.tombo = tombo;
        this.editora = editora;
        this.nomeGenero = nomeGenero;
    }

    public int getTombo() {
        return tombo;
    }

    public String getEditora() {
        return editora;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }
}

