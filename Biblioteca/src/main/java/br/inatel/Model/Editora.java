package br.inatel.Model;

public class Editora {
    private String nomeEditora;
    private String enderecoEditora;
    private String telefoneEditora;

    public Editora(String nomeEditora, String enderecoEditora, String telefoneEditora) {
        this.nomeEditora = nomeEditora;
        this.enderecoEditora = enderecoEditora;
        this.telefoneEditora = telefoneEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public String getEnderecoEditora() {
        return enderecoEditora;
    }

    public String getTelefoneEditora() {
        return telefoneEditora;
    }
}

