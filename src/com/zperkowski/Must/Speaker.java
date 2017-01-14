package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;

public class Speaker extends SoundSystem {
    private int rms;
    private int impedance;

    public Speaker(String name, BigDecimal price, String description, Image image, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int minBandwidth, int maxBandwidth, int rms, int impedance) {
        super(name, price, description, image, discount, weight, brand, model, guaranteeInMonths, isDigital, minBandwidth, maxBandwidth);
        this.rms = rms;
        this.impedance = impedance;
    }

    public int getRms() {
        return rms;
    }

    public void setRms(int rms) {
        this.rms = rms;
    }

    public int getImpedance() {
        return impedance;
    }

    public void setImpedance(int impedance) {
        this.impedance = impedance;
    }
}
