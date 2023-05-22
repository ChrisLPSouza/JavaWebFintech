package br.com.fintech.model;

import java.io.Serializable;
import java.sql.Date;


public class Investimento implements Serializable {

    private int cdInvestimento;
    private float vlInvestimento;
    private Date dtInicial;
    private Date dtResgate;
    private String nmUserName;


    public Investimento () {

    }

    public int getCdInvestimento() {
        return cdInvestimento;
    }

    public void setCdInvestimento(int cdInvestimento) {
        this.cdInvestimento = cdInvestimento;
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

    public String getNmUserName() {
        return nmUserName;
    }

    public void setNmUserName(String nmUserName) {
        this.nmUserName = nmUserName;
    }


    @Override
    public String toString() {
        return "Investimento{" +
                "cdInvestimento=" + cdInvestimento +
                ", vlInvestimento=" + vlInvestimento +
                ", dtInicial=" + dtInicial +
                ", dtResgate=" + dtResgate +
                ", nmUserName='" + nmUserName + '\'' +
                '}';
    }
}
