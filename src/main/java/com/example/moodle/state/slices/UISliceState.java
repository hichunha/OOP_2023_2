package com.example.moodle.state.slices;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UISliceState {
  public static class Breadcrumb {
    public String name;
    public EventHandler<ActionEvent> listener;
    public Breadcrumb(String name, EventHandler<ActionEvent> listener) {
      this.name = name;
      this.listener = listener;
    }
  }
  
  public ArrayList<UISliceState.Breadcrumb> breadcrumbs = new ArrayList<>();
  public boolean headerSettingBtnsHidden = false;
}
