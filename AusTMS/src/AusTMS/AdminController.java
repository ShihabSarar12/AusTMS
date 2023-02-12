/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AdminController implements Initializable {

    private double x = 0;
    private double y = 0;
    private Parent root;
    private Stage stage;
    private Scene scene;
     @FXML
    private AnchorPane anchorPane;

    @FXML
    private BorderPane mainPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    } 
     @FXML
    void Close(ActionEvent event) {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
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
      @FXML
    void InsideFaculty(ActionEvent event) {
       
     
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("AdminFaculty");
        mainPane.setCenter(view); 
        System.out.println("Faculty Clicked");
    }

    @FXML
    void InsideStd(ActionEvent event) {
        
        System.out.println("Student Clicked");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("AdminStudent");
        mainPane.setCenter(view);
    }
    @FXML
    void BackToLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     @FXML
    void routineAd(ActionEvent event) {
      System.out.println("Inside admin routine System");
      FxmlLoader loader = new FxmlLoader();
      Pane view = loader.getPage("RoutineAdmin");
      mainPane.setCenter(view);
    
    }
    
}
