package AusTMS;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMain extends Application {
    public static String noticePath = "D:/AUST 2.1/SD LAB/AusTMS/AusTMS/src/AusTMS/TxtFiles/notice.txt";
    double x = 0, y = 0;
    public static double width = 750;
    public static double height = 600;
    @Override
    public void start(Stage primaryStage) {
        File noticeFile = new File(noticePath);
        if(!noticeFile.exists()){
            try {
                noticeFile.createNewFile();
                System.out.println("notice.txt created!!");
            } catch (IOException ex) {
                Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("notice.txt already exists!!");
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Intro.fxml"));
            
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            root.setOnMousePressed(mouseEvent ->{
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
            });
            root.setOnMouseDragged(mouseEvent ->{
            primaryStage.setX(mouseEvent.getScreenX() - x);
            primaryStage.setY(mouseEvent.getScreenY() - y);
            });
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}