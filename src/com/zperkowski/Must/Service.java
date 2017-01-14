package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;

public class Service extends Product {
    private int durationInHours;

    public Service(String name, BigDecimal price, String description, Image image, int durationInHours) {
        super(name, price, description, image);
        this.durationInHours = durationInHours;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
}
