
package AusTMS;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FacultyForgotPasswordController implements Initializable {
    @FXML
    private Label ChangedLabel;
    @FXML
    private TextField IdTxt;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField emailTxt;
    @FXML
    private Label matchLabel;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField conPassTxt;
    @FXML
    private TextField newPassTxt;
    private Parent root;
    private Scene scene;
    private Stage stage;
    double x = 0, y = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void BackToLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void Close(ActionEvent event) {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void Dragged(MouseEvent event) {
        stage = (Stage)anchorPane.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    @FXML
    void SendRequest(ActionEvent event) {
        String userTxt = IdTxt.getText();
        String emailInfo = emailTxt.getText();
        String name = nameTxt.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            String sql = "SELECT * FROM faculty WHERE Faculty_ID=? AND Name=? AND Email=?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,userTxt);
            statement.setString(2,name);
            statement.setString(3,emailInfo);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                try {
                    UserID.setStudentID(userTxt);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FacultyPasswordChange.fxml"));
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                matchLabel.setText("Credential doesn't match");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void ChangePass(ActionEvent event) {
        String newPass = newPassTxt.getText();
        String conPass = conPassTxt.getText();
        if(newPass.equals(conPass)){
            String sql = "UPDATE faculty SET Password=? WHERE Faculty_ID=?";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
                PreparedStatement statement = connect.prepareStatement(sql);
                statement.setString(1,newPass);
                statement.setString(2,UserID.getStudentID());
                int row = statement.executeUpdate();
                System.out.println(row +" Added Successfully");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StudentForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            ChangedLabel.setText("Password doesn't match");
        }
    }
}
