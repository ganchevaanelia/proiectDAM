package com.example.proiectaz;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomWarnings;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface UtilizatorDAO {

    @Insert
    public void insertUtilizator(Utilizator user);

    @Query("SELECT * FROM utilizatori")
    public List<Utilizator> getUtilizatori();

    @Query("delete from utilizatori")
    void deleteAll();

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Transaction
    @Query("SELECT * FROM utilizatori")
    public List<UtilizatoriCuSesizari> getUtilizatoriCuSesizari();

    @Query("SELECT * FROM sesizari")
    public List<Sesizare> getSesizari();

}