package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class Controller {
    LoginC controladorLogin = new LoginC();


    public void showWindow1() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        LoginC controller =loader.getController();
        Stage stage = new Stage();
        controller.setStage(stage);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/Style/Login.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Ventana Login");
        Image icon = new Image("/Img/ImagenVentanaLogin.jpg");
        stage.getIcons().add(icon);
        stage.show();
    }

}
