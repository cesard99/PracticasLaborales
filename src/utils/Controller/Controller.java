package utils.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utils.dto.Registrer_DTO;
import utils.service.Registrer_Services;
import utils.service.ServicesLocator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class Controller {
    private Registrer_Services registrer_Services = ServicesLocator.getRegistrer_Services();
	private ArrayList<Registrer_DTO> listaUsuarios;
     
    //SI no se encuentra el usuario introduce uno directamente en la base de datos
    LoginC controladorLogin = new LoginC();
        public void nouser(){

            try {
                listaUsuarios = ServicesLocator.getRegistrer_Services().selectAllUsers();
                if(listaUsuarios.size()==0){
                    registrer_Services.insertUser("Cesar", "cesar123");
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    public void showWindow1() throws IOException {
        nouser();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/visual/view/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        LoginC controller =loader.getController();
        Stage stage = new Stage();
        controller.setStage(stage);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/visual/Style/Login.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Ventana Login");
        Image icon = new Image("/Img/ImagenVentanaLogin.jpg");
        stage.getIcons().add(icon);
        stage.show();
    }

}
