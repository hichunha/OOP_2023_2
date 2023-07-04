package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI3_1_Controller implements Initializable {

    @FXML
    VBox VboxQuestion;
    @FXML
    VBox VboxActions;

    private GUI3_2_General_Controller gui3_2_general_controller;

    SwitchScene switchScene;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchScene = new SwitchScene();
    }

    public void btnCreatANewQuestion(ActionEvent e) throws IOException {
        switchScene.changeButton(e,"/views/GUI3_2.fxml");
    }
    public void Add_Category(ActionEvent e) throws IOException{
        switchScene.changeButton(e,"/views/GUI3_3.fxml");
    }
    public void Import(ActionEvent e) throws IOException{
        switchScene.changeButton(e,"/views/GUI3_4.fxml");
    }

    public void SelectedQuestionSubcategories(ActionEvent e)throws IOException{
        switchScene.changeBox(e,"/views/GUI2_1.fxml");

    }


    public void setController1(GUI3_2_General_Controller gui3_2_general_controller) {
        this.gui3_2_general_controller = gui3_2_general_controller;
    }

    public void addNametoVboxQuestion(String textFiledCategory) {
        Button newButton = new Button(textFiledCategory);
        newButton.setStyle("-fx-background-color: Calid;");
        VboxQuestion.getChildren().add(newButton);
    }
}
