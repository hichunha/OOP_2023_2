package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI3_4_Controller implements Initializable {
    SwitchScene switchScene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchScene = new SwitchScene();
    }
    public void ImportQuestionsFromFile(ActionEvent e) throws IOException{
        switchScene.changeButton(e,"/views/GUI3_4_Import.fxml");
    }
}