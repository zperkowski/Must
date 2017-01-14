package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;

public class Guitar extends Instrument {
    private int strings;
    private int frets;
    private String type;

    public Guitar(String name, BigDecimal price, String description, Image image, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int strings, int frets, String type) {
        super(name, price, description, image, discount, weight, brand, model, guaranteeInMonths, isDigital);
        this.strings = strings;
        this.frets = frets;
        this.type = type;
    }

    public int getStrings() {
        return strings;
    }

    public void setStrings(int strings) {
        this.strings = strings;
    }

    public int getFrets() {
        return frets;
    }

    public void setFrets(int frets) {
        this.frets = frets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
