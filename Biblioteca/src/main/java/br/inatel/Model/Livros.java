package br.inatel.Model;

public class Livros {
    private int tombo;
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private String genero;

    public Livros(int tombo, String titulo, String autor, String editora, String isbn, String genero) {
        this.tombo = tombo;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.genero = genero;
    }

    public int getTombo() {
        return tombo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenero() {
        return genero;
    }
}
