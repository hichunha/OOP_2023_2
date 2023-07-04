package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI3_2_Controller implements Initializable {

    SwitchScene switchScene;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchScene = new SwitchScene();
    }

    public void General (ActionEvent e) throws IOException{
        switchScene.changeButton(e,"/views/GUI3_2_General.fxml");
    }
}
