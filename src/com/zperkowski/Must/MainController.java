package com.zperkowski.Must;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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

    private TreeItem<Product> rootProducts = new TreeItem<>(new Product("root", null, null, null));
    private TreeItem<Product> rootServices = new TreeItem<>(new Product("Services", null, null, null));
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
}