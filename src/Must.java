import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Must extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Music Store");
        BorderPane borderPane = new BorderPane();
        primaryStage.setScene(new Scene(borderPane, 400, 600));

        // Menu of application
        MenuBar menuBar = new MenuBar();
        // File menu
        Menu fileMenu = new Menu("File");
        // Exit item in File menu
        MenuItem exitFileMenu = new MenuItem("Exit");
        exitFileMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        fileMenu.getItems().add(exitFileMenu);
        // About menu label for clicking handler
        Label aboutMenuLabel = new Label("About");
        aboutMenuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                About.display();
            }
        });
        Menu aboutMenu = new Menu();
        aboutMenu.setGraphic(aboutMenuLabel);
        // Adding menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, aboutMenu);


        borderPane.setTop(menuBar);


        primaryStage.show();
    }
}
