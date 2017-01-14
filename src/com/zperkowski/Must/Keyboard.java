package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;

public class Keyboard extends Instrument {
    private int keys;

    public Keyboard(String name, BigDecimal price, String description, Image image, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int keys) {
        super(name, price, description, image, discount, weight, brand, model, guaranteeInMonths, isDigital);
        this.keys = keys;
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }
}
