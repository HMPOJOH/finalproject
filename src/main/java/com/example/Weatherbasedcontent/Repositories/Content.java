package com.example.Weatherbasedcontent.Repositories;

public class Content {
    private int id;
    private String image;
    private String url;
    private String text;

    public Content() {}

    public Content(int id, String image, String url, String text) {
        this.id = id;
        this.image = image;
        this.url = url;
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setText(String text) {
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
