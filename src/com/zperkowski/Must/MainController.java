package com.zperkowski.Must;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is a controller for the main window.
 * The main window layout is set in main.fxml.
 */
public class MainController {

    @FXML
    TreeView<Product> treeProducts;
    @FXML
    TreeView<Product> treeServices;

    // Product tab
    @FXML Label titleProduct;
    @FXML ImageView imageProduct;
    @FXML TextField textProductName;
    @FXML TextField textProductPrice;
    @FXML TextField textProductBrand;
    @FXML TextField textProductModel;
    @FXML TextField textProductType;
    @FXML TextField textProductWeight;
    @FXML TextField textProductGuarantee;
    @FXML CheckBox checkProductDigital;
    @FXML CheckBox checkProductIsSetComplete;
    @FXML TextField textProductDiscount;
    @FXML TextField textProductStrings;
    @FXML TextField textProductFrets;
    @FXML TextField textProductKeys;
    @FXML TextField textProductMinBandwidth;
    @FXML TextField textProductMaxBandwidth;
    @FXML TextField textProductImpedance;
    @FXML TextField textProductRMS;
    @FXML TextField textProductSensitivity;
    @FXML TextField textProductMaxPower;
    @FXML TextField textProductChannels;
    @FXML TextField textProductBitsOfProcessor;
    @FXML TextField textProductDescription;

    // Service tab
    @FXML Label titleService;
    @FXML ImageView imageService;
    @FXML TextField textServicePrice;
    @FXML TextField textServiceDuration;
    @FXML TextField textServiceDescription;

    private TreeItem<Product> rootProducts = new TreeItem<>(new Product("root", null, null, null));
    private TreeItem<Product> rootServices = new TreeItem<>(new Service("Services", null, null, null, 0));
    private TreeItem<Product> itemProducts = new TreeItem<>(new Product("Products", null, null, null));
    private TreeItem<Product> itemInstruments = new TreeItem<>(new Product("Instruments", null, null, null));
    private TreeItem<Product> itemGuitars = new TreeItem<>(new Product("Guitar", null, null, null));
    private TreeItem<Product> itemKeyboards = new TreeItem<>(new Product("Keyboards", null, null, null));
    private TreeItem<Product> itemPercussions = new TreeItem<>(new Product("Percussions", null, null, null));
    private TreeItem<Product> itemSoundsSystems = new TreeItem<>(new Product("Sounds Systems", null, null, null));
    private TreeItem<Product> itemSpeakers = new TreeItem<>(new Product("Speakers", null, null, null));
    private TreeItem<Product> itemMics = new TreeItem<>(new Product("Mics", null, null, null));
    private TreeItem<Product> itemConsoles = new TreeItem<>(new Product("Consoles", null, null, null));


    @FXML
    public void initialize() {
        initTreeProducts();
        initTreeServices();

        treeProducts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Product>>() {
                @Override
                public void changed(ObservableValue<? extends TreeItem<Product>> observable, TreeItem<Product> oldValue, TreeItem<Product> newValue) {
                    clearDetails();
                    switch (newValue.getValue().getClass().getName()) {
                        case "com.zperkowski.Must.Product":
                            fillDetailOfProduct(newValue.getValue());
                            break;
                        case "com.zperkowski.Must.Instrument":
                            fillDetailOfProduct((Instrument) newValue.getValue());
                            break;
                        case "com.zperkowski.Must.Guitar":
                            fillDetailOfProduct((Guitar) newValue.getValue());
                            break;
                        case "com.zperkowski.Must.Keyboard":
                            fillDetailOfProduct((Keyboard) newValue.getValue());
                            break;
                        case "com.zperkowski.Must.Percussion":
                            fillDetailOfProduct((Percussion) newValue.getValue());
                            break;
                        case "com.zperkowski.Must.SoundSystem":
                            fillDetailOfProduct((SoundSystem) newValue.getValue());
                            break;
                        case "com.zperkowski.Must.Speaker":
                            fillDetailOfProduct((Speaker) newValue.getValue());
                            break;
                        case "com.zperkowski.Must.Mic":
                            fillDetailOfProduct((Mic) newValue.getValue());
                            break;
                        case "com.zperkowski.Must.Consoles":
                            fillDetailOfProduct((Consoles) newValue.getValue());
                            break;
                    }
                }
            }
        );

        treeServices.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Product>>() {
                @Override
                public void changed(ObservableValue<? extends TreeItem<Product>> observable, TreeItem<Product> oldValue, TreeItem<Product> newValue) {
                    clearDetails();
                    fillDetailOfProduct( (Service) newValue.getValue());
                }
            }
        );
    }

    public void displayModifier() {
        try {
            Parent parentModifier = FXMLLoader.load(getClass().getResource("modifier.fxml"));
            Stage stageModifier = new Stage();
            stageModifier.setScene(new Scene(parentModifier));
            stageModifier.setTitle("Add a product");
            stageModifier.setMinHeight(505);
            stageModifier.setMinWidth(430);
            stageModifier.show();
            stageModifier.setOnCloseRequest(event -> updateTrees());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newApp() {
        Must.listOfProducts.clear();
        rootServices.getChildren().clear();
        itemProducts.getChildren().clear();
        itemInstruments.getChildren().clear();
        itemGuitars.getChildren().clear();
        itemKeyboards.getChildren().clear();
        itemSoundsSystems.getChildren().clear();
        itemSpeakers.getChildren().clear();
        itemMics.getChildren().clear();
        itemConsoles.getChildren().clear();
    }

    public void closeApp() {
        System.exit(0);
    }

    public void showAbout() {
        About.display();
    }

    private void initTreeProducts() {
        rootProducts.getChildren().addAll(
                itemProducts,
                itemInstruments,
                itemGuitars,
                itemKeyboards,
                itemPercussions,
                itemSoundsSystems,
                itemSpeakers,
                itemMics,
                itemConsoles
        );

        treeProducts.setRoot(rootProducts);
        treeProducts.setShowRoot(false);
    }

    private void initTreeServices() {
        treeServices.setRoot(rootServices);
        rootServices.setExpanded(true);
    }

    private void clearTrees() {
        rootServices.getChildren().clear();
        itemProducts.getChildren().clear();
        itemInstruments.getChildren().clear();
        itemGuitars.getChildren().clear();
        itemKeyboards.getChildren().clear();
        itemPercussions.getChildren().clear();
        itemSoundsSystems.getChildren().clear();
        itemSpeakers.getChildren().clear();
        itemMics.getChildren().clear();
        itemConsoles.getChildren().clear();
    }

    public void updateTrees() {
        clearTrees();

        for (int i = 0; i < Must.listOfProducts.size(); i++) {
            TreeItem<Product> item = new TreeItem<>(Must.listOfProducts.get(i));

            switch (Must.listOfProducts.get(i).getClass().getName()) {
                case "com.zperkowski.Must.Service":
                    rootServices.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.Product":
                    itemProducts.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.Instrument":
                    itemInstruments.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.Guitar":
                    itemGuitars.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.Keyboard":
                    itemKeyboards.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.Percussion":
                    itemPercussions.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.SoundSystem":
                    itemSoundsSystems.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.Speaker":
                    itemSpeakers.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.Mic":
                    itemMics.getChildren().add(item);
                    break;
                case "com.zperkowski.Must.Consoles":
                    itemConsoles.getChildren().add(item);
                    break;
            }
        }
    }

    private void clearDetails() {
        // Products tab
        titleProduct.setText("");
        imageProduct.setImage(null);
        textProductName.setText("");
        textProductPrice.setText("");
        textProductBrand.setText("");
        textProductModel.setText("");
        textProductType.setText("");
        textProductWeight.setText("");
        textProductGuarantee.setText("");
        checkProductDigital.setSelected(false);
        checkProductIsSetComplete.setSelected(false);
        textProductDiscount.setText("");
        textProductStrings.setText("");
        textProductFrets.setText("");
        textProductKeys.setText("");
        textProductMinBandwidth.setText("");
        textProductMaxBandwidth.setText("");
        textProductImpedance.setText("");
        textProductRMS.setText("");
        textProductSensitivity.setText("");
        textProductMaxPower.setText("");
        textProductChannels.setText("");
        textProductBitsOfProcessor.setText("");
        textProductDescription.setText("");

        // Services tab
        titleService.setText("");
        imageService.setImage(null);
        textServiceDuration.setText("");
        textServicePrice.setText("");
        textServiceDescription.setText("");
    }

    private void fillDetailOfProduct(Product product) {
        if (product.getPrice() != null) {
            titleProduct.setText(product.getName());
            textProductName.setText(product.getName());
            imageProduct.setImage(product.getImage());
            textProductPrice.setText(product.getPrice().toString());
            textProductDescription.setText(product.getDescription());
        }
    }

    private void fillDetailOfProduct(Instrument product) {
        if (product.getPrice() != null) {
            fillDetailOfProduct( (Product) product);
            textProductBrand.setText(product.getBrand());
            textProductModel.setText(product.getModel());
            textProductDiscount.setText(Integer.toString(product.getDiscount()));
            textProductWeight.setText(Float.toString(product.getWeight()));
            textProductGuarantee.setText(Integer.toString(product.getGuaranteeInMonths()));
            checkProductDigital.setSelected(product.isDigital());
        }
    }

    private void fillDetailOfProduct(Guitar product) {
        if (product.getPrice() != null) {
            fillDetailOfProduct( (Product) product);
            fillDetailOfProduct( (Instrument) product);
            textProductStrings.setText(Integer.toString(product.getStrings()));
            textProductFrets.setText(Integer.toString(product.getFrets()));
            textProductType.setText(product.getType());
        }
    }

    private void fillDetailOfProduct(Keyboard product) {
        if (product.getPrice() != null) {
            fillDetailOfProduct( (Product) product);
            fillDetailOfProduct( (Instrument) product);
            textProductKeys.setText(Integer.toString(product.getKeys()));
        }
    }

    private void fillDetailOfProduct(Percussion product) {
        if (product.getPrice() != null) {
            fillDetailOfProduct( (Product) product);
            fillDetailOfProduct( (Instrument) product);
            checkProductIsSetComplete.setSelected(product.isSetComplete());
        }
    }

    private void fillDetailOfProduct(SoundSystem product) {
        if (product.getPrice() != null) {
            fillDetailOfProduct( (Product) product);
            fillDetailOfProduct( (Instrument) product);
            textProductMinBandwidth.setText(Integer.toString(product.getMinBandwidth()));
            textProductMaxBandwidth.setText(Integer.toString(product.getMaxBandwidth()));
        }
    }

    private void fillDetailOfProduct(Speaker product) {
        if (product.getPrice() != null) {
            fillDetailOfProduct( (Product) product);
            fillDetailOfProduct( (Instrument) product);
            fillDetailOfProduct( (SoundSystem) product);
            textProductRMS.setText(Integer.toString(product.getRms()));
            textProductImpedance.setText(Integer.toString(product.getImpedance()));
        }
    }

    private void fillDetailOfProduct(Mic product) {
        if (product.getPrice() != null) {
            fillDetailOfProduct( (Product) product);
            fillDetailOfProduct( (Instrument) product);
            fillDetailOfProduct( (SoundSystem) product);
            textProductSensitivity.setText(Integer.toString(product.getSensitivity()));
        }
    }

    private void fillDetailOfProduct(Consoles product) {
        if (product.getPrice() != null) {
            fillDetailOfProduct( (Product) product);
            fillDetailOfProduct( (Instrument) product);
            textProductMaxPower.setText(Integer.toString(product.getMaxPower()));
            textProductChannels.setText(Integer.toString(product.getChannels()));
            textProductBitsOfProcessor.setText(Integer.toString(product.getBitsProcessor()));
        }
    }

    private void fillDetailOfProduct(Service product) {
        if (product.getPrice() != null) {
            titleService.setText(product.getName());
            imageService.setImage(product.getImage());
            textServicePrice.setText(product.getPrice().toString());
            textServiceDescription.setText(product.getDescription());
            textServiceDuration.setText(Integer.toString(product.getDurationInHours()));
        }
    }
}