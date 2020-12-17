package com.example.Weatherbasedcontent.Repositories;

public class Scenario {
    private int id;
    private String description;
    private String background;
    private int qtyContent;

    public Scenario(int id, String description, String background) {
        this.id = id;
        this.description = description;
        this.background = background;
    }

    public void setQtyContent(int qtyContent) {
        this.qtyContent = qtyContent;
    }
    public int getQtyContent() {
        return qtyContent;
    }
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
