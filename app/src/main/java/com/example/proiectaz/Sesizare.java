package com.example.proiectaz;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "sesizari")
public class Sesizare implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Categorie;
    private String Subcategorie;
    private String DetaliiSesizare;
    private String ParereRating;
    private String ParereDetalii;
    private int utilizatorID;

    public Sesizare() {
    }

    public Sesizare(int id, String categorie, String subcategorie, String detaliiSesizare, String parereRating, String parereDetalii, int utilizatorID) {
        this.id = id;
        Categorie = categorie;
        Subcategorie = subcategorie;
        DetaliiSesizare = detaliiSesizare;
        ParereRating = parereRating;
        ParereDetalii = parereDetalii;
        this.utilizatorID = utilizatorID;
    }

    public Sesizare(String categorie, String subcategorie, String detaliiSesizare, String parereRating, String parereDetalii) {
        Categorie = categorie;
        Subcategorie = subcategorie;
        DetaliiSesizare = detaliiSesizare;
        ParereRating = parereRating;
        ParereDetalii = parereDetalii;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUtilizatorID() {
        return utilizatorID;
    }

    public void setUtilizatorID(int utilizatorID) {
        this.utilizatorID = utilizatorID;
    }

    @Override
    public String toString() {
        return "Sesizare{" +
                "id=" + id +
                ", Categorie='" + Categorie + '\'' +
                ", Subcategorie='" + Subcategorie + '\'' +
                ", DetaliiSesizare='" + DetaliiSesizare + '\'' +
                ", ParereRating='" + ParereRating + '\'' +
                ", ParereDetalii='" + ParereDetalii + '\'' +
                ", utilizatorID=" + utilizatorID +
                '}';
    }
}




