package com.example.moodle.state;

public interface AppStateSubscriber<SliceState> {
  void onChange(SliceState state);
}
