package com.example.moodle.TestList;

import com.example.moodle.state.AppStateManager;
import com.example.moodle.state.slices.SliceNames;
import com.example.moodle.state.slices.TestSliceState;

import controllers.SwitchScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TestListController {
  @FXML private Button testButton;

  private AppStateManager<TestSliceState> testStateMng = AppStateManager.getSlice(SliceNames.TEST, new TestSliceState());

  @FXML
  private void initialize() {
    testButton.setOnAction(e -> {
      try {
        testStateMng.update((TestSliceState state) -> {
          state.currentTestName = testButton.getText();
          return state;
        });
        new SwitchScene().changeScene(e, "/views/test-preview.fxml");
      } catch(Exception ex) {
        ex.printStackTrace();
      }
    });
  }
}
