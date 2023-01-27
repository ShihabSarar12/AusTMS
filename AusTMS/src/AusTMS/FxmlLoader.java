
package AusTMS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class FxmlLoader {
    private Pane view;
    private Parent root;
    public Pane getPage(String fileName){
        try{
            URL fileUrl = FXMain.class.getResource("/AusTMS/"+fileName+".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file can't be found!!");
            }
            view = new FXMLLoader().load(fileUrl);
        }catch(FileNotFoundException ex){
            System.out.println("No page"+fileName);
        } catch (IOException ex) {
            Logger.getLogger(FxmlLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return view;
    }
    public void slideTransition(String fxml,Scene scene,AnchorPane anchorPane){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            root = loader.load();
        }catch(IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        root.translateXProperty().set(scene.getWidth());
        StackPane mainPane = (StackPane)scene.getRoot();
        mainPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event->{
            mainPane.getChildren().remove(anchorPane);
        });
        timeline.play();
    }
}
