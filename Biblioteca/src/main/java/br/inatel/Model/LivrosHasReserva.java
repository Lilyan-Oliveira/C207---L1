package br.inatel.Model;

public class LivrosHasReserva {
    private int tombo;
    private String editora;
    private int idReserva;

    public LivrosHasReserva(int tombo, String editora, int idReserva) {
        this.tombo = tombo;
        this.editora = editora;
        this.idReserva = idReserva;
    }

    public int getTombo() {
        return tombo;
    }

    public String getEditora() {
        return editora;
    }

    public int getIdReserva() {
        return idReserva;
    }
}

