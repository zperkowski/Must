package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;

public class Instrument extends Product {
    private int discount;
    private float weight;
    private String brand;
    private String model;
    private int guaranteeInMonths;
    private boolean isDigital;

    public Instrument(String name, BigDecimal price, String description, Image image, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital) {
        super(name, price, description, image);
        this.discount = discount;
        this.weight = weight;
        this.brand = brand;
        this.model = model;
        this.guaranteeInMonths = guaranteeInMonths;
        this.isDigital = isDigital;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

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

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }
}
