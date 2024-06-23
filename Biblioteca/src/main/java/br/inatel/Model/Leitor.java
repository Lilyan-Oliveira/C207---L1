package br.inatel.Model;

public class Leitor {

    private int matriculaleitores;
    private String nomeleitores;
    private String telefoneleitores;
    private String emailleitores;

    public Leitor(int matriculaleitores, String nomeleitores, String telefoneleitores, String emailleitores) {
        this.matriculaleitores = matriculaleitores;
        this.nomeleitores = nomeleitores;
        this.telefoneleitores = telefoneleitores;
        this.emailleitores = emailleitores;
    }

    public int getMatriculaleitores() {
        return matriculaleitores;
    }

    public String getNomeleitores() {
        return nomeleitores;
    }

    public String getTelefoneleitores() {
        return telefoneleitores;
    }

    public String getEmailleitores() {
        return emailleitores;
    }
}

