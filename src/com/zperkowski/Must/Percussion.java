package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Percussion extends Instrument {
    private boolean isSetComplete;

    public Percussion(String name, BigDecimal price, String description, Image image, LocalDate discountStart, LocalDate discountEnd, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, boolean isSetComplete) {
        super(name, price, description, image, discountStart, discountEnd, discount, weight, brand, model, guaranteeInMonths, isDigital);
        this.isSetComplete = isSetComplete;
    }

    public boolean isSetComplete() {
        return isSetComplete;
    }

    public void setSetComplete(boolean setComplete) {
        isSetComplete = setComplete;
    }
}
