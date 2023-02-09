
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FacultyEvalController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField IdTxt;
    @FXML
    private TextField numberTxt;
    @FXML
    private TextField fileNameTxt;
    @FXML
    private TextArea codeFacTxt;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private double x = 0;
    private double y = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Close(ActionEvent event) {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void BackToPrev(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FacultyCourse.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)anchorPane.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SubmitNumber(ActionEvent event) {
        String sql = "UPDATE result SET Online=? WHERE Student_ID=?";
        String number = numberTxt.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            System.out.println("Connection received");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, number);
            statement.setString(2, IdTxt.getText());
            int row = statement.executeUpdate();
            System.out.println(row+" row affected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacultyEvalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacultyEvalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void FetchCode(ActionEvent event) {
        String sql = "SELECT * FROM online WHERE Student_ID= ?";
        String Id = IdTxt.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            System.out.println("Connection received!");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, Id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                fileNameTxt.setText(result.getString("File_Name"));
                codeFacTxt.setText(result.getString("Code"));
            }
            else{
                System.out.println("Doesn't exist");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CSE2100OnlineController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CSE2100OnlineController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void Dragged(MouseEvent event) {
        stage = (Stage)anchorPane.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    
}
