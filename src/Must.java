import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Must extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Music Store");
        StackPane stackPane = new StackPane();
        primaryStage.setScene(new Scene(stackPane, 400, 600));
        primaryStage.show();
    }
}
