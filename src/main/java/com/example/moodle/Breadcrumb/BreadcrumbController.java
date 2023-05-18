package com.example.moodle.Breadcrumb;

import com.example.moodle.state.AppStateManager;
import com.example.moodle.state.slices.SliceNames;
import com.example.moodle.state.slices.UISliceState;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class BreadcrumbController {
  @FXML private FlowPane container;

  private AppStateManager<UISliceState> uiStateManager = AppStateManager.getSlice(SliceNames.UI, new UISliceState());

  @FXML
  private void initialize() {
    container.setHgap(5);
    uiStateManager.subscribe(getClass().getName(), (UISliceState state) -> {
      this.handleBreadcrumbChange(state);
    });
  }

  private void handleBreadcrumbChange(UISliceState state) {
    container.getChildren().clear();
    int sz = state.breadcrumbs.size();
    for(int i = 0; i < sz; ++i) {
      UISliceState.Breadcrumb breadcrumb = state.breadcrumbs.get(i);
      Button button = new Button(breadcrumb.name);
      String btnStyle = "-fx-background-color: transparent;";
      if(breadcrumb.listener != null) {
        btnStyle += "-fx-cursor: hand;";
        button.setOnAction(breadcrumb.listener);
      }
      
      button.setStyle(btnStyle);
      container.getChildren().add(button);
      if(i < sz - 1) {
        Text slash = new Text("/");
        container.getChildren().add(slash);
        AnchorPane.setTopAnchor(slash, 0.0);
        AnchorPane.setBottomAnchor(slash, 0.0);
      }
      AnchorPane.setTopAnchor(button, 0.0);
      AnchorPane.setBottomAnchor(button, 0.0);
    }
  }
}
