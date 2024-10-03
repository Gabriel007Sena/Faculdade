package org.libertas;

public class Time {
    private int idtime;
    private String nome;
    private String fundacao;
    private String estadio;
    private String treinador;

    // Getters e Setters
    public int getIdtime() {
        return idtime;
    }

    public void setIdtime(int idtime) {
        this.idtime = idtime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFundacao() {
        return fundacao;
    }

    public void setFundacao(String fundacao) {
        this.fundacao = fundacao;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }
}
