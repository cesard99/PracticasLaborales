import Controller.LoginC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.util.Objects;


public class App extends Application{



    public void start(Stage primaryStage) {
        try{

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/view/Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            LoginC controller =loader.getController();
            controller.setStage(primaryStage);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/Style/Login.css")).toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ventana Login");
            Image icon = new Image("/Img/ImagenVentanaLogin.jpg");
            primaryStage.getIcons().add(icon);
            primaryStage.show();

        
        }catch(Exception e){
            e.fillInStackTrace();
        }

    }

    public static void main(String [] args){
       launch(args);
    }

}
