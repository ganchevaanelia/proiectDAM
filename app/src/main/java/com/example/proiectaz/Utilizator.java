package com.example.proiectaz;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "utilizatori")
public class Utilizator implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String Prenume;
    private String Nume;
    private String Username;
    private String Email;
    private String Password;
    private String Telefon;
   private String Gen;


    public Utilizator( int id,String prenume, String nume, String username, String email, String password, String telefon, String gen) {
        ID = id;
        Prenume = prenume;
        Nume = nume;
        Username = username;
        Email = email;
        Password = password;
        Telefon = telefon;
        Gen = gen;
    }

    public Utilizator(String username, String password) {
        Username = username;
        Password = password;
    }

    public Utilizator() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getGen() {
        return Gen;
    }

    public void setGen(String gen) {
        Gen = gen;
    }


    @Override
    public String toString() {
        return "Utilizator{" +
                "ID=" + ID +
                ", Prenume='" + Prenume + '\'' +
                ", Nume='" + Nume + '\'' +
                ", Username='" + Username + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", gen=" + Gen +
                '}';
    }
}


