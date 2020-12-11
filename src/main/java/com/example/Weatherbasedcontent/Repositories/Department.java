package com.example.Weatherbasedcontent.Repositories;

public class Department {
    private int id;
    private String description;

    public Department(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
