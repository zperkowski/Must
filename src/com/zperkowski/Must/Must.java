package com.zperkowski.Must;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Locale;

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
    static int indexOfSelectedItem = -1;

    /**
     * Method looks for a Product in the {@link #listOfProducts} and returns an index of this in the array.
     * @param product A Product you're looking for.
     * @return Returns an index of the Product searched for. If the product doesn't exist in the list, it returns -1.
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

    /**
     * The main method.
     * @param args - Arguments of the program.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts main window of the program
     * @param primaryStage The main stage of the program.
     * @throws Exception Throws Exception. Why not?
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(Locale.forLanguageTag("PL"));
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Music Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(615);
        primaryStage.setMinHeight(630);
        primaryStage.show();
    }
}
