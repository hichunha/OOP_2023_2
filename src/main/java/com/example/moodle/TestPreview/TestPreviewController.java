package com.example.moodle.TestPreview;

import java.io.IOException;
import java.util.ArrayList;

import com.example.moodle.state.AppStateManager;
import com.example.moodle.state.slices.SliceNames;
import com.example.moodle.state.slices.TestSliceState;
import com.example.moodle.state.slices.UISliceState;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;

import controllers.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

// TODO: Install controlfx, design popup/popover and slide to an empty page
public class TestPreviewController {

  private AppStateManager<TestSliceState> testStateMng = AppStateManager.getSlice(SliceNames.TEST, new TestSliceState());
  private AppStateManager<UISliceState> uiStateManager = AppStateManager.getSlice(SliceNames.UI, new UISliceState());


  // components
  @FXML
  private JFXButton previewStartBtn;

  @FXML
  private void initialize() {
    uiStateManager.update((final UISliceState state) -> {
      state.headerSettingBtnsHidden = true;
      return state;
    });
    testStateMng.subscribe(getClass().getName(), (TestSliceState state) -> {
      this.onShowingTestPreview(state);
    });

    this.setPreviewBtnAlert();
  }

  private void onShowingTestPreview(TestSliceState state) {
    if(state.currentTestName != null) {
      uiStateManager.update((UISliceState uiState) -> {
        uiState.breadcrumbs = new ArrayList<>();
        uiState.breadcrumbs.add(new UISliceState.Breadcrumb("Home", null));
        uiState.breadcrumbs.add(new UISliceState.Breadcrumb("My Tests", (e) -> {
          this.onBackToMainPage(e);
        }));
        uiState.breadcrumbs.add(new UISliceState.Breadcrumb(state.currentTestName, null));
        return uiState;
      });
    }
  }

  private void setPreviewBtnAlert() {
    previewStartBtn.setOnAction(action -> {
      JFXAlert<Object> alert = new JFXAlert<Object>((Stage) previewStartBtn.getScene().getWindow());
      alert.initModality(Modality.APPLICATION_MODAL);
      alert.setOverlayClose(false);
      JFXDialogLayout layout = new JFXDialogLayout();
      layout.setHeading(new Label("Start attempt"));
      Label timeLimitLabel = new Label("Time limit");
      timeLimitLabel.setTextFill(Color.web("red"));
      timeLimitLabel.setStyle("-fx-font-size: 18px;");
      layout.setBody(
        timeLimitLabel
        // new Label("When you start, the timer will begin to count down and cannot be paused. You must finish your attempt before the time expires. Are you sure you wish to start now?")
      );
      JFXButton acceptBtn = new JFXButton("START ATTEMPT");
      JFXButton closeButton = new JFXButton("CANCEL");
      layout.setActions(acceptBtn, closeButton);
      alert.setContent(layout);
      alert.show();
    });
  }
  
  private void onBackToMainPage(ActionEvent e) {
    try {
      new SwitchScene().changeScene(e, "/views/main.fxml");
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
}
