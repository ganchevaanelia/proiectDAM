package com.example.proiectaz;

import java.io.Serializable;

public class Sesizare implements Serializable {

    private String Categorie;
    private String Subcategorie;
    private String DetaliiSesizare;
    private String ParereRating;
    private String ParereDetalii;


    public Sesizare(String categorie, String subcategorie, String detaliiSesizare, String parereRating, String parereDetalii) {
        Categorie = categorie;
        Subcategorie = subcategorie;
        DetaliiSesizare = detaliiSesizare;
        ParereRating = parereRating;
        ParereDetalii = parereDetalii;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }

    public String getSubcategorie() {
        return Subcategorie;
    }

    public void setSubcategorie(String subcategorie) {
        Subcategorie = subcategorie;
    }

    public String getDetaliiSesizare() {
        return DetaliiSesizare;
    }

    public void setDetaliiSesizare(String detaliiSesizare) {
        DetaliiSesizare = detaliiSesizare;
    }

    public String getParereRating() {
        return ParereRating;
    }

    public void setParereRating(String parereRating) {
        ParereRating = parereRating;
    }

    public String getParereDetalii() {
        return ParereDetalii;
    }

    public void setParereDetalii(String parereDetalii) {
        ParereDetalii = parereDetalii;
    }

    @Override
    public String toString() {
        return "Sesizare{" +
                "Categorie='" + Categorie + '\'' +
                ", Subcategorie='" + Subcategorie + '\'' +
                ", DetaliiSesizare='" + DetaliiSesizare + '\'' +
                ", ParereRating='" + ParereRating + '\'' +
                ", ParereDetalii='" + ParereDetalii + '\'' +
                '}';
    }
}




