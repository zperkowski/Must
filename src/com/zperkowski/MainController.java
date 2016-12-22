package com.zperkowski;

/**
 * This class is a controller for the main window.
 * The main window layout is set in main.fxml.
 */
public class MainController {

    public void closeApp() {
        System.exit(0);
    }

    public void showAbout() {
        About.display();
    }
}