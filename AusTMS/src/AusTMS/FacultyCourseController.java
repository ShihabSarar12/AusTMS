
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FacultyCourseController implements Initializable {
    @FXML
    private BorderPane mainPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private double x = 0;
    private double y = 0;
    @FXML
    private AnchorPane anchorPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    @FXML
    public void postMaterial(ActionEvent event) {
        System.out.println("Inside material");
        FxmlLoader loader = new FxmlLoader();
        Pane view= loader.getPage("Material");
        mainPane.setCenter(view);
    }
    @FXML
    void Online(ActionEvent event) {

    }
    @FXML
    public void Close(ActionEvent event) {
        System.exit(0);
        
    }
    @FXML
    void backToFac(ActionEvent event){  
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageFaculty.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(FacultyCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Dragged(MouseEvent event) {
        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    public void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
}