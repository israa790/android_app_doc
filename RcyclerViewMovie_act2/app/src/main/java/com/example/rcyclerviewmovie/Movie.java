package com.example.rcyclerviewmovie;

public class Movie {
    public String tiltle;
    public Integer imgURL;

    public Movie(String tiltle, Integer imgURL) {
        this.tiltle = tiltle;
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return tiltle;
    }

    public Integer getImgURL() {
        return imgURL;
    }
}
