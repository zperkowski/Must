package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SoundSystem extends Instrument {
    private int minBandwidth;
    private int maxBandwidth;

    public SoundSystem(String name, BigDecimal price, String description, Image image, LocalDate discountStart, LocalDate discountEnd, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int minBandwidth, int maxBandwidth) {
        super(name, price, description, image, discountStart, discountEnd, discount, weight, brand, model, guaranteeInMonths, isDigital);
        this.minBandwidth = minBandwidth;
        this.maxBandwidth = maxBandwidth;
    }

    public int getMinBandwidth() {
        return minBandwidth;
    }

    public void setMinBandwidth(int minBandwidth) {
        this.minBandwidth = minBandwidth;
    }

    public int getMaxBandwidth() {
        return maxBandwidth;
    }

    public void setMaxBandwidth(int maxBandwidth) {
        this.maxBandwidth = maxBandwidth;
    }
}
