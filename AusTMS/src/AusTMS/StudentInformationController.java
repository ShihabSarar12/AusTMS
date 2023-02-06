
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudentInformationController implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private double x = 0;
    private double y = 0;
    @FXML
    private TextField IdTxt;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField nameTxt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            String userID = UserID.getUserID();
            String sql = "SELECT * FROM student WHERE Student_ID=?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            System.out.println("Connection received!");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, userID);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                String userName = result.getString("Name");
                String userEmail = result.getString("Email");
                IdTxt.setText(userID);
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
    void BackToStudent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageFaculty.fxml"));
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
    void Close(ActionEvent event) {
        stage = (Stage)anchorPane.getScene().getWindow();
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
}
