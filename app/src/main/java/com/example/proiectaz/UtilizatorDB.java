package com.example.proiectaz;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Utilizator.class,Sesizare.class}, version = 5, exportSchema = false)
abstract public class UtilizatorDB extends RoomDatabase  {

    public abstract UtilizatorDAO getUtilizatorDao();
}
