package br.inatel.Model;

public class LivrosHasAutores {
    private int tombo;
    private String nomeAutor;

    public LivrosHasAutores(int tombo, String nomeAutor) {
        this.tombo = tombo;
        this.nomeAutor = nomeAutor;
    }

    public int getTombo() {
        return tombo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
