package com.zperkowski.Must;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class is a controller for the main window.
 * The main window layout is set in main.fxml.
 */
public class MainController {

    @FXML
    MenuItem menuItemRemove;

    @FXML
    Tab tabProducts;
    @FXML
    Tab tabServices;

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

    // All tab
    @FXML TableView tableAll;
    @FXML TableColumn tableColName;
    @FXML TableColumn tableColBrand;
    @FXML TableColumn tableColModel;
    @FXML TableColumn tableColPrice;
    @FXML TableColumn tableColDuration;
    @FXML TableColumn tableColDiscount;
    @FXML TableColumn tableColWeight;
    @FXML TableColumn tableColGuarantee;
    @FXML TableColumn tableColDigital;
    @FXML TableColumn tableColStrings;
    @FXML TableColumn tableColFrets;
    @FXML TableColumn tableColType;
    @FXML TableColumn tableColKeys;
    @FXML TableColumn tableColComplete;
    @FXML TableColumn tableColMinBandwidth;
    @FXML TableColumn tableColMaxBandwidth;
    @FXML TableColumn tableColRMS;
    @FXML TableColumn tableColImpedance;
    @FXML TableColumn tableColSensitivity;
    @FXML TableColumn tableColMaxPower;
    @FXML TableColumn tableColChannels;
    @FXML TableColumn tableColBitsOfProcessor;

    @FXML TextField textSearch;

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
                    canBeRemoved(newValue);
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
                    canBeRemoved(newValue);
                    clearDetails();
                    fillDetailOfProduct( (Service) newValue.getValue());
                }
            }
        );

        // Set TableView
        tableColName.setCellValueFactory(
                new PropertyValueFactory<Product,String>("name")
        );
         tableColBrand.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("brand")
         );
         tableColModel.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("model")
         );
         tableColPrice.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("price")
         );
         tableColDuration.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("durationInHours")
         );
         tableColDiscount.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("discount")
         );
         tableColWeight.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("weight")
         );
         tableColGuarantee.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("guaranteeInMonths")
         );
         tableColDigital.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("guaranteeInMonths")
         );
         tableColStrings.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("strings")
         );
         tableColFrets.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("frets")
         );
         tableColType.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("type")
         );
         tableColKeys.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("keys")
         );
         tableColComplete.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("isSetComplete")
         );
         tableColMinBandwidth.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("minBandwidth")
         );
         tableColMaxBandwidth.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("maxBandwidth")
         );
         tableColRMS.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("rms")
         );
         tableColImpedance.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("impedance")
         );
         tableColSensitivity.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("sensitivity")
         );
         tableColMaxPower.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("maxPower")
         );
         tableColChannels.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("channels")
         );
         tableColBitsOfProcessor.setCellValueFactory(
                 new PropertyValueFactory<Product,String>("bitsProcessor")
         );
    }

    public void addProduct() {
        Must.indexOfSelectedItem = -1;
        displayModifier();
    }

    public void editProduct() {
        if (tabProducts.isSelected())
            Must.indexOfSelectedItem = Must.searchInListOfProducts(treeProducts.getSelectionModel().getSelectedItems().get(0).getValue());
        else if (tabServices.isSelected())
            Must.indexOfSelectedItem = Must.searchInListOfProducts(treeServices.getSelectionModel().getSelectedItems().get(0).getValue());
        displayModifier();
    }

    public void removeProduct() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove a product");
        alert.setHeaderText("Do you want to remove selected product?");
        Optional confirmation = alert.showAndWait();
        if (confirmation.get() == ButtonType.OK) {
            int index;
            if (tabProducts.isSelected())
                for (int i = 0; i < treeProducts.getSelectionModel().getSelectedItems().size(); i++) {
                    index = Must.searchInListOfProducts(treeProducts.getSelectionModel().getSelectedItems().get(i).getValue());
                    if (index > -1)
                        Must.listOfProducts.remove(index);
                }
            else if (tabServices.isSelected())
                for (int i = 0; i < treeServices.getSelectionModel().getSelectedItems().size(); i++) {
                    index = Must.searchInListOfProducts(treeServices.getSelectionModel().getSelectedItems().get(i).getValue());
                    if (index > -1)
                        Must.listOfProducts.remove(index);
                }
            update();
        }
    }

    private void canBeRemoved(TreeItem<Product> newValue) {
        if (newValue.getValue().getPrice() != null)
            menuItemRemove.setDisable(false);
        else
            menuItemRemove.setDisable(true);
    }

    private void displayModifier() {
        try {
            Parent parentModifier = FXMLLoader.load(getClass().getResource("modifier.fxml"));
            Stage stageModifier = new Stage();
            stageModifier.setScene(new Scene(parentModifier));
            stageModifier.setTitle("Add a product");
            stageModifier.setMinHeight(505);
            stageModifier.setMinWidth(430);
            stageModifier.show();
            stageModifier.setOnCloseRequest(event -> update());
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

    public void saveApp() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as...");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".must", "*.must"));
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            try {
                ObjectOutputStream outFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file.getAbsoluteFile())));
                outFile.writeObject(Must.listOfProducts);
                outFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openApp() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".must", "*.must"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            try {
            ObjectInputStream inFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file.getAbsoluteFile())));
            Must.listOfProducts = (ArrayList) inFile.readObject();
                inFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        update();
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

    public void update() {
        if (textSearch.getText().trim() == "") {
            updateTrees(Must.listOfProducts);
            updateTables(Must.listOfProducts);
        } else {
            ObservableList<Product> observableList = FXCollections.observableList(Must.listOfProducts);
            FilteredList<Product> filteredList = new FilteredList<>(observableList, s -> true);

            String filter = textSearch.getText().trim();
            if(filter == null || filter.length() == 0) {
                filteredList.setPredicate(s -> true);
            }
            else {
                filteredList.setPredicate(s -> s.getName().contains(filter));
            }

            updateTables(filteredList);
            updateTrees(filteredList);
        }
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

    private void updateTrees(List<Product> list) {
        clearTrees();

        for (int i = 0; i < list.size(); i++) {
            TreeItem<Product> item = new TreeItem<>(list.get(i));

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

    public void updateTables(List<Product> list) {
        ObservableList<Product> observableList = FXCollections.observableArrayList();
        observableList.addAll(list);
        tableAll.setItems(observableList);
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