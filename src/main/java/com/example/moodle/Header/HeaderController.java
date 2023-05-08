package com.example.moodle.Header;

import com.example.moodle.state.AppStateManager;
import com.example.moodle.state.slices.SliceNames;
import com.example.moodle.state.slices.UISliceState;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;

public class HeaderController {
  @FXML private Button editingBtn;
  @FXML private MenuButton settingBtn;

  private AppStateManager<UISliceState> uiStateManager = AppStateManager.getSlice(SliceNames.UI, new UISliceState());

  @FXML
  private void initialize() {
    uiStateManager.subscribe(getClass().getName(), (UISliceState state) -> {
      this.handleHidingSettingBtns(state);
    });
  }

  private void handleHidingSettingBtns(UISliceState state) {
    if(state != null) {
      editingBtn.setVisible(!state.headerSettingBtnsHidden);
      settingBtn.setVisible(!state.headerSettingBtnsHidden);
    }
  }
}
