package utils.Controller;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.dto.FirmaDigital_DTO;
import utils.service.DigitalSignature;
import utils.service.FirmaDigital_Service;
import utils.service.KeyGeneration;
import utils.service.ServicesLocator;

public class VentanaFirma {
    PrincipalC controller = new PrincipalC();
    Stage stage = new Stage();
    KeyGeneration llavesGeneradas = new KeyGeneration();
    DigitalSignature firmarDigitalmente = new DigitalSignature();
    String publickeyString;
    String privateKeyString;
    String textoFirmado;
    private FirmaDigital_Service firmaDigital_Service=ServicesLocator.getFirmaDigital_Service();
    private FirmaDigital_DTO firmaDigital;
    LoginC controlLogin = new LoginC();
    int nombreuser;

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
    void callGenerateFirm(ActionEvent event) throws Exception {
        System.out.println(nombreuser);
        String text= textfieldText.getText();
        //Genera las dos claves (privada y publica )
        PublicKey publickey= llavesGeneradas.generatePublicKey();
        PrivateKey privateKey=llavesGeneradas.generatePrivateKey2();

        // Combierte las claves a String
        privateKeyString=llavesGeneradas.privateKeyToString(privateKey);
        publickeyString=llavesGeneradas.publicKeyToString(publickey);

        //Fimra el texto y lo muestra
        textoFirmado=firmarDigitalmente.signText(text, privateKey);
         ShowFirm(textoFirmado);

    }

    @FXML
    void callSaveInBD(ActionEvent event) {
        try {
            firmaDigital_Service.insertText(textfieldText.getText(),textoFirmado , nombreuser,privateKeyString ,publickeyString);
            this.stage.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        


    }

    public void inicio(Stage stage, String nombre ,PrincipalC principalC) {
       this.stage= stage;
       controller=principalC;
       
    }
    
    public void ShowFirm(String text){
        lblShowFirm.setText(text);
        lblShowFirm.setWrapText(true);
        
    }

    




}
