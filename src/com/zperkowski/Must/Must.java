package com.zperkowski.Must;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <p>
 * A <b>Mu</b>sic <b>St</b>ore application - <b>Must</b>.
 * </p><p>
 * This is a University project for the subject Object Orientated Programming.
 * </p>
 * This class starts the JavaFX application.
 *
 * @author Zdzisław Perkowski
 * @version 1.0
 * */
public class Must extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Music Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(615);
        primaryStage.setMinHeight(630);
        primaryStage.show();
    }
}
