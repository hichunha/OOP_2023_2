package com.example.moodle;

import java.util.ArrayList;

import com.example.moodle.state.AppStateManager;
import com.example.moodle.state.slices.SliceNames;
import com.example.moodle.state.slices.UISliceState;

import javafx.fxml.FXML;

public class MainController {
  private AppStateManager<UISliceState> uiStateManager = AppStateManager.getSlice(SliceNames.UI, new UISliceState());

  @FXML
  private void initialize() {
    uiStateManager.update((UISliceState state) -> {
      state.headerSettingBtnsHidden = false;
      state.breadcrumbs = new ArrayList<>();
      state.breadcrumbs.add(new UISliceState.Breadcrumb("Home", null));
      state.breadcrumbs.add(new UISliceState.Breadcrumb("My Tests", null));
      return state;
    });
  }
}
