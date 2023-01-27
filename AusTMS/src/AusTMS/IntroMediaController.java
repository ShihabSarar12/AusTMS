
package AusTMS;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class IntroMediaController implements Initializable {
    @FXML
    private MediaView mediaViewer;
    private Media media;
    private MediaPlayer mediaPlayer;
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane introPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    private void sceneChange(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            root = loader.load();
        }catch(IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)introPane.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
/*
File file=new File("C:\\Users\\Lenovo\\Downloads\\media.mp4");
         String urlString;
        try {
            urlString = file.toURI().toURL().toString();
            Media media=new Media(urlString);
            MediaPlayer mediaPlayer=new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            System.out.println("Playing media");
            MediaView mediaView=new MediaView(mediaPlayer);
            VBox root=new VBox();
            root.setAlignment(Pos.CENTER);
            root.getChildren().add(mediaView);
            primaryStage.setScene(new Scene(root,700,500));
            primaryStage.show();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MediaView.class.getName()).log(Level.SEVERE, null, ex);
        }
*/