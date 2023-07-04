package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI1_1_Controller implements Initializable {
    @FXML
    Label label;
    @FXML

    SwitchScene switchScene;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchScene = new SwitchScene();
    }

    public void btnQuestion(ActionEvent e) throws IOException{
        switchScene.changeMenuItem(e,"/views/GUI2_1.fxml");
    }


}
