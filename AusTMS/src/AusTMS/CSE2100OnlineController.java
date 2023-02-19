
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CSE2100OnlineController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextArea codeTxt;
    @FXML
    private TextField fileTxt;
    @FXML
    private Label submitLabel;
    private double x = 0;
    private double y = 0;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void BackToPrev(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Course.fxml"));
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
    void Submit(ActionEvent event) {
        String searchSql = "SELECT * FROM online WHERE File_Name=?";
        String sql = "INSERT INTO online (Student_ID,File_Name,Code) VALUES (?,?,?)";
        String fileName = fileTxt.getText();
        String code = codeTxt.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            System.out.println("Connection received");
            PreparedStatement statement = connect.prepareStatement(searchSql);
            statement.setString(1,fileName);
            ResultSet result = statement.executeQuery();
            if(!result.next()){
                statement = connect.prepareStatement(sql);
                statement.setString(1, UserID.getUserID());
                statement.setString(2, fileName);
                statement.setString(3, code);
                int row = statement.executeUpdate();
                System.out.println(row+" updated successfully");
                submitLabel.setText("Submitted Successfully");
            }
            else{
                submitLabel.setText("Same name already exists");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CSE2100OnlineController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CSE2100OnlineController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
