package com.example.proiectaz;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

public class UtilizatoriCuSesizari {
    @Embedded
    public Utilizator utilizator;
    @Relation(
            entity = Sesizare.class,
            parentColumn = "ID",
            entityColumn = "utilizatorID"
    )
    public List<Sesizare> listasesizari;

}
