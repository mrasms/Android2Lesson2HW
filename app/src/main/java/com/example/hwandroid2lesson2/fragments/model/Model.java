package com.example.hwandroid2lesson2.fragments.model;

public class Model {

    private String description;
    private int image;

    public Model(String description, int image) {
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
