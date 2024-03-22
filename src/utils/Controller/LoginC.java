package utils.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.dto.Registrer_DTO;
import utils.service.Registrer_Services;
import utils.service.ServicesLocator;
import javafx.scene.image.Image;


public class LoginC {
    private Stage stage;

    @FXML
    private Button ButtonAcept;
    @FXML
    private Label lblError;

    @FXML
    private Button ButtonCancel;
      @FXML
    private PasswordField textfieldpass;

    @FXML
    private TextField textfielduser;
    private Registrer_Services registrer_Services = ServicesLocator.getRegistrer_Services();
	private ArrayList<Registrer_DTO> listaUsuarios;
	private Registrer_DTO user;
    



    @FXML
    void CloseWindows(ActionEvent event) {
        this.stage.close();


    }

    @FXML
    void WindowsPrincipal(ActionEvent event) throws Exception {
          if (verify()){
               System.out.println(user.getName());
               
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/view/Principal.fxml"));
                Parent root = loader.load();
                PrincipalC  controller= loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                scene.getStylesheets().add(getClass().getResource("/visual/Style/Principal.css").toExternalForm());
                stage.setScene(scene);
                Image icon = new Image("/Img/ImagenCodigo2.png");
                stage.setTitle("Ventana Principal");
                stage.getIcons().add(icon);
                controller.init(stage,user.getName(), this);
                stage.show();
                this.stage.close();
        }
        


    }

    public void setStage(Stage primaryStage) {
        this.stage=primaryStage;
    }
     


    public boolean verify() throws ClassNotFoundException, SQLException, IOException{
       boolean bandera=false;
          listaUsuarios = ServicesLocator.getRegistrer_Services().selectAllUsers();          
             for(int i=0 ; i<listaUsuarios.size() && !bandera ; i++ ){
                Registrer_DTO u = listaUsuarios.get(i);
                if(u.getName().equals(textfielduser.getText())){
                    String pass = Encription.decode(Definicion.SECRET_KEY_PASSWORD, u.getPss());
                    if(pass.equals(textfieldpass.getText())){
                        user=u;
                        bandera=true;
                    }else{
                       lblError.setText("La contraseña es incorrecta");
                       lblError.setVisible(true);
                    }
                }else{
                    lblError.setText("El nombre es incorrecto");
                    lblError.setVisible(true);
                }
            }
       
          if(!bandera){ // si la bandera es true el significa que existe el usuario y si la bandera sigue en false entra en este if 
            throw new IllegalArgumentException("El usuario no se encuentra en la Base de Datos");
          }
        

        return bandera;
    }

  

    public void show() {
        stage.show();

    }


    public void RestartTextFields() {
        textfieldpass.setText("");
        textfielduser.setText("");
        lblError.setVisible(false);

    }

    

    
}
