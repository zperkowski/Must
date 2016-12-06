import javafx.scene.control.Alert;

public class About {
    public static void display() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Music Store Application");
        alert.setContentText("Author: Zdzisław Perkowski");

        alert.showAndWait();
    }
}
