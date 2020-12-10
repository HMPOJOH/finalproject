package com.example.Weatherbasedcontent;

public class WeatherSymbols {
    private String category;



    private Integer categoryId;
    private String image;
    private String name;

    public WeatherSymbols(String category, int categoryId, String image, String name) {
        this.category = category;
        this.categoryId=categoryId;
        this.image = image;
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
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
