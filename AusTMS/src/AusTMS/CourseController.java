
package AusTMS;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CourseController implements Initializable {
    @FXML
    private BorderPane mainPane;

   
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
      @FXML
    void Online(ActionEvent event) {
        System.out.println("Inside Online");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("Online");
        mainPane.setCenter(view);
    }

    @FXML
    public void postMaterial(ActionEvent event) {
        System.out.println("Inside material");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("Material");
        mainPane.setCenter(view);
    }
    @FXML
    public void Close(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void backToPrev(ActionEvent event) {  
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageStudent.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void backToFac(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageFaculty.fxml"));
            root = loader.load();
        }catch(IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CSE2103TakeOnline(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TakeOnline.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
