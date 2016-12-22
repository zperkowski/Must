package com.zperkowski;

import javafx.scene.control.Alert;

/**
 * This class displays a window with information about the author and current version.
 */
public class About {
    /**
     * This static method displays a window with the information.
     */
    public static void display() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Music Store Application");
        alert.setContentText("Author: Zdzisław Perkowski\n" +
                            "Version: 1.0");

        alert.showAndWait();
    }
}
