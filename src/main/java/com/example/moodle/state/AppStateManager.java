package com.example.moodle.state;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;


public class AppStateManager<SliceState> {
  private static HashMap<String, AppStateManager<Object> > sliceMap = new HashMap<String, AppStateManager<Object> >();
  private Map<String, AppStateSubscriber<Object> > subscriberMap = new HashMap<String, AppStateSubscriber<Object> >();
  private Semaphore lock = new Semaphore(1);
  private SliceState appState = null;
  
  private AppStateManager(SliceState initState) {
    appState = initState;
  }

  @SuppressWarnings("unchecked")
  public static <SliceState> AppStateManager<SliceState> getSlice(String name, SliceState initState) {
    if(sliceMap.containsKey(name)) {
      return (AppStateManager<SliceState>) sliceMap.get(name);
    }

    AppStateManager<SliceState> slice = new AppStateManager<SliceState>(initState);
    sliceMap.put(name, (AppStateManager<Object>) slice);
    return slice;
  }

  @SuppressWarnings("unchecked")
  public static <SliceState> AppStateManager<SliceState> getSlice(String name) {
    if(sliceMap.containsKey(name)) {
      return (AppStateManager<SliceState>) sliceMap.get(name);
    }

    AppStateManager<SliceState> slice = new AppStateManager<SliceState>(null);
    sliceMap.put(name, (AppStateManager<Object>) slice);
    return slice; 
  }

  public void update(AppStateUpdater<SliceState> updater) {
    try {
      lock.acquire();
      appState = updater.update(appState);
      lock.release();
      // notify subscribers here
      for(AppStateSubscriber<Object> subscriber: subscriberMap.values()) {
        subscriber.onChange(appState);
      }
    } catch (InterruptedException e) {
        // exception handling code
      e.printStackTrace();
    } finally {
      lock.release();
    }
  }

  @SuppressWarnings("unchecked")
  public void subscribe(String name, AppStateSubscriber<SliceState> subscriber) {
    subscriberMap.put(name, (AppStateSubscriber<Object>)subscriber);
    subscriber.onChange(appState);
  }

  public void unsubscribe(String name) {
    subscriberMap.remove(name);
  }
}
