package br.inatel.Model;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private int tomboReserva;
    private String funcionario;
    private int leitoresMatriculaLeitores;
    private LocalDate dataReserva;

    public Reserva(int idReserva, int tomboReserva, String funcionario, int leitoresMatriculaLeitores, LocalDate dataReserva) {
        this.idReserva = idReserva;
        this.tomboReserva = tomboReserva;
        this.funcionario = funcionario;
        this.leitoresMatriculaLeitores = leitoresMatriculaLeitores;
        this.dataReserva = dataReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getTomboReserva() {
        return tomboReserva;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public int getLeitoresMatricula() {
        return leitoresMatriculaLeitores;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }
}

