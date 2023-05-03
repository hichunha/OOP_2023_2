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

public class SwitchScene {
    public void SwitchScene(){

    }
    public void changeMenu(ActionEvent e,String UI) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource(UI))) ;
        Stage stage = (Stage) ((MenuItem) e.getSource()).getParentPopup().getOwnerWindow();
        stage.setScene(new Scene(root, 1200,640));
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    public void changeScene(ActionEvent e,String UI) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource(UI))) ;
        Stage stage= (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 1200,640));
        stage.centerOnScreen();
        stage.show();
    }
}
