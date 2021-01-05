package com.example.proiectaz;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UtilizatorDAO {

    @Insert
    public void insertUtilizator(Utilizator user);
}