package com.example.Weatherbasedcontent.Repositories;

public class Content {
    private int id;
    private String image;
    private String url;
    private String text;

    public Content(int id, String image, String url, String text) {
        this.id = id;
        this.image = image;
        this.url = url;
        this.text = text;
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

    public String getText() {
        return text;
    }
}
