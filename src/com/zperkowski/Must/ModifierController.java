package com.zperkowski.Must;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * A controller for the products modifier.
 */
public class ModifierController {

    @FXML
    public ComboBox comboProductChooser;
    public TextField textDuration;
    public TextField textName;
    public TextField textPrice;
    public TextField textBrand;
    public ComboBox comboType;
    public TextField textWeight;
    public CheckBox checkDigital;
    public CheckBox checkIsSetComplete;
    public TextField textDiscount;
    public TextField textStrings;
    public TextField textFrets;
    public TextField textKeys;
    public TextField textMinBandwidth;
    public TextField textMaxBandwidth;
    public TextField textImpedance;
    public TextField textRMS;
    public TextField textSensitivity;
    public TextField textMaxPower;
    public TextField textChannels;
    public TextField textBitsOfProcessor;
    public TextArea textDescription;


    public void updateModifier() {
        switch ((String) comboProductChooser.getValue()) {
            case "Product":

                break;
            case "Instrument":

                break;
            case "Guitar":

                break;
            case "Keyboard":

                break;
            case "Percussion":

                break;
            case "Sound system":

                break;
            case "Speakers":

                break;
            case "Mic":

                break;
            case "Console":

                break;
        }
    }

    public void doneButtonClicked() {
        switch ((String) comboProductChooser.getValue()) {
            case "Product":

                break;
            case "Instrument":

                break;
            case "Guitar":

                break;
            case "Keyboard":

                break;
            case "Percussion":

                break;
            case "Sound system":

                break;
            case "Speakers":

                break;
            case "Mic":

                break;
            case "Console":

                break;
        }
    }
}
