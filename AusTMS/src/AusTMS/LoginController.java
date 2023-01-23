
package AusTMS;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    @FXML
    private BorderPane mainPane;
    @FXML
    private PasswordField passField;
    @FXML
    private Label passLabel;
    @FXML
    private TextField txtField;
    private Parent root;
    private Scene scene;
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }

    @FXML
    void FacultyLogin(ActionEvent event) {
        System.out.println("Faculty Login Clicked");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("FacultyLogin");
        mainPane.setCenter(view); 
    }

    @FXML
    void StudentLogin(ActionEvent event){
        System.out.println("Student Login Clicked");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("StudentLogin");
        mainPane.setCenter(view);
    }
    @FXML
    void StudentLoggedIn(ActionEvent event) {
        System.out.println("Log In Clicked(Student)");
        String userId = txtField.getText();
        String password = passField.getText();
        if(userId.equals("Shihab")&&password.equals("12345")){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageStudent.fxml"));
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            passLabel.setText("UserID and Password doesn't match!!");
        }
    }
    @FXML
    void FacultyLoggedIn(ActionEvent event) {
        System.out.println("Log In Clicked(Faculty)");
        String userId = txtField.getText();
        String password = passField.getText();
        if(userId.equals("Turjo")&&password.equals("54321")){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageFaculty.fxml"));
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            passLabel.setText("UserID and Password doesn't match!!");
        }
    }
    @FXML
    public void Close(ActionEvent event){
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
