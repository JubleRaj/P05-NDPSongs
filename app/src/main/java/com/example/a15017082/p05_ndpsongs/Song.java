package com.example.a15017082.p05_ndpsongs;

import java.io.Serializable;

/**
 * Created by 15017082 on 18/5/2017.
 */

public class Song implements Serializable{

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars){
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_Id(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getSingers(){
        return singers;
    }

    public int getYear(){
        return year;
    }

    public int getStar(){
        return stars;
    }
}

