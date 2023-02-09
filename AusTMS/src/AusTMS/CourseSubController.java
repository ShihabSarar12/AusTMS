
package AusTMS;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CourseSubController implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void Derby(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if(UserID.getDerbyLink()==null){
                desktop.browse(java.net.URI.create("https://shorturl.at/MNX15"));
            }
            else{
                desktop.browse(java.net.URI.create(UserID.getDerbyLink()));
            }
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void JavaFX(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if(UserID.getJavaFXLink()==null){
                desktop.browse(java.net.URI.create("https://shorturl.at/eIY79"));
            }
            else{
                desktop.browse(java.net.URI.create(UserID.getJavaFXLink()));
            }
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void JavaSocket(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if(UserID.getJavaSocketLink()==null){
                desktop.browse(java.net.URI.create("https://shorturl.at/cov16"));
            }
            else{
                desktop.browse(java.net.URI.create(UserID.getJavaSocketLink()));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void CSE2100Online(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CSE2100Online.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
