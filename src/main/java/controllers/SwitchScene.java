package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import com.example.moodle.UI.UIValue;

public class SwitchScene {
    public void SwitchScene(){

    }
    public void changeMenu(ActionEvent e,String UI) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource(UI))) ;
        Stage stage = (Stage) ((MenuItem) e.getSource()).getParentPopup().getOwnerWindow();
        stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    public void changeScene(ActionEvent e,String UI) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource(UI))) ;
        Stage stage= (Stage) ((Node) e.getSource()).getScene().getWindow();
        // TODO: need to switch scene while keeping the resized window
        stage.setScene(new Scene(root, UIValue.windowWidth, UIValue.windowHeight));
        stage.centerOnScreen();
        stage.show();
    }
}
