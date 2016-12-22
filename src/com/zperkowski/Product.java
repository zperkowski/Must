package com.zperkowski;

import java.math.BigDecimal;

class Product {
    private BigDecimal price;
    private int discount;
    private String description;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Service extends Product {
    private int durationInHours;

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
}

class Instrument extends Product {
    private float weight;
    private String brand;
    private String model;
    private int guaranteeInMonths;
    private String type;
    private boolean isDigital;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGuaranteeInMonths() {
        return guaranteeInMonths;
    }

    public void setGuaranteeInMonths(int guaranteeInMonths) {
        this.guaranteeInMonths = guaranteeInMonths;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }
}

class Guitar extends Instrument {
    private int strings;
    private int frets;

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
}

class Keyboard extends Instrument {
    private int keys;

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }
}

class Percussion extends Instrument {
    private boolean isSetComplete;

    public boolean isSetComplete() {
        return isSetComplete;
    }

    public void setSetComplete(boolean setComplete) {
        isSetComplete = setComplete;
    }
}

class SoundSystem extends Instrument {
    private int minBandwidth;
    private int maxBandwidth;

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

class Speaker extends SoundSystem {
    private int rms;
    private int impedance;

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

class Mic extends SoundSystem {
    private int sensitivity;

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }
}

class Consoles extends Instrument {
    private int maxPower;
    private int channels;
    private int bitsProcessor;

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