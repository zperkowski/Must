package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Mic extends SoundSystem {
    private int sensitivity;

    public Mic(String name, BigDecimal price, String description, Image image, LocalDate discountStart, LocalDate discountEnd, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int minBandwidth, int maxBandwidth, int sensitivity) {
        super(name, price, description, image, discountStart, discountEnd, discount, weight, brand, model, guaranteeInMonths, isDigital, minBandwidth, maxBandwidth);
        this.sensitivity = sensitivity;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }
}
