package com.example.proiectaz;

import androidx.annotation.NonNull;

import java.util.Date;

enum TipPersoana {FIZICA, JURIDICA};


public class Plata {

   private String nume;
   private TipPersoana tipPersoana;
    private String tipPlata;
    private float suma;
    private int nrCard;
    private Date dataExpirarii;
    private int codCvv;


    public Plata(String nume, TipPersoana tipPersoana, String tipPlata, float suma,  int nrCard, Date dataExpirarii, int codCvv) {
        this.nume = nume;
        this.tipPersoana = tipPersoana;
        this.tipPlata = tipPlata;
        this.suma = suma;
        this.nrCard = nrCard;
        this.dataExpirarii = dataExpirarii;
        this.codCvv = codCvv;
    }


    public Plata(){

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

    public String getTipPlata() {
        return tipPlata;
    }

    public void setTipPlata(String tipPlata) {
        this.tipPlata = tipPlata;
    }

    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }



    public int getNrCard() {
        return nrCard;
    }

    public void setNrCard(int nrCard) {
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


}

