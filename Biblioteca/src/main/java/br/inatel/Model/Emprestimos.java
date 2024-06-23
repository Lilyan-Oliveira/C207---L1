package br.inatel.Model;

import java.time.LocalDate;

public class Emprestimos {
    private int idEmprestimos;
    private int tomboEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataRetorno;
    private int leitor;
    private int funcionario;

    public Emprestimos(int idEmprestimos, int tomboEmprestimo, LocalDate dataEmprestimo, LocalDate dataRetorno, int leitor, int funcionario) {
        this.idEmprestimos = idEmprestimos;
        this.tomboEmprestimo = tomboEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetorno = dataRetorno;
        this.leitor = leitor;
        this.funcionario = funcionario;
    }

    public int getIdEmprestimos() {
        return idEmprestimos;
    }

    public int getTomboEmprestimo() {
        return tomboEmprestimo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataRetorno() {
        return dataRetorno;
    }

    public int getLeitor() {
        return leitor;
    }

    public int getFuncionario() {
        return funcionario;
    }
}

