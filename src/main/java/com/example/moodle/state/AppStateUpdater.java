package com.example.moodle.state;

@FunctionalInterface
public interface AppStateUpdater<SliceState> {
  SliceState update(final SliceState oldState); 
}
