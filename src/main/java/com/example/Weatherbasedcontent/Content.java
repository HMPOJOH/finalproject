package com.example.Weatherbasedcontent;

public class Content {
    private int id;
    private String image;
    private String url;

    public Content(int id, String image, String url) {
        this.id = id;
        this.image = image;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
