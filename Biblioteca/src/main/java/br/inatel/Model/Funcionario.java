package br.inatel.Model;

public class Funcionario {

    private int matriculafuncionario;
    private String nomefuncionario;
    private String enderecofuncionario;
    private String telefonefuncionario;
    private String emailfuncionario;

    public Funcionario(int matriculafuncionario, String nomefuncionario, String enderecofuncionario, String telefonefuncionario, String emailfuncionario) {
        this.matriculafuncionario = matriculafuncionario;
        this.nomefuncionario = nomefuncionario;
        this.enderecofuncionario = enderecofuncionario;
        this.telefonefuncionario = telefonefuncionario;
        this.emailfuncionario = emailfuncionario;
    }

    public int getMatriculafuncionario() {
        return matriculafuncionario;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public String getEnderecofuncionario() {
        return enderecofuncionario;
    }

    public String getTelefonefuncionario() {
        return telefonefuncionario;
    }

    public String getEmailfuncionario() {
        return emailfuncionario;
    }
}
