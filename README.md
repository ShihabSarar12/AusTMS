# AusTMS
This application was made using JavaFX and the scenes created using SceneBuilder and designed using CSS. It's practical application is to manage a classroom efficiently.
- To make stage undecorated and draggable.
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
- To make 2 different colors blend in a scene.
```css
.backgroundColorLeft {
    -fx-background-color: linear-gradient(to right, #00a6ff, #054bf0);
}
```
### AusTMS Login Page
![AusTMS login](https://user-images.githubusercontent.com/101878439/212870317-11cdfc18-9cdc-4144-b83c-2622cb543bb7.png)
