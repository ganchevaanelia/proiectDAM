package com.example.proiectaz;


import androidx.room.TypeConverter;

public class GenConvertor {

    @TypeConverter
    public static String toString(Gen gen) {
        return gen == null ? null : gen.toString();
    }

    @TypeConverter
    public static Gen toGen(String name) {
        return name == null ? null : Gen.valueOf(name);
    }
}
