package Controller;

import java.security.Principal;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginC {
    private Stage stage;

    @FXML
    private Button ButtonAcept;

    @FXML
    private Button ButtonCancel;
      @FXML
    private PasswordField textfieldpass;

    @FXML
    private TextField textfielduser;

    @FXML
    void CloseWindows(ActionEvent event) {
        this.stage.close();

    }

    @FXML
    void WindowsPrincipal(ActionEvent event) {
        if(verify()){
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(LoginC.class.getResource(/view/Principal.fxml));
        }

    }

    public void setStage(Stage primaryStage) {
        this.stage=primaryStage;
    }



    public boolean verify(){
       boolean bandera=false;
        if(!textfieldpass.getText().isEmpty() && !textfielduser.getText().isEmpty()){
            if(textfieldpass.getText().equals("cesar123") && textfielduser.getText().equals("Cesar")){
                bandera=true;
            }else{
                JOptionPane.showMessageDialog(null,"Los datos introduccidos no son correctos");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Los campos no estan llenos");
        }

        return bandera;
    }

}
