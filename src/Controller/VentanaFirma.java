package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VentanaFirma {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Button prueba;

    @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    void ShowNexText(ActionEvent event) {
        lbl2.setVisible(true);
        textfield2.setVisible(true);
        button2.setVisible(true);

    }

}
