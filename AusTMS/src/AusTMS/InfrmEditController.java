package AusTMS;

import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InfrmEditController implements Initializable {
     @FXML
    private AnchorPane anchorPane;
     double x = 0, y = 0;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField nameTxt;
    @FXML
    private Label savedLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    void BackToPrev(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageStudent.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainPageStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Close(ActionEvent event) {
        System.exit(0);
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
    void UpdateInfo(ActionEvent event) {
        String userName = nameTxt.getText();
        String userEmail = emailTxt.getText();
        String userID = UserID.getUserID();
        System.out.println("UserID: "+userID);
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            String sql = "UPDATE student SET Name= ?,Email=? WHERE Student_ID=?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2,userEmail);
            statement.setString(3, userID);
            statement.executeUpdate();
            System.out.println("Saved");
            savedLabel.setText("Saved successfully");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(InfrmEditController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(InfrmEditController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
}