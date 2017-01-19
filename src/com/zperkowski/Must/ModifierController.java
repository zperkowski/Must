package com.zperkowski.Must;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A controller for the products modifier.
 */
public class ModifierController {
    Image imageProduct;

    @FXML
    public Button buttonFinish;
    public ComboBox<String> comboProductChooser;
    public TextField textDuration;
    public TextField textName;
    public TextField textPrice;
    public TextField textBrand;
    public TextField textModel;
    public TextField textGuarantee;
    public ComboBox<String> comboType;
    public TextField textWeight;
    public CheckBox checkDigital;
    public CheckBox checkIsSetComplete;
    public DatePicker dateDiscountStart;
    public DatePicker dateDiscountEnd;
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
    public Label labelPicture;

    private int indexOfEditing;

    /***
     * Initializes proper input for certain fields and checks if should add or edit a Product
     */
    @FXML
    public void initialize() {

        indexOfEditing = Must.indexOfSelectedItem;
        Must.indexOfSelectedItem = -1;

        if (indexOfEditing > -1) {
            buttonFinish.setText("Edit");

            Product editingProduct = Must.listOfProducts.get(indexOfEditing);

            switch (editingProduct.getClass().getName()) {
                case "com.zperkowski.Must.Product":
                    comboProductChooser.setValue("Product");
                    fillDetailOfProduct(editingProduct);
                    break;
                case "com.zperkowski.Must.Service":
                    comboProductChooser.setValue("Service");
                    fillDetailOfProduct((Service) editingProduct);
                case "com.zperkowski.Must.Instrument":
                    comboProductChooser.setValue("Instrument");
                    fillDetailOfProduct((Instrument) editingProduct);
                    break;
                case "com.zperkowski.Must.Guitar":
                    comboProductChooser.setValue("Guitar");
                    fillDetailOfProduct((Guitar) editingProduct);
                    break;
                case "com.zperkowski.Must.Keyboard":
                    comboProductChooser.setValue("Keyboard");
                    fillDetailOfProduct((Keyboard) editingProduct);
                    break;
                case "com.zperkowski.Must.Percussion":
                    comboProductChooser.setValue("Percussion");
                    fillDetailOfProduct((Percussion) editingProduct);
                    break;
                case "com.zperkowski.Must.SoundSystem":
                    comboProductChooser.setValue("SoundSystem");
                    fillDetailOfProduct((SoundSystem) editingProduct);
                    break;
                case "com.zperkowski.Must.Speaker":
                    comboProductChooser.setValue("Speaker");
                    fillDetailOfProduct((Speaker) editingProduct);
                    break;
                case "com.zperkowski.Must.Mic":
                    comboProductChooser.setValue("Mic");
                    fillDetailOfProduct((Mic) editingProduct);
                    break;
                case "com.zperkowski.Must.Consoles":
                    comboProductChooser.setValue("Consoles");
                    fillDetailOfProduct((Consoles) editingProduct);
                    break;
            }

        } else {
            dateDiscountStart.setValue(LocalDate.now());
            dateDiscountEnd.setValue(LocalDate.now().plusDays(1));
        }

        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isBefore(
                                        dateDiscountStart.getValue().plusDays(1))
                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        dateDiscountEnd.setDayCellFactory(dayCellFactory);

        dateDiscountStart.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isAfter(dateDiscountEnd.getValue())) {
                dateDiscountEnd.setValue(newValue.plusDays(1));
            }
        });

        updateModifier();

        // int
        textDuration.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textDuration.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        // TODO: Create regex for BigDecimal. Maybe regex for float fits to the BigDecimal?
        // BigDecimal
        textPrice.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textPrice.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textGuarantee.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textGuarantee.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        // TODO: Create regex for float
        // float
        textWeight.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textWeight.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        // int
        textDiscount.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textDiscount.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textStrings.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textStrings.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textFrets.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textFrets.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textKeys.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textKeys.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textMinBandwidth.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textMinBandwidth.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textMaxBandwidth.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textMaxBandwidth.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textImpedance.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textImpedance.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textRMS.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textRMS.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textSensitivity.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textSensitivity.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textMaxPower.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textMaxPower.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textChannels.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textChannels.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // int
        textBitsOfProcessor.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textBitsOfProcessor.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    private void fillDetailOfProduct(Product product) {
        textName.setText(product.getName());
        textPrice.setText(product.getPrice().toString());
        textDescription.setText(product.getDescription());
        imageProduct = product.getImage();
        if (imageProduct != null)
            labelPicture.setText("Image chosen");
    }

    private void fillDetailOfProduct(Service service) {
        fillDetailOfProduct((Product) service);
        textDuration.setText(Integer.toString(service.getDurationInHours()));

    }

    private void fillDetailOfProduct(Instrument instrument) {
        fillDetailOfProduct((Product) instrument);
        dateDiscountStart.setValue(instrument.getDiscountStart());
        dateDiscountEnd.setValue(instrument.getDiscountEnd());
        textDiscount.setText(Integer.toString(instrument.getDiscount()));
        textWeight.setText(Float.toString(instrument.getWeight()));
        textBrand.setText(instrument.getBrand());
        textModel.setText(instrument.getModel());
        textGuarantee.setText(Integer.toString(instrument.getGuaranteeInMonths()));
        checkDigital.setSelected(instrument.isDigital());

    }

    private void fillDetailOfProduct(Guitar guitar) {
        fillDetailOfProduct((Instrument) guitar);
        textStrings.setText(Integer.toString(guitar.getStrings()));
        textFrets.setText(Integer.toString(guitar.getFrets()));
        comboType.setValue(guitar.getType());

    }

    private void fillDetailOfProduct(Keyboard keyboard) {
        fillDetailOfProduct((Instrument) keyboard);
        textKeys.setText(Integer.toString(keyboard.getKeys()));

    }

    private void fillDetailOfProduct(Percussion percussion) {
        fillDetailOfProduct((Instrument) percussion);
        checkIsSetComplete.setSelected(percussion.isSetComplete());

    }

    private void fillDetailOfProduct(SoundSystem soundSystem) {
        fillDetailOfProduct((Instrument) soundSystem);
        textMinBandwidth.setText(Integer.toString(soundSystem.getMinBandwidth()));
        textMaxBandwidth.setText(Integer.toString(soundSystem.getMaxBandwidth()));

    }

    private void fillDetailOfProduct(Speaker speaker) {
        fillDetailOfProduct((SoundSystem) speaker);
        textRMS.setText(Integer.toString(speaker.getRms()));
        textImpedance.setText(Integer.toString(speaker.getImpedance()));

    }

    private void fillDetailOfProduct(Mic mic) {
        fillDetailOfProduct((SoundSystem) mic);
        textSensitivity.setText(Integer.toString(mic.getSensitivity()));
    }

    private void fillDetailOfProduct(Consoles consoles) {
        fillDetailOfProduct((Instrument) consoles);
        textMaxPower.setText(Integer.toString(consoles.getMaxPower()));
        textChannels.setText(Integer.toString(consoles.getChannels()));
        textBitsOfProcessor.setText(Integer.toString(consoles.getBitsProcessor()));

    }

    public void updateModifier() {
        setAllDisabled();
        switch (comboProductChooser.getValue()) {
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

    // TODO: Refactor
    public void doneButtonClicked() {
        if (!isRequiredInformationMissing()) {
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

            Product tmpProduct;

            switch (comboProductChooser.getValue()) {
                case "Service":
                    int validatedDuration = Validation.stringToInt(textDuration.getText());

                    tmpProduct = new Service(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    validatedDuration);
                    break;
                case "Product":
                    tmpProduct = new Product(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct
                            );
                    break;
                case "Instrument":
                    validatedDiscount = Validation.stringToInt(textDiscount.getText());
                    validatedWeight = Validation.stringToFloat(textWeight.getText());
                    validatedGuarantee = Validation.stringToInt(textGuarantee.getText());

                    tmpProduct = new Instrument(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    dateDiscountStart.getValue(),
                                    dateDiscountEnd.getValue(),
                                    validatedDiscount,
                                    validatedWeight,
                                    textBrand.getText(),
                                    textModel.getText(),
                                    validatedGuarantee,
                                    checkDigital.isSelected());
                    break;
                case "Guitar":
                    validatedDiscount = Validation.stringToInt(textDiscount.getText());
                    validatedWeight = Validation.stringToFloat(textWeight.getText());
                    validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                    validatedStrings = Validation.stringToInt(textStrings.getText());
                    validatedFrets = Validation.stringToInt(textFrets.getText());

                    tmpProduct = new Guitar(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    dateDiscountStart.getValue(),
                                    dateDiscountEnd.getValue(),
                                    validatedDiscount,
                                    validatedWeight,
                                    textBrand.getText(),
                                    textModel.getText(),
                                    validatedGuarantee,
                                    checkDigital.isSelected(),
                                    validatedStrings,
                                    validatedFrets,
                                    comboType.getValue());
                    break;
                case "Keyboard":
                    validatedDiscount = Validation.stringToInt(textDiscount.getText());
                    validatedWeight = Validation.stringToFloat(textWeight.getText());
                    validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                    validatedKeys = Validation.stringToInt(textKeys.getText());

                    tmpProduct = new Keyboard(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    dateDiscountStart.getValue(),
                                    dateDiscountEnd.getValue(),
                                    validatedDiscount,
                                    validatedWeight,
                                    textBrand.getText(),
                                    textModel.getText(),
                                    validatedGuarantee,
                                    checkDigital.isSelected(),
                                    validatedKeys);
                    break;
                case "Percussion":
                    validatedDiscount = Validation.stringToInt(textDiscount.getText());
                    validatedWeight = Validation.stringToFloat(textWeight.getText());
                    validatedGuarantee = Validation.stringToInt(textGuarantee.getText());

                    tmpProduct = new Percussion(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    dateDiscountStart.getValue(),
                                    dateDiscountEnd.getValue(),
                                    validatedDiscount,
                                    validatedWeight,
                                    textBrand.getText(),
                                    textModel.getText(),
                                    validatedGuarantee,
                                    checkDigital.isSelected(),
                                    checkIsSetComplete.isSelected());
                    break;
                case "Sound system":
                    validatedDiscount = Validation.stringToInt(textDiscount.getText());
                    validatedWeight = Validation.stringToFloat(textWeight.getText());
                    validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                    validatedMinBandwidth = Validation.stringToInt(textMinBandwidth.getText());
                    validatedMaxBandwidth = Validation.stringToInt(textMaxBandwidth.getText());

                    tmpProduct = new SoundSystem(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    dateDiscountStart.getValue(),
                                    dateDiscountEnd.getValue(),
                                    validatedDiscount,
                                    validatedWeight,
                                    textBrand.getText(),
                                    textModel.getText(),
                                    validatedGuarantee,
                                    checkDigital.isSelected(),
                                    validatedMinBandwidth,
                                    validatedMaxBandwidth);
                    break;
                case "Speakers":
                    validatedDiscount = Validation.stringToInt(textDiscount.getText());
                    validatedWeight = Validation.stringToFloat(textWeight.getText());
                    validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                    validatedMinBandwidth = Validation.stringToInt(textMinBandwidth.getText());
                    validatedMaxBandwidth = Validation.stringToInt(textMaxBandwidth.getText());
                    validatedRms = Validation.stringToInt(textRMS.getText());
                    validatedImpedance = Validation.stringToInt(textImpedance.getText());

                    tmpProduct = new Speaker(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    dateDiscountStart.getValue(),
                                    dateDiscountEnd.getValue(),
                                    validatedDiscount,
                                    validatedWeight,
                                    textBrand.getText(),
                                    textModel.getText(),
                                    validatedGuarantee,
                                    checkDigital.isSelected(),
                                    validatedMinBandwidth,
                                    validatedMaxBandwidth,
                                    validatedRms,
                                    validatedImpedance);
                    break;
                case "Mic":
                    validatedDiscount = Validation.stringToInt(textDiscount.getText());
                    validatedWeight = Validation.stringToFloat(textWeight.getText());
                    validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                    validatedMinBandwidth = Validation.stringToInt(textMinBandwidth.getText());
                    validatedMaxBandwidth = Validation.stringToInt(textMaxBandwidth.getText());
                    validatedSensitivity = Validation.stringToInt(textSensitivity.getText());

                    tmpProduct = new Mic(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    dateDiscountStart.getValue(),
                                    dateDiscountEnd.getValue(),
                                    validatedDiscount,
                                    validatedWeight,
                                    textBrand.getText(),
                                    textModel.getText(),
                                    validatedGuarantee,
                                    checkDigital.isSelected(),
                                    validatedMinBandwidth,
                                    validatedMaxBandwidth,
                                    validatedSensitivity);
                    break;
                case "Console":
                    validatedDiscount = Validation.stringToInt(textDiscount.getText());
                    validatedWeight = Validation.stringToFloat(textWeight.getText());
                    validatedGuarantee = Validation.stringToInt(textGuarantee.getText());
                    validatedMaxPower = Validation.stringToInt(textMaxPower.getText());
                    validatedChannels = Validation.stringToInt(textChannels.getText());
                    validatedBitsProcessor = Validation.stringToInt(textBitsOfProcessor.getText());

                    tmpProduct = new Consoles(textName.getText(),
                                    validatedPrice,
                                    textDescription.getText(),
                                    imageProduct,
                                    dateDiscountStart.getValue(),
                                    dateDiscountEnd.getValue(),
                                    validatedDiscount,
                                    validatedWeight,
                                    textBrand.getText(),
                                    textModel.getText(),
                                    validatedGuarantee,
                                    checkDigital.isSelected(),
                                    validatedMaxPower,
                                    validatedChannels,
                                    validatedBitsProcessor);
                    break;
                default:
                    tmpProduct = new Product("Error", null, null, null);
            }
            // TODO: Create better way to decide between adding and editing
            if (indexOfEditing > -1) {
                Must.listOfProducts.remove(indexOfEditing);
                Must.listOfProducts.add(indexOfEditing, tmpProduct);
            } else
                Must.listOfProducts.add(tmpProduct);
        }
    }

    private boolean isRequiredInformationMissing() {
        boolean isMissing = false;
        // Name
        if (textName.getText() == null || textName.getText().trim().isEmpty()) {
            textName.setStyle("-fx-text-box-border: red;");
            isMissing = true;
        } else {
            textName.setStyle("-fx-text-box-border: lightgray;");
        }

        // Price
        if (textPrice.getText() == null || textPrice.getText().trim().isEmpty()) {
            textPrice.setStyle("-fx-text-box-border: red;");
            isMissing = true;
        } else {
            textPrice.setStyle("-fx-text-box-border: lightgray;");
        }

        // Duration
        if ((textDuration.getText() == null || textDuration.getText().trim().isEmpty()) && !textDuration.isDisabled()) {
            textDuration.setStyle("-fx-text-box-border: red;");
            isMissing = true;
        } else {
            textDuration.setStyle("-fx-text-box-border: lightgray;");
        }

        // Discount between 5-50%
        if (!textDiscount.getText().equals(""))
            if (Integer.parseInt(textDiscount.getText()) < 5 || Integer.parseInt(textDiscount.getText()) > 50) {
                textDiscount.setStyle("-fx-text-box-border: red;");
                isMissing = true;
            } else
                textDiscount.setStyle("-fx-text-box-border: lightgray;");
        else
            textDiscount.setStyle("-fx-text-box-border: lightgray;");

        return isMissing;
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
        dateDiscountStart.setDisable(true);
        dateDiscountEnd.setDisable(true);
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
    // TODO: Refactor like in MainController.fillDetailOfProduct
    // TODO: Add DatePickers to refactored activators
    private void activateProduct() {
        textName.setDisable(false);
        textPrice.setDisable(false);
        textDescription.setDisable(false);
    }

    private void activateService() {
        textDuration.setDisable(false);
    }

    private void activateInstrument() {
        dateDiscountStart.setDisable(false);
        dateDiscountEnd.setDisable(false);
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

    public void buttonPictureClicked() {
        imageProduct = openPictureDialog();
        if (imageProduct != null)
            labelPicture.setText("Image chosen");
    }

    /**
     * Opens a dialog to choose picture.
     * @return Returns a Image of the chosen file.
     */
    private Image openPictureDialog() {
        Image image;

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a picture");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("GIF", "*.gif")
        );
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            image = new Image(file.toURI().toString());
            return image;
        }
        return null;
    }
}
