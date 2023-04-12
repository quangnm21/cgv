package com.example.sqlitetest.databases;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sqlitetest.Fim;

import java.util.List;

@Dao
public interface FimDAO {
    @Insert
    void insertFim(Fim fim);
    @Query("select * from tbfim")
    List<Fim> getFimList();
}
