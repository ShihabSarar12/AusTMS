
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminFacultyDetailsController implements Initializable {
    @FXML
    private TextField IdTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField nameTxt;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private double x = 0;
    private double y = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            String sql = "SELECT * FROM faculty WHERE Faculty_ID=?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            System.out.println("Connection received!");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, UserID.getFacultyID());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                String userName = result.getString("Name");
                String userEmail = result.getString("Email");
                IdTxt.setText(UserID.getFacultyID());
                emailTxt.setText(userEmail);
                nameTxt.setText(userName);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentFindController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentFindController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    @FXML
    void BackToFaculty(ActionEvent event) {
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
    void Close(ActionEvent event) {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void DeleteUser(ActionEvent event) {
        String sql = "DELETE FROM faculty WHERE Faculty_ID=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,UserID.getFacultyID());
            int row = statement.executeUpdate();
            System.out.println("Deleted successfully");
            String dropSql = "ALTER TABLE faculty\n DROP id";
            statement = connect.prepareStatement(dropSql);
            boolean done = statement.execute();
            System.out.println(done);
            String addSql = "ALTER TABLE faculty\n ADD id MEDIUMINT NOT NULL AUTO_INCREMENT Primary Key";
            statement = connect.prepareStatement(addSql);
            done = statement.execute();
            System.out.println(done);
            System.out.println("Successfully id resolved");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminStudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void Dragged(MouseEvent event) {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
}
