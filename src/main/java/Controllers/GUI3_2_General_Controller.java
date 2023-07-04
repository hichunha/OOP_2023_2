package Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GUI3_2_General_Controller implements Initializable {
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

    @FXML
    Button SaveChange;
    @FXML
    TextField Category;

    private GUI3_1_Controller gui3_1_controller;

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

    // Chuyển giao diện khi ấn
    public void BlanksFor3MoreChoices(ActionEvent e) throws IOException {
        switchScene.changeButton(e,"/views/GUI3_2_3MoreChoices.fxml");
    }
    public void SaveChanges(ActionEvent e) throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/GUI3_1.fxml"));
            Parent root = loader.load();

            gui3_1_controller = loader.getController();
            // Thiết lập tham chiếu từ Controller2 (this) sang Controller2 (gui3_1_controller)
            gui3_1_controller.setController1(this);

            Stage stage= (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1280,800));
            stage.centerOnScreen();
            stage.show();


        }catch(IOException event){
            event.printStackTrace();
        }
        String textFiledCategory = Category.getText();
        gui3_1_controller.addNametoVboxQuestion(textFiledCategory);

    }



    public void Cancel(ActionEvent e) throws IOException{
        switchScene.changeButton(e,"/views/GUI3_1.fxml");
    }



}
