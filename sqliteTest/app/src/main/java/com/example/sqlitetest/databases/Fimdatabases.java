package com.example.sqlitetest.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sqlitetest.Fim;

@Database(entities = {Fim.class}, version = 1)
public abstract class Fimdatabases extends RoomDatabase {
    private static final String DATABASE_NAME="fim.db";
    private static Fimdatabases instance;
    public static synchronized Fimdatabases getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), Fimdatabases.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract FimDAO fimDAO();
}
