package com.zperkowski.Must;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

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
        // Variables below have to be validated
        BigDecimal validatedPrice = Validation.stringToBigDecimal(textPrice.getText());
        int validatedDiscount = 0;
        float validatedWeight = 0;
        int validatedGuarantee = 0;
        int validatedStrings = 0;
        int validatedFrets = 0;
        int validatedKeys = 0;
        int validatedMinBandwidth = 0;
        int validatedMaxBandwidth = 0;
        int validatedRms = 0;
        int validatedImpedance = 0;
        int validatedSensitivity = 0;
        int validatedMaxPower = 0;
        int validatedChannels = 0;
        int validatedBitsProcessor = 0;

        switch ((String) comboProductChooser.getValue()) {
            case "Service":
                int validatedDuration = Validation.stringToInt(textDuration.getText());

                Must.listOfProducts.add(
                        new Service(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDuration)
                );
                break;
            case "Product":
                Must.listOfProducts.add(
                        new Product(textName.getText(),
                                validatedPrice,
                                textDescription.getText()
                        )
                );
                break;
            case "Instrument":
                validatedDiscount = Validation.stringToInt(textDiscount.getText());
                validatedWeight = Validation.stringToFloat(textWeight.getText());
                validatedGuarantee = Validation.stringToInt(textGuarantee.getText());

                Must.listOfProducts.add(
                        new Instrument(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDiscount,
                                validatedWeight,
                                textBrand.getText(),
                                textModel.getText(),
                                validatedGuarantee,
                                checkDigital.isSelected())
                );
                break;
            case "Guitar":
                validatedDiscount = Validation.stringToInt(textDiscount.getText());
                validatedWeight = Validation.stringToFloat(textWeight.getText());
                validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                validatedStrings = Validation.stringToInt(textStrings.getText());
                validatedFrets = Validation.stringToInt(textFrets.getText());

                Must.listOfProducts.add(
                        new Guitar(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDiscount,
                                validatedWeight,
                                textBrand.getText(),
                                textModel.getText(),
                                validatedGuarantee,
                                checkDigital.isSelected(),
                                validatedStrings,
                                validatedFrets,
                                comboType.getValue().toString())
                );
                break;
            case "Keyboard":
                validatedDiscount = Validation.stringToInt(textDiscount.getText());
                validatedWeight = Validation.stringToFloat(textWeight.getText());
                validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                validatedKeys = Validation.stringToInt(textKeys.getText());

                Must.listOfProducts.add(
                        new Keyboard(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDiscount,
                                validatedWeight,
                                textBrand.getText(),
                                textModel.getText(),
                                validatedGuarantee,
                                checkDigital.isSelected(),
                                validatedKeys)
                );
                break;
            case "Percussion":
                validatedDiscount = Validation.stringToInt(textDiscount.getText());
                validatedWeight = Validation.stringToFloat(textWeight.getText());
                validatedGuarantee = Validation.stringToInt(textGuarantee.getText());

                Must.listOfProducts.add(
                        new Percussion(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDiscount,
                                validatedWeight,
                                textBrand.getText(),
                                textModel.getText(),
                                validatedGuarantee,
                                checkDigital.isSelected(),
                                checkIsSetComplete.isSelected())
                );
                break;
            case "Sound system":
                validatedDiscount = Validation.stringToInt(textDiscount.getText());
                validatedWeight = Validation.stringToFloat(textWeight.getText());
                validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                validatedMinBandwidth = Validation.stringToInt(textMinBandwidth.getText());
                validatedMaxBandwidth = Validation.stringToInt(textMaxBandwidth.getText());

                Must.listOfProducts.add(
                        new SoundSystem(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDiscount,
                                validatedWeight,
                                textBrand.getText(),
                                textModel.getText(),
                                validatedGuarantee,
                                checkDigital.isSelected(),
                                validatedMinBandwidth,
                                validatedMaxBandwidth)
                );
                break;
            case "Speakers":
                validatedDiscount = Validation.stringToInt(textDiscount.getText());
                validatedWeight = Validation.stringToFloat(textWeight.getText());
                validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                validatedMinBandwidth = Validation.stringToInt(textMinBandwidth.getText());
                validatedMaxBandwidth = Validation.stringToInt(textMaxBandwidth.getText());
                validatedRms = Validation.stringToInt(textRMS.getText());
                validatedImpedance = Validation.stringToInt(textImpedance.getText());

                Must.listOfProducts.add(
                        new Speaker(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDiscount,
                                validatedWeight,
                                textBrand.getText(),
                                textModel.getText(),
                                validatedGuarantee,
                                checkDigital.isSelected(),
                                validatedMinBandwidth,
                                validatedMaxBandwidth,
                                validatedRms,
                                validatedImpedance)
                );
                break;
            case "Mic":
                validatedDiscount = Validation.stringToInt(textDiscount.getText());
                validatedWeight = Validation.stringToFloat(textWeight.getText());
                validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                validatedMinBandwidth = Validation.stringToInt(textMinBandwidth.getText());
                validatedMaxBandwidth = Validation.stringToInt(textMaxBandwidth.getText());
                validatedSensitivity = Validation.stringToInt(textSensitivity.getText());

                Must.listOfProducts.add(
                        new Mic(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDiscount,
                                validatedWeight,
                                textBrand.getText(),
                                textModel.getText(),
                                validatedGuarantee,
                                checkDigital.isSelected(),
                                validatedMinBandwidth,
                                validatedMaxBandwidth,
                                validatedSensitivity)
                );
                break;
            case "Console":
                validatedDiscount = Validation.stringToInt(textDiscount.getText());
                validatedWeight = Validation.stringToFloat(textWeight.getText());
                validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                validatedMaxPower = Validation.stringToInt(textMaxPower.getText());
                validatedChannels = Validation.stringToInt(textChannels.getText());
                validatedBitsProcessor = Validation.stringToInt(textBitsOfProcessor.getText());

                Must.listOfProducts.add(
                        new Consoles(textName.getText(),
                                validatedPrice,
                                textDescription.getText(),
                                validatedDiscount,
                                validatedWeight,
                                textBrand.getText(),
                                textModel.getText(),
                                validatedGuarantee,
                                checkDigital.isSelected(),
                                validatedMaxPower,
                                validatedChannels,
                                validatedBitsProcessor)
                );
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
