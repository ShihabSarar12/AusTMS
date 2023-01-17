# AusTMS
This application was made using JavaFX and the scenes created using SceneBuilder and designed using CSS. It's practical application is to manage a classroom efficiently.
```java
primaryStage.initStyle(StageStyle.UNDECORATED);
root.setOnMousePressed(mouseEvent ->{
x = mouseEvent.getSceneX();
y = mouseEvent.getSceneY();
});
root.setOnMouseDragged(mouseEvent ->{
primaryStage.setX(mouseEvent.getScreenX() - x);
primaryStage.setY(mouseEvent.getScreenY() - y);
});
```
