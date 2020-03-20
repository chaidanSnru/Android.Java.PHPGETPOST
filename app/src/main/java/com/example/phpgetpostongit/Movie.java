package com.example.phpgetpostongit;

public class Movie {
    int id;
    float ratting;
    String name, image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRatting() {
        return ratting;
    }

    public void setRatting(float ratting) {
        this.ratting = ratting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImageUrl(String imageUrl) {
        this.image = image;
    }
}
