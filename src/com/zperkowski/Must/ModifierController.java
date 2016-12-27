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
    public TextField textModel;
    public TextField textGuarantee;
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
        setAllDisabled();
        switch ((String) comboProductChooser.getValue()) {
            case "Service":
                activateProduct();
                activateService();
                break;
            case "Product":
                activateProduct();
                break;
            case "Instrument":
                activateProduct();
                activateInstrument();
                break;
            case "Guitar":
                activateProduct();
                activateInstrument();
                activateGuitar();
                break;
            case "Keyboard":
                activateProduct();
                activateInstrument();
                activateKeyboard();
                break;
            case "Percussion":
                activateProduct();
                activateInstrument();
                activatePercussion();
                break;
            case "Sound system":
                activateProduct();
                activateInstrument();
                activateSoundSystem();
                break;
            case "Speakers":
                activateProduct();
                activateInstrument();
                activateSoundSystem();
                activateSpeaker();
                break;
            case "Mic":
                activateProduct();
                activateInstrument();
                activateSoundSystem();
                activateMic();
                break;
            case "Console":
                activateProduct();
                activateInstrument();
                activateConsoles();
                break;
        }
    }

    public void doneButtonClicked() {
        switch ((String) comboProductChooser.getValue()) {
            case "Service":

                break;
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

    /**
     * Sets all controls to disabled mode.
     */
    private void setAllDisabled() {
        textDuration.setDisable(true);
        textName.setDisable(true);
        textPrice.setDisable(true);
        textBrand.setDisable(true);
        comboType.setDisable(true);
        textWeight.setDisable(true);
        checkDigital.setDisable(true);
        checkIsSetComplete.setDisable(true);
        textDiscount.setDisable(true);
        textStrings.setDisable(true);
        textFrets.setDisable(true);
        textKeys.setDisable(true);
        textMinBandwidth.setDisable(true);
        textMaxBandwidth.setDisable(true);
        textImpedance.setDisable(true);
        textRMS.setDisable(true);
        textSensitivity.setDisable(true);
        textMaxPower.setDisable(true);
        textChannels.setDisable(true);
        textBitsOfProcessor.setDisable(true);
        textDescription.setDisable(true);
    }

    private void activateProduct() {
        textName.setDisable(false);
        textPrice.setDisable(false);
        textDescription.setDisable(false);
    }

    private void activateService() {
        textDuration.setDisable(false);
    }

    private void activateInstrument() {
        textDiscount.setDisable(false);
        textWeight.setDisable(false);
        textBrand.setDisable(false);
        textModel.setDisable(false);
        textGuarantee.setDisable(false);
        checkDigital.setDisable(false);
    }

    private void activateGuitar() {
        textStrings.setDisable(false);
        textFrets.setDisable(false);
        comboType.setDisable(false);
    }

    private void activateKeyboard() {
        textKeys.setDisable(false);
    }

    private void activatePercussion() {
        checkIsSetComplete.setDisable(false);
    }

    private void activateSoundSystem() {
        textMinBandwidth.setDisable(false);
        textMaxBandwidth.setDisable(false);
    }

    private void activateSpeaker() {
        textRMS.setDisable(false);
        textImpedance.setDisable(false);
    }

    private void activateMic() {
        textSensitivity.setDisable(false);
    }

    private void activateConsoles() {
        textMaxPower.setDisable(false);
        textChannels.setDisable(false);
        textBitsOfProcessor.setDisable(false);
    }
}
