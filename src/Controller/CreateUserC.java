package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateUserC {
    private PrincipalC principalController;
    private Stage stage;

    @FXML
    private Button ButonCancel;

    @FXML
    private Button ButonCreate;

    @FXML
    private TextField textfieldPass;

    @FXML
    private TextField textfieldUser;

    @FXML
    void AddUser(ActionEvent event) {

    }

    @FXML
    void ClosedAndOpenPrincipalWindows(ActionEvent event) {
        principalController.show();
        this.stage.close();

    }

    public void init(Stage stage2, PrincipalC principalC) {
        this.stage=stage2;
        principalController=principalC;
    }
}
