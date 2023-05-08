package com.example.moodle.MenuBar;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class MenuBarController {
  @FXML private Circle avatarPlaceholder;

  @FXML
  private void initialize() {
    URL imgSrc =  getClass().getResource("/icons/avatar-trang-ngau.jpg");
    Image image = new Image(imgSrc.toString());
    avatarPlaceholder.setFill (new ImagePattern(image));
  }
}
