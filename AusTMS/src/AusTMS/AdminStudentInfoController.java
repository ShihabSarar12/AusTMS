
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminStudentInfoController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ListView<String> listView;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private double x = 0;
    private double y = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String sql = "SELECT * FROM student WHERE id=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            PreparedStatement statement = connect.prepareStatement(sql);
            for(Integer i=1; ;i++){
                statement.setString(1,i.toString());
                ResultSet result = statement.executeQuery();
                if(result.next()){
                    listView.getItems().add(result.getString("Student_ID"));
                }
                else{
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentSubmittedController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentSubmittedController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                String studentID = listView.getSelectionModel().getSelectedItem();
                System.out.println("Selected ID: "+studentID);
                UserID.setStudentID(studentID);
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminStudentDetails.fxml"));
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage)anchorPane.getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
    }    

    @FXML
    private void Close(ActionEvent event) {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void BackToStudent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminStudent.fxml"));
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
