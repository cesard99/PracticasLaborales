package utils.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalC {
    Stage stage = new Stage();
    LoginC controller = new LoginC();

    @FXML
    private Button ButtonAlice;

    @FXML
    private Button ButtonCreateAdmin;

    @FXML
    private Button ButtonCreateUser;

    @FXML
    private Button ButtonDisconect;

    @FXML
    private AnchorPane VentanaP;



    @FXML
    void CallVerifySignature(ActionEvent event) {

    }

    @FXML
    void CallFirmGenerate(ActionEvent event) {

    }

    @FXML
    void ClosedThisWindows(ActionEvent event) {
        controller.RestartTextFields();
        controller.show();
        this.stage.close();

    }

    public void init(Stage stage,LoginC loginC) {
        this.stage = stage;
        controller= loginC;

    }
}
