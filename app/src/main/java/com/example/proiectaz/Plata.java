package com.example.proiectaz;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;


enum TipPersoana {FIZICA, JURIDICA};

public class Plata implements Serializable {




    private String uid;
    private String nume;
    private TipPersoana tipPersoana;
    private String taxaImpozit;
    private String detalii;
    private float suma;
    private String nrCard;
    private Date dataExpirarii;
    private int codCvv;
    private int imagine;


    public Plata(String nume, TipPersoana tipPersoana,String taxaImpozit, String detalii ,float suma, String nrCard, Date dataExpirarii, int codCvv, int imagine) {
        this.nume = nume;
        this.tipPersoana = tipPersoana;
        this.taxaImpozit = taxaImpozit;
        this.detalii=detalii;
        this.suma = suma;
        this.nrCard = nrCard;
        this.dataExpirarii = dataExpirarii;
        this.codCvv = codCvv;
        this.imagine = imagine;
    }


    public Plata() {

    }

    public Plata(String nume, TipPersoana tipPersoana, String taxaImpozit, String detalii, Float suma, String nrCard, Date data, int codCVV) {
        this.nume = nume;
        this.tipPersoana = tipPersoana;
        this.taxaImpozit = taxaImpozit;
        this.detalii=detalii;
        this.suma = suma;
        this.nrCard = nrCard;
        this.dataExpirarii = data;
        this.codCvv = codCVV;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public TipPersoana getTipPersoana() {
        return tipPersoana;
    }

    public void setTipPersoana(TipPersoana tipPersoana) {
        this.tipPersoana = tipPersoana;
    }



    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }


    public String getNrCard() {
        return nrCard;
    }

    public void setNrCard(String nrCard) {
        this.nrCard = nrCard;
    }

    public Date getDataExpirarii() {
        return dataExpirarii;
    }

    public void setDataExpirarii(Date dataExpirarii) {
        this.dataExpirarii = dataExpirarii;
    }

    public int getCodCvv() {
        return codCvv;
    }

    public void setCodCvv(int codCvv) {
        this.codCvv = codCvv;
    }

    public int getImagine() {
        return imagine;
    }

    public void setImagine(int imagine) {
        this.imagine = imagine;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public String getTaxaImpozit() {
        return taxaImpozit;
    }

    public void setTaxaImpozit(String taxaImpozit) {
        this.taxaImpozit = taxaImpozit;
    }

    @Override
    public String toString() {
        return "Plata{" +
                "nume='" + nume + '\'' +
                ", tipPersoana=" + tipPersoana +
                ", taxaImpozit=" + taxaImpozit +
                ", detalii='" + detalii + '\'' +
                ", suma=" + suma +
                ", nrCard=" + nrCard +
                ", dataExpirarii=" + dataExpirarii +
                ", codCvv=" + codCvv +
                ", imagine=" + imagine +
                '}';
    }
}



