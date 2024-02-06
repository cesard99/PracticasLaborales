import Controller.LoginC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{

    @Override

    public void start(Stage primaryStage)throws Exception{
        try{

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/view/Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            LoginC controller =loader.getController();
            controller.setStage(primaryStage);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ventana Login");
            primaryStage.show();

        
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String [] args){
       launch(args);
    }

}
