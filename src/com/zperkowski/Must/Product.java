package com.zperkowski.Must;

import javafx.scene.image.Image;

import java.math.BigDecimal;

class Product {
    private String name;
    private BigDecimal price;
    private String description;
    private Image image;


    public Product(String name, BigDecimal price, String description, Image image) {
        this.setName(name);
        this.setPrice(price);
        this.setDescription(description);
        this.setImage(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

class Service extends Product {
    private int durationInHours;

    public Service(String name, BigDecimal price, String description, Image image, int durationInHours) {
        super(name, price, description, image);
        this.durationInHours = durationInHours;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
}

class Instrument extends Product {
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

class Guitar extends Instrument {
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

class Keyboard extends Instrument {
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

class Percussion extends Instrument {
    private boolean isSetComplete;

    public Percussion(String name, BigDecimal price, String description, Image image, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, boolean isSetComplete) {
        super(name, price, description, image, discount, weight, brand, model, guaranteeInMonths, isDigital);
        this.isSetComplete = isSetComplete;
    }

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

    public SoundSystem(String name, BigDecimal price, String description, Image image, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int minBandwidth, int maxBandwidth) {
        super(name, price, description, image, discount, weight, brand, model, guaranteeInMonths, isDigital);
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

class Speaker extends SoundSystem {
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

class Mic extends SoundSystem {
    private int sensitivity;

    public Mic(String name, BigDecimal price, String description, Image image, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int minBandwidth, int maxBandwidth, int sensitivity) {
        super(name, price, description, image, discount, weight, brand, model, guaranteeInMonths, isDigital, minBandwidth, maxBandwidth);
        this.sensitivity = sensitivity;
    }

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

    public Consoles(String name, BigDecimal price, String description, Image image, int discount, float weight, String brand, String model, int guaranteeInMonths, boolean isDigital, int maxPower, int channels, int bitsProcessor) {
        super(name, price, description, image, discount, weight, brand, model, guaranteeInMonths, isDigital);
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