package Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI3_2_3MoreChoices_Controller implements Initializable {
    SwitchScene switchScene;
    @FXML
    ImageView Check_QuestionName;
    @FXML
    ImageView Check_QuestionText;
    @FXML
    ImageView Check_DefaultMark;
    @FXML
    TextField TextFiledName;
    @FXML
    TextArea TextAreaText;
    @FXML
    TextField TextFiledMark;

    @FXML
    ScrollPane scrollPane1;
    @FXML
    Button GradeButton1;
    @FXML
    VBox buttonList1;

    @FXML
    ScrollPane scrollPane2;
    @FXML
    Button GradeButton2;
    @FXML
    VBox buttonList2;
    // Blank for 3 more choices
    @FXML
    ScrollPane scrollPane3;
    @FXML
    Button GradeButton3;
    @FXML
    VBox buttonList3;

    @FXML
    ScrollPane scrollPane4;
    @FXML
    Button GradeButton4;
    @FXML
    VBox buttonList4;

    @FXML
    ScrollPane scrollPane5;
    @FXML
    Button GradeButton5;
    @FXML
    VBox buttonList5;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchScene = new SwitchScene();

        //Cập nhật giá trị Grade 1
        ObservableList<Node> buttons1 = buttonList1.getChildren();
        for (Node node : buttons1) {
            if (node instanceof Button) {
                Button button1 = (Button) node;
                button1.setOnAction(event -> {
                    String buttonText = button1.getText();
                    GradeButton1.setText(buttonText);
                });
            }
        }
        //Cập nhật Grade 2
        ObservableList<Node> buttons2 = buttonList2.getChildren();
        for (Node node : buttons2) {
            if (node instanceof Button) {
                Button button2 = (Button) node;
                button2.setOnAction(event -> {
                    String buttonText = button2.getText();
                    GradeButton2.setText(buttonText);
                });
            }
        }
        // Blank for 3 more choices
        //Cập nhật Grade 3
        ObservableList<Node> buttons3 = buttonList3.getChildren();
        for (Node node : buttons3) {
            if (node instanceof Button) {
                Button button3 = (Button) node;
                button3.setOnAction(event -> {
                    String buttonText = button3.getText();
                    GradeButton3.setText(buttonText);
                });
            }
        }
        //Cập nhật Grade 4
        ObservableList<Node> buttons4 = buttonList4.getChildren();
        for (Node node : buttons4) {
            if (node instanceof Button) {
                Button button4 = (Button) node;
                button4.setOnAction(event -> {
                    String buttonText = button4.getText();
                    GradeButton4.setText(buttonText);
                });
            }
        }//Cập nhật Grade 5
        ObservableList<Node> buttons5 = buttonList5.getChildren();
        for (Node node : buttons5) {
            if (node instanceof Button) {
                Button button5 = (Button) node;
                button5.setOnAction(event -> {
                    String buttonText = button5.getText();
                    GradeButton5.setText(buttonText);
                });
            }
        }
    }

    public void QuestionName(ActionEvent e){
        // Dùng để hiển thị nếu không nhập hiện dâu !
        Check_QuestionName.getScene().lookup("/icons/exclamation-mark_2757.png");
        Check_QuestionName.setVisible(false);
        TextFiledName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                Check_QuestionName.setVisible(true);
            } else {
                Check_QuestionName.setVisible(false);
            }
        });
    }
    @FXML
    private void QuestionText(KeyEvent e) {
        //Dùng để hiển thị nếu không nhập hiện dấu !
        String text = TextAreaText.getText().trim();
        if (text.isEmpty()) {
            Check_QuestionText.setVisible(true);
        } else {
            if (text.contains("/icons/exclamation-mark_2757.png")) {
                Check_QuestionText.setImage(new Image("/icons/exclamation-mark_2757.png"));
                Check_QuestionText.setVisible(true);
            } else {
                Check_QuestionText.setVisible(false);
            }
        }
    }

    public void DefaultMark(ActionEvent e){
        // Dùng để hiển thị nếu không nhập hiện dâu !
        Check_DefaultMark.getScene().lookup("/icons/exclamation-mark_2757.png");
        Check_DefaultMark.setVisible(false);
        TextFiledMark.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                Check_DefaultMark.setVisible(true);
            } else {
                Check_DefaultMark.setVisible(false);
            }
        });
    }

    public void Grade1(ActionEvent e){
        scrollPane1.setVisible(!scrollPane1.isVisible());
    }
    public void Grade2(ActionEvent e){
        scrollPane2.setVisible(!scrollPane2.isVisible());
    }

    // Blank for 3 more choice
    public void Grade3(ActionEvent e){
        scrollPane3.setVisible(!scrollPane3.isVisible());
    }
    public void Grade4(ActionEvent e){
        scrollPane4.setVisible(!scrollPane4.isVisible());
    }
    public void Grade5(ActionEvent e){
        scrollPane5.setVisible(!scrollPane5.isVisible());
    }

    //Chuyển giao diện
    public void SaveChanges2(ActionEvent e) throws IOException {
        switchScene.changeButton(e,"/views/GUI3_1.fxml");
    }
    public void Cancel2(ActionEvent e) throws IOException{
        switchScene.changeButton(e,"/views/GUI3_1.fxml");
    }
}
