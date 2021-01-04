package com.example.proiectaz;

import java.io.Serializable;
enum Gen{FEMININ, MASCULIN}
public class Utilizator implements Serializable {
    private String Prenume;
    private String Nume;
    private String Username;
    private String Email;
    private String Password;
    private int telefon;
    private Gen gen;

    public Utilizator(String prenume, String nume, String username, String email, String password, int telefon, Gen gen) {
        Prenume = prenume;
        Nume = nume;
        Username = username;
        Email = email;
        Password = password;
        this.telefon = telefon;
        this.gen = gen;
    }

    public Utilizator(String username, String password) {
        Username = username;
        Password = password;
    }


}


