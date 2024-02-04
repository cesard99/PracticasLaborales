package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginC {
    private Stage stage;

    @FXML
    private Button ButtonAcept;

    @FXML
    private Button ButtonCancel;

    @FXML
    void CloseWindows(ActionEvent event) {
        this.stage.close();

    }

    @FXML
    void WindowsPrincipal(ActionEvent event) {

    }

    public void setStage(Stage primaryStage) {
        this.stage=primaryStage;
    }

}
