
package AusTMS;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.HostServices;
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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CourseController implements Initializable {
    @FXML
    private BorderPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    private double x = 0;
    private double y = 0;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void CSE2100(ActionEvent event) {
        System.out.println("Inside CSE2100");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("CourseSub");
        mainPane.setCenter(view);
    }
    @FXML
    void CSE2103(ActionEvent event) {
        System.out.println("Inside CSE2103");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("CSE2103CourseSub");
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
    @FXML
    public void Dragged(MouseEvent event) {
        stage = (Stage)anchorPane.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    public void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
}
