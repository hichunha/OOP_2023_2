## How-to

### 1. Run the application

- Install Java > 19 + Maven
- Run `mvn clean install` or `mvn clean package`
- Run `mvn clean javafx:run`

### 2. Develop

#### 2.1. FXML

- Try to use computed size most of the time
- Try to set clear constraint of each component
- Try to breakdown into several FXML files for each components, especially for reusability


#### 2.2. State management

State is divided into different slices, each slice has its own manager. To get a slice, call:
```java
AppStateManager<UISliceState> uiStateMng = AppStateManager.getSlice<UISliceState>(SliceNames.UI, new UISliceState());
// the second parameter is for default state value if the state is not intialized elsewhere
```

In each controller, to subscribe to certain state slice change, call:
```java 
uiStateMng.subscribe((UISliceState state) -> {
  // do something here
});
```

To update the state, call:
```java
uiStateMng.update((UISliceState state) -> {
  // do something here
});
```