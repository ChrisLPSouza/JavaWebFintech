package br.com.webfintechfinal.model;

import java.io.Serializable;

public class Conta implements Serializable {

    private int idConta;
    private int agencia;
    private int nrConta;
    private int nrBanco;
    private String nmUsername;

    public Conta () {

    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNrConta() {
        return nrConta;
    }

    public void setNrConta(int nrConta) {
        this.nrConta = nrConta;
    }

    public int getNrBanco() {
        return nrBanco;
    }

    public void setNrBanco(int nrBanco) {
        this.nrBanco = nrBanco;
    }

    public String getNmUsername() {
        return nmUsername;
    }

    public void setNmUsername(String nmUsername) {
        this.nmUsername = nmUsername;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "idConta=" + idConta +
                ", agencia=" + agencia +
                ", nrConta=" + nrConta +
                ", nrBanco=" + nrBanco +
                ", nmUsername='" + nmUsername + '\'' +
                '}';
    }
}
