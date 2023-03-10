
package AusTMS;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField derbyTxt;
    @FXML
    private TextField javaFXTxt;
    @FXML
    private TextField socketTxt;
    @FXML
    private TextField graphTxt;
    @FXML
    private TextField linkedListTxt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void derbyPost(ActionEvent event) {
        String derbyLink = derbyTxt.getText();
        if(!derbyLink.startsWith("https://")){
            derbyLink = "https://"+derbyLink;
        }
        InsertData("Derby", derbyLink);
        derbyTxt.setText("");
    }
    @FXML
    void javaFXPost(ActionEvent event) {
        String javaFXLink = javaFXTxt.getText();
        if(!javaFXLink.startsWith("https://")){
            javaFXLink = "https://"+javaFXLink;
        }
        InsertData("JavaFX", javaFXLink);
        javaFXTxt.setText("");
    }
    @FXML
    void javaSocketPost(ActionEvent event) {
        String javaSocketLink = socketTxt.getText();
        if(!javaSocketLink.startsWith("https://")){
            javaSocketLink = "https://"+javaSocketLink;
        }
        InsertData("JavaSocket", javaSocketLink);
        socketTxt.setText("");
    }
    @FXML
    void CSE2100Online(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentSubmitted.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(FacultyCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void InsertData(String chapter,String link){
        String sql = "INSERT INTO material (Chapter,Link) VALUES (?,?) ON DUPLICATE KEY UPDATE Chapter=?, Link=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,chapter);
            statement.setString(2,link);
            statement.setString(3,chapter);
            statement.setString(4,link);
            int row = statement.executeUpdate();
            System.out.println(row+ "row inserted");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacultyCourseController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacultyCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void CSE2103Online(ActionEvent event) {

    }
    @FXML
    void GraphPost(ActionEvent event) {
        String graphLink = graphTxt.getText();
        if(!graphLink.startsWith("https://")){
            graphLink = "https://"+graphLink;
        }
        InsertData("Graph", graphLink);
        graphTxt.setText("");
    }
    @FXML
    void LinkedListPost(ActionEvent event) {
        String linkedListLink = linkedListTxt.getText();
        if(!linkedListLink.startsWith("https://")){
            linkedListLink = "https://"+linkedListLink;
        }
        InsertData("LinkedList", linkedListLink);
        linkedListTxt.setText("");
    }
    @FXML
    public void postMaterial(ActionEvent event) {
        System.out.println("Inside material");
        FxmlLoader loader = new FxmlLoader();
        Pane view= loader.getPage("Material");
        mainPane.setCenter(view);
    }
    @FXML
    void CSE2100(ActionEvent event) {
        System.out.println("Inside CSE2100");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("CSE2100MatUpdate");
        mainPane.setCenter(view);
    }

    @FXML
    void CSE2103(ActionEvent event) {
        System.out.println("Inside CSE2103");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("CSE2103MatUpdate");
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
    void backToPrev(ActionEvent event){  
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