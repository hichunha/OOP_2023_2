package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
		  launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
      FXMLLoader loader = new FXMLLoader();
      Parent root = loader.load(getClass().getResource("bai5.fxml"));

      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
  }
}
