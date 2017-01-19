package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Consoles extends Instrument {
    private int maxPower;
    private int channels;
    private int bitsProcessor;

    public Consoles(String name, BigDecimal price, String description, Image image, LocalDate discountStart, LocalDate discountEnd, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int maxPower, int channels, int bitsProcessor) {
        super(name, price, description, image, discountStart, discountEnd, discount, weight, brand, model, guaranteeInMonths, isDigital);
        this.maxPower = maxPower;
        this.channels = channels;
        this.bitsProcessor = bitsProcessor;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public int getBitsProcessor() {
        return bitsProcessor;
    }

    public void setBitsProcessor(int bitsProcessor) {
        this.bitsProcessor = bitsProcessor;
    }
}
