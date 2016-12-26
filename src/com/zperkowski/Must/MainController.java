package com.zperkowski.Must;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is a controller for the main window.
 * The main window layout is set in main.fxml.
 */
public class MainController {

    public void displayModifier() {
        try {
            Parent parentModifier = FXMLLoader.load(getClass().getResource("modifier.fxml"));
            Stage stageModifier = new Stage();
            stageModifier.setScene(new Scene(parentModifier));
            stageModifier.setTitle("Add a product");
            stageModifier.setMinHeight(505);
            stageModifier.setMinWidth(430);
            stageModifier.show();
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
}