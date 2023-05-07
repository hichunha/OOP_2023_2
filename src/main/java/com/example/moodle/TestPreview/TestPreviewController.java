package com.example.moodle.TestPreview;

import java.io.IOException;
import java.util.ArrayList;

import com.example.moodle.state.AppStateManager;
import com.example.moodle.state.slices.SliceNames;
import com.example.moodle.state.slices.TestSliceState;
import com.example.moodle.state.slices.UISliceState;

import controllers.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TestPreviewController {

  private AppStateManager<TestSliceState> testStateMng = AppStateManager.getSlice(SliceNames.TEST, new TestSliceState());
  private AppStateManager<UISliceState> uiStateManager = AppStateManager.getSlice(SliceNames.UI, new UISliceState());
  
  @FXML
  private void initialize() {
    uiStateManager.update((final UISliceState state) -> {
      state.headerSettingBtnsHidden = true;
      return state;
    });
    testStateMng.subscribe(getClass().getName(), (TestSliceState state) -> {
      this.onShowingTestPreview(state);
    });
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
  
  private void onBackToMainPage(ActionEvent e) {
    try {
      new SwitchScene().changeScene(e, "/views/main.fxml");
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
}
