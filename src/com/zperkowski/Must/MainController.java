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
    TreeView<String> treeProducts;
    @FXML
    TreeView<String> treeServices;

    private TreeItem<String> rootProducts = new TreeItem<>("root");
    private TreeItem<String> rootServices = new TreeItem<>("Services");
    private TreeItem<String> itemProducts = new TreeItem<>("Products");
    private TreeItem<String> itemInstruments = new TreeItem<>("Instruments");
    private TreeItem<String> itemGuitars = new TreeItem<>("Guitar");
    private TreeItem<String> itemKeyboards = new TreeItem<>("Keyboards");
    private TreeItem<String> itemPercussions = new TreeItem<>("Percussions");
    private TreeItem<String> itemSoundsSystems = new TreeItem<>("Sounds Systems");
    private TreeItem<String> itemSpeakers = new TreeItem<>("Speakers");
    private TreeItem<String> itemMics = new TreeItem<>("Mics");
    private TreeItem<String> itemConsoles = new TreeItem<>("Consoles");


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
            TreeItem<String> item = new TreeItem<>(Must.listOfProducts.get(i).getName());

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