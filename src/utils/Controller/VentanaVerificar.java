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
import utils.service.DigitalSignature;
import utils.service.FirmaDigital_Service;
import utils.service.KeyGeneration;
import utils.service.ServicesLocator;

public class VentanaVerificar {
    PrincipalC controller = new PrincipalC();
    Stage stage= new Stage();
    private FirmaDigital_Service firmaDigital_Service=ServicesLocator.getFirmaDigital_Service();
    KeyGeneration llavesgeneradas=new KeyGeneration();
    DigitalSignature firmartexto=new DigitalSignature();
    private PublicKey publicKey;
    private ArrayList<FirmaDigital_DTO>listafirmas;
    public FirmaDigital_DTO firma;
    private String Firma;
    private String llavePublica;

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
    void verificarFirma(ActionEvent event) throws Exception {
        
        
        if(encontrado()){
            String llavepublica=firma.getPublickey();
            String text= firma.getText();
            String firmat=firma.getFirma();
            publicKey=llavesgeneradas.stringToPublicKey(llavepublica);
            
            boolean firmaEncontrada=firmartexto.verifySignature(text, firmat , publicKey);
            if(firmaEncontrada){
                lblPosibilidad.setText("El texto esta firmado ");
                lblPosibilidad.setVisible(true);
            }else{
                lblPosibilidad.setText("El texto  esta firmado ");
                lblPosibilidad.setVisible(true);
            }
            

           

        }
        
        


    }

    public void init(Stage stage, PrincipalC principalC) {
        this.stage=stage;
        controller=principalC;
    }
     public boolean encontrado(){
        String text = textfieldText.getText();
        boolean bandera = false;
        String llaveEncontrada;
        
        try {
            listafirmas = firmaDigital_Service.selectAllTexts();
            for(int i = 0 ; i<listafirmas.size() && !bandera;i++){
                FirmaDigital_DTO f = listafirmas.get(i);
                if(f.getText().equals(text)){
                    llavePublica=f.getPublickey();
                   Firma =f.getFirma();
                    bandera=true;
                    firma=f;
                }
           



            }
        } catch (Exception e) {
           e.printStackTrace();
        }
         if(firma== null){
            throw new IllegalArgumentException("El texto no se encuentra en la base de datos");
         }

        return bandera;
     }


}
