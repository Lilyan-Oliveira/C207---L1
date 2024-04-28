package br.inatel.Model;

public class Funcionario {

    private int matriculaFuncionario;
    private String nomeFuncionario;
    private String enderecoFuncionario;
    private String telefoneFuncionario;
    private String emailFuncionario;

    public Funcionario(int matriculaFuncionario, String nomeFuncionario, String enderecoFuncionario, String telefoneFuncionario, String emailFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.emailFuncionario = emailFuncionario;
    }

    public int getMatriculaFuncionario() {

        return matriculaFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }
}
