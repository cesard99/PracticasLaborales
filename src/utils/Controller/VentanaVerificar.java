package utils.Controller;

import java.security.PublicKey;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.dto.FirmaDigital_DTO;
import utils.service.FirmaDigital_Service;
import utils.service.KeyGeneration;
import utils.service.ServicesLocator;

public class VentanaVerificar {
    PrincipalC controller = new PrincipalC();
    Stage stage= new Stage();
    private FirmaDigital_Service firmaDigital_Service=ServicesLocator.getFirmaDigital_Service();
    KeyGeneration llavesgeneradas=new KeyGeneration();
    private PublicKey publicKey;
    private ArrayList<FirmaDigital_DTO>listafirmas;

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
