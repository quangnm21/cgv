package com.example.sqlitetest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbfim")
public class Fim {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String ma;
    private String ten;

    public Fim(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
