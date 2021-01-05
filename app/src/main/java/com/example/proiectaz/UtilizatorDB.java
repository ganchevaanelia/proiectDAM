package com.example.proiectaz;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Utilizator.class}, version = 2, exportSchema = false)
@TypeConverters({GenConvertor.class})
abstract public class UtilizatorDB extends RoomDatabase  {

    private final static String DB_NAME = "utilizatori.db";
    private static UtilizatorDB instanta;

    public static UtilizatorDB getInstanta(Context context)
    {
        if (instanta==null)
            instanta = Room.databaseBuilder(context, UtilizatorDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();

        return instanta;
    }

    public abstract UtilizatorDAO getUtilizatorDao();
}
