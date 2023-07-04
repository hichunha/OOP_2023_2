package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI3_4_ImportSuccess_Controller implements Initializable {
    SwitchScene switchScene;
    @FXML
    TreeView<String> treeView;
    @FXML
    AnchorPane ap;
    @FXML
    ImageView ImageFileFormat;
    private Image oldImageFileFormat;
    private Image newImageFileFormat;
    private boolean isOldIamgeFileFormatDisplayed = true;

    @FXML
    Label labelFileFormat;
    private boolean isLabelFileFormatContentDisplayed = true;

    @FXML
    private Button ChooseFile;

    private GUI3_4_Import_Controller importController;

    public void setImportController(GUI3_4_Import_Controller controller) {
        this.importController = controller;
        String selectedFileName = importController.getSelectedFileName();
        ChooseFile.setText(selectedFileName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchScene = new SwitchScene();
        oldImageFileFormat = new Image(getClass().getResourceAsStream("/icons/1.png"));
        newImageFileFormat = new Image(getClass().getResourceAsStream("/icons/343677652_217672567734908_872177767301265632_n.png"));
    }




    //Hiện FileFormat hay không hiện
    public void changeImageLabelFileFormat(ActionEvent e) throws IOException{
        if(isOldIamgeFileFormatDisplayed){
            ImageFileFormat.setImage(newImageFileFormat);
        }
        else{
            ImageFileFormat.setImage(oldImageFileFormat);
        }
        isOldIamgeFileFormatDisplayed = !isOldIamgeFileFormatDisplayed;

        if(isLabelFileFormatContentDisplayed){
            labelFileFormat.setText("");
        }
        else{
            labelFileFormat.setText("Right Aiken Format");
        }
        isLabelFileFormatContentDisplayed = !isLabelFileFormatContentDisplayed;
    }

    public void ChooseAFile(ActionEvent e) throws IOException{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Thông báo");
        alert.setHeaderText("WARNING ERROR");
        alert.setContentText("Vui lòng Import trước khi chọn tệp tin mới");
        alert.showAndWait();
    }
    public void NameButtonFile(ActionEvent e)throws IOException{
        String targetPath = importController.getTargetPath();
        System.out.println(targetPath);
//        // Mở vị trí toàn bộ file vừa được chọn
//        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open File");
//
//            // Thiết lập đường dẫn mặc định cho cửa sổ file
//        File initialDirectory = new File(targetPath);
//        fileChooser.setInitialDirectory(initialDirectory.getParentFile());
//
//            // Hiển thị cửa sổ file
//        File selectedFile = fileChooser.showOpenDialog(stage);
//        if (selectedFile != null) {
//                // Mở tệp tin được chọn
//            try {
//                Desktop.getDesktop().open(selectedFile);
//            } catch (IOException event) {
//                event.printStackTrace();
//            }
//        }

        // Mở vị trí thư mục vừa được chọn
        File selectedDirectory = new File(targetPath);
        if (selectedDirectory.exists()) {
            // Mở thư mục được chọn
            try {
                Desktop.getDesktop().open(selectedDirectory);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else{
            System.out.println("File không tồn tại");
        }
    }
}
