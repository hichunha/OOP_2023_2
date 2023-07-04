package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI2_1_Controller implements Initializable {
    SwitchScene switchScene;
    @FXML
    Line line;
    @FXML
    AnchorPane AchorPane2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchScene = new SwitchScene();

    }


    public void btnNewQuestion(ActionEvent e) throws IOException {
        switchScene.changeButton(e,"/views/GUI3_2.fxml");
    }
    public void AddCategory(ActionEvent e) throws IOException{
        switchScene.changeButton(e,"/views/GUI3_3.fxml");
    }

    public void SelectACategory(ActionEvent e) throws IOException{
        switchScene.changeMenuItem(e,"/views/GUI3_1.fxml");
    }

    public void IMPORT(ActionEvent e) throws IOException{
        switchScene.changeButton(e,"/views/GUI3_4.fxml");
    }

    public void CheckQuestionSubcategories(ActionEvent e) throws IOException {
        switchScene.changeBox(e,"/views/GUI3_1.fxml");
    }
}
