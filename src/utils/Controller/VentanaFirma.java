package utils.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VentanaFirma {
    PrincipalC controller = new PrincipalC();
    Stage stage = new Stage();

    @FXML
    private Button ButtonCancelar;

    @FXML
    private Button ButtonGenerate;

    @FXML
    private Button ButtonSave;

    @FXML
    private Label label2;

    @FXML
    private Label lbl1;
    @FXML
    private Label lblShowFirm;

    @FXML
    private TextField textfieldText;

    @FXML
    private TextField textfield2;

    @FXML
    void ClosedWindows(ActionEvent event) {
        this.stage.close();
        controller.show();
    }

    @FXML
    void callGenerateFirm(ActionEvent event) {

    }

    @FXML
    void callSaveInBD(ActionEvent event) {

    }

    public void inicio(Stage stage, PrincipalC principalC) {
       this.stage= stage;
       controller=principalC;
    }

}
