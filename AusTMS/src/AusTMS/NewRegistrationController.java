
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NewRegistrationController implements Initializable {
    private double x = 0;
    private double y = 0;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Label matchLabel;
    @FXML
    private TextField IdTxt;
    @FXML
    private PasswordField conPasswordTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField nameTxt;
    @FXML
    private PasswordField passwordTxt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void Close(ActionEvent event) {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void Dragged(MouseEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    @FXML
    void RegSaved(ActionEvent event) {
        String sql = "INSERT INTO pending_approval (Student_ID, Name, Email, Password) VALUES (?, ?, ?, ?)";
        String uID = IdTxt.getText();
        String name = nameTxt.getText();
        String email = emailTxt.getText();
        String password = passwordTxt.getText();
        String conPassword = conPasswordTxt.getText();
        if(password.equals(conPassword)){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root",""); 
                PreparedStatement statement = connect.prepareStatement(sql);
                statement.setString(1,uID);
                statement.setString(2, name);
                statement.setString(3, email);
                statement.setString(4, password);
                int row = statement.executeUpdate();
                System.out.println(row+" inserted successfully!");
                System.out.println("Information Saved");
                matchLabel.setText("Saved successfully");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(NewRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            matchLabel.setText("Password doesn't match!");
        }
        
    }
    @FXML
    void BackToLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
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
