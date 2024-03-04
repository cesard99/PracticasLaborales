package utils.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VentanaVerificar {
    PrincipalC controller = new PrincipalC();
    Stage stage= new Stage();

    @FXML
    private Button ButtonCancelar;

    @FXML
    private Button ButtonVerificar;

    @FXML
    private Label lblPosibilidad;

    @FXML
    private TextField textfieldText;

    @FXML
    void ClosedWindows(ActionEvent event) {
        this.stage.close();
        controller.show();

    }

    @FXML
    void verificarFirma(ActionEvent event) {

    }

    public void init(Stage stage, PrincipalC principalC) {
        this.stage=stage;
        controller=principalC;
    }

}
