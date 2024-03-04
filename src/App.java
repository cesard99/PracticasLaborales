import utils.Controller.*;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

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
