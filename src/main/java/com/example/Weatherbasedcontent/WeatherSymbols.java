package com.example.Weatherbasedcontent;

public class WeatherSymbols {
    private String category;
    private String image;
    private String name;

    public WeatherSymbols(String category, String image, String name) {
        this.category = category;
        this.image = image;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
