package utils.Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalC {
    Stage stage = new Stage();
    LoginC controller = new LoginC();

    @FXML
    private Button ButtonAlice;

    @FXML
    private Label lbluser;

    @FXML
    private Button ButtonCreateAdmin;

    @FXML
    private Button ButtonCreateUser;

    @FXML
    private Button ButtonDisconect;

    @FXML
    private AnchorPane VentanaP;
    String nombreuser;



    @FXML
    void CallVerifySignature(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/view/VentanaVerificar.fxml"));
       Parent root = loader.load();
       VentanaVerificar controller = loader.getController();
       Scene scene= new Scene(root);
       Stage stage = new Stage();
       scene.getStylesheets().add(getClass().getResource("/visual/Style/ventanaVerify.css").toExternalForm());
       stage.setScene(scene);
       stage.setTitle("Ventana Verificar Firma");
       Image icon = new Image("/Img/firma.jpg");
       stage.getIcons().add(icon);
       controller.init(stage,this);
       stage.show();
       this.stage.close();
        

    }

    @FXML
    void CallFirmGenerate(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/view/VentanaFirma.fxml"));
        Parent root = loader.load();
        VentanaFirma ventana = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add(getClass().getResource("/visual/Style/ventanaFirma.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Ventana de Firma");
        Image icon = new Image("/Img/firma.jpg");
        stage.getIcons().add(icon);
        ventana.inicio(stage,nombreuser,this);
        stage.show();
        this.stage.close();
        

    }

    @FXML
    void ClosedThisWindows(ActionEvent event) {
        controller.RestartTextFields();
        controller.show();
        this.stage.close();

    }

    public void init(Stage stage,String nombre,LoginC loginC) {
        this.stage = stage;
        lbluser.setText( "Usuario:"+ nombre);
        this.nombreuser=nombre;
        controller= loginC;

    }

    public void show() {
        this.stage.show();
    }


    
}
