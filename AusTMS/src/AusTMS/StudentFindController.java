
package AusTMS;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.jshell.StatementSnippet;

public class StudentFindController implements Initializable {
    @FXML
    private TextField findTxt;
    @FXML
    private Label notFoundLabel;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private double x = 0;
    private double y = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    @FXML
    void FindStudent(ActionEvent event) {
        try {
            String studentID = findTxt.getText();
            String sql = "SELECT * FROM student WHERE Student_ID=?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            System.out.println("Connection received!");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, studentID);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                UserID.setUserID(studentID);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentInformation.fxml"));
                root = loader.load();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                notFoundLabel.setText("Student Info not found");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentFindController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentFindController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentFindController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
