package com.example.foodreview;

public class Food {
    String district;
    String foodname;
    String foodImage;
    double foodrate;
    String discription;
    String linkit;

    public String getDistrict() {
        return district;
    }

    public String getFoodname() {
        return foodname;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public double getFoodrate() {
        return foodrate;
    }

    public String getDiscription() {
        return discription;
    }

    public String getLinkit() {
        return linkit;
    }

    public Food(String district, String foodname, String foodImage, double foodrate, String discription, String linkit) {
        this.district = district;
        this.foodname = foodname;
        this.foodImage = foodImage;
        this.foodrate = foodrate;
        this.discription = discription;
        this.linkit = linkit;
    }
}
