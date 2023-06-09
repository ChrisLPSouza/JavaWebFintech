package br.com.fintech.model;

import java.io.Serializable;
import java.sql.Date;


public class Investimento {

    private int cdInvestimento;
    private String nome;
    private float vlInvestimento;
    private Date dtInicial;
    private Date dtResgate;
    private String email;


    public Investimento () {

    }

    public int getCdInvestimento() {
        return cdInvestimento;
    }

    public void setCdInvestimento(int cdInvestimento) {
        this.cdInvestimento = cdInvestimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getVlInvestimento() {
        return vlInvestimento;
    }

    public void setVlInvestimento(float vlInvestimento) {
        this.vlInvestimento = vlInvestimento;
    }

    public Date getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(Date dtInicial) {
        this.dtInicial = dtInicial;
    }

    public Date getDtResgate() {
        return dtResgate;
    }

    public void setDtResgate(Date dtResgate) {
        this.dtResgate = dtResgate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Investimento{" +
                "cdInvestimento=" + cdInvestimento +
                ", nome='" + nome + '\'' +
                ", vlInvestimento=" + vlInvestimento +
                ", dtInicial=" + dtInicial +
                ", dtResgate=" + dtResgate +
                ", email='" + email + '\'' +
                '}';
    }
}
