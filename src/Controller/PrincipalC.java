package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PrincipalC {
    private Stage stage;
    private LoginC controllerLogin;

    @FXML
    private Button ButtonCreateUser;

    @FXML
    private Button ButtonDisconect;



    @FXML
    void CallCreateUserWindows(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CreateUser.fxml"));
            Parent root = loader.load();
            CreateUserC controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage2 = new Stage();
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/Style/CreateUser.css")).toExternalForm());
            stage2.setScene(scene);
            stage2.setTitle("Ventana Create User");
            Image icon = new Image("/Img/iconCreateUser.png");
            stage2.getIcons().add(icon);

            controller.init(stage2,this);
            stage2.show();
            this.stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void ClosedThisWindows(ActionEvent event) {
        controllerLogin.show();
        controllerLogin.RestartTextFields();
        stage.close();

    }

    public void init(Stage stage, LoginC loginC) {
        this.stage=stage;
        controllerLogin=loginC;

    }

    public void show() {
        this.stage.show();
    }
}
