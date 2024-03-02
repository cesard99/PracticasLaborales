import Controller.Controller;
import Controller.LoginC;
import Controller.Progress;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.Objects;


public class App extends Application{



    public void start(Stage primaryStage) throws IOException {
        Controller controller = new Controller();
        controller.showWindow1();

    }

    public static void main(String [] args){
        Progress frame = new Progress(null,null);
        frame.setVisible(true);
         launch(args);
    }

}
