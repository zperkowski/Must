package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Instrument extends Product {
    private LocalDate discountStart;
    private LocalDate discountEnd;
    private int discount;
    private float weight;
    private String brand;
    private String model;
    private int guaranteeInMonths;
    private boolean isDigital;

    public Instrument(String name, BigDecimal price, String description, Image image, LocalDate discountStart, LocalDate discountEnd, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital) {
        super(name, price, description, image);
        this.discountStart = discountStart;
        this.discountEnd = discountEnd;
        this.discount = discount;
        this.weight = weight;
        this.brand = brand;
        this.model = model;
        this.guaranteeInMonths = guaranteeInMonths;
        this.isDigital = isDigital;
    }

    public LocalDate getDiscountStart() {
        return discountStart;
    }

    public void setDiscountStart(LocalDate discountStart) {
        this.discountStart = discountStart;
    }

    public LocalDate getDiscountEnd() {
        return discountEnd;
    }

    public void setDiscountEnd(LocalDate discountEnd) {
        this.discountEnd = discountEnd;
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
