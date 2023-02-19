
package AusTMS;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdminFacultyController implements Initializable {
    @FXML
    private BorderPane mainPane;
    @FXML
    private Label matchLabel;
    @FXML
    private TextField IdTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField passwordTxt;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private double x = 0;
    private double y = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    private void Entry(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFacultyInfoEntry.fxml"));
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
    void ApproveEntry(ActionEvent event) {
        boolean exception = false;
        String sql = "INSERT INTO faculty (Faculty_ID, Name, Email, Password) VALUES (?, ?, ?, ?)";
        String uID = IdTxt.getText();
        String name = nameTxt.getText();
        String email = emailTxt.getText();
        String password = passwordTxt.getText();
        try{
            int id = Integer.parseInt(uID);
            if(name.matches(".*[0-9].*")){
                throw new CustomException("Name can't contain numbers");
            }
            if(!email.endsWith("@aust.edu")){
                throw new CustomEmailException("Email is not valid");
            }
        }catch(NumberFormatException ex){
            matchLabel.setText("UserID can't contain letters");
            exception = true;
        }catch(CustomException ex){
            matchLabel.setText("Name can't contain numbers");
            exception = true;
        }catch(CustomEmailException ex){
            matchLabel.setText("Email is not valid");
            exception = true;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root",""); 
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,uID);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, password);
            if(!exception){
                int row = statement.executeUpdate();
                System.out.println(row+" inserted successfully!");
                System.out.println("Information Saved");
                matchLabel.setText("Saved successfully");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void BackToFaculty(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFaculty.fxml"));
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
    private void BackToAdmin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
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
    private void Feedback(ActionEvent event) {
        
    }
    @FXML
    private void Close(ActionEvent event) {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    private void BackToLogin(ActionEvent event) {
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
    void FacultyDetails(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFacultyInfo.fxml"));
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
    private void Dragged(MouseEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    private void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
}
