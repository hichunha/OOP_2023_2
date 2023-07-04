package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

public class GUI3_4_Import_Controller implements Initializable {
    @FXML
    private AnchorPane ap;

    SwitchScene switchScene;

    @FXML
    ImageView ImageFileFormat;
    private Image oldImageFileFormat;
    private Image newImageFileFormat;
    private boolean isOldIamgeFileFormatDisplayed = true;
    @FXML
    private Label labelFileFormat;
    private boolean isLabelFileFormatContentDisplayed = true;
    private static final String TARGET_FOLDER = "src/main/java/File/";

    String selectedFileName;
    String selectedFilePath;

    Path targetPath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchScene = new SwitchScene();

        oldImageFileFormat = new Image(getClass().getResourceAsStream("/icons/1.png"));
        newImageFileFormat = new Image(getClass().getResourceAsStream("/icons/343677652_217672567734908_872177767301265632_n.png"));
    }

    public void ChooseAFile(ActionEvent e) throws IOException{
        Stage stage = (Stage) ap.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose A File");
        FileChooser.ExtensionFilter fileFilter = new FileChooser.ExtensionFilter("Files","*.exe","*.dll","*.pdf","*.txt","*.docx");
        fc.getExtensionFilters().add(fileFilter);
        File SelectedFile  =fc.showOpenDialog(stage);
        if(SelectedFile != null){
            //Kiểm tra kích thước tệp(đơn vị byte)
            long fileSize = SelectedFile.length();
            long maxSize = 100 * 1024 *1024; // 100 MB

            if(fileSize <= maxSize)
            {
                //Hiển thị thông báo OKE
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Kích thước tệp hợp lệ");
                alert.setContentText("OK");
                alert.showAndWait();

                //Xử lý tệp tin , thêm vào Package File
                selectedFileName = SelectedFile.getName();
                selectedFilePath = SelectedFile.getAbsolutePath();

                Path sourcePath = SelectedFile.toPath();
                targetPath = Path.of(TARGET_FOLDER + selectedFileName);

                try {
                    Files.createDirectories(targetPath.getParent());
                    Files.copy(sourcePath,targetPath,StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("File copy to package 'File'" );
                }catch (IOException exception){
                    exception.printStackTrace();
                }

                // Truyền GUI3_4_Import_Controller sang GUI3_4_ImportSuccess_Controller
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/GUI3_4_ImportSuccess.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
                GUI3_4_ImportSuccess_Controller successController = loader.getController();
                successController.setImportController(this);
                stage1.setScene(scene);
                stage1.show();

//                switchScene.changeButton(e,"/views/GUI3_4_ImportSuccess.fxml");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Kích thước tệp quá lớn");
                alert.setContentText("Kích thước tệp vượt quá giới hạn cho phép 100 MB.");
                alert.showAndWait();
                }
        }
        else{
            // Không tồn tại File
        }

    }
    public String getSelectedFileName(){
        return selectedFileName;
    }
    public String getSelectedFilePath(){
        return selectedFilePath;
    }
    public String getTargetPath(){
        return targetPath.toString();
    }

    //Gọi tên File và dường dẫn



    public void changeImageLabelFileFormat(ActionEvent e) throws IOException{
        System.out.println(selectedFileName);
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
            labelFileFormat.setText("Wrong Aiken Format");
        }
        isLabelFileFormatContentDisplayed = !isLabelFileFormatContentDisplayed;
    }
}
