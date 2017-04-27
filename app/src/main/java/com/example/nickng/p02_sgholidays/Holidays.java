package com.example.nickng.p02_sgholidays;

/**
 * Created by 15056201 on 27/4/2017.
 */

public class Holidays {
    private String name;
    private String date;
    private boolean secular;
    private int sym;

    public Holidays(String name, String date, boolean secular, int sym) {
        this.name = name;
        this.date = date;
        this.secular = secular;
        this.sym = sym;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }

    public boolean isSecular(){
        return secular;
    }

    public int getSym(){
        return sym;
    }
}
