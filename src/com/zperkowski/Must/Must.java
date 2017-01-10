package com.zperkowski.Must;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

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

    static ArrayList<Product> listOfProducts = new ArrayList<>();

    /**
     * Method looks for the {@param product} in static listOfProducts and returns index of this {@param product} in the array.
     * @param product A Product you're looking for.
     * @return Returns a index of the looking Product for. If the product doesn't exists in the list returns -1.
     */
    static int searchInListOfProducts(Product product) {
        for(Product item : listOfProducts){
            if(item.getName() != null && item.getName().equals(product.getName()))
                if (item.getPrice() != null && item.getPrice().equals(product.getPrice()))
                    if (item.getDescription() != null && item.getDescription().equals(product.getDescription()))
                        if (item.getImage() == product.getImage())
                            return listOfProducts.indexOf(item);
        }
        return -1;
    }

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
