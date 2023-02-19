
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentLoginController implements Initializable {
    @FXML
    private TextField txtField;
    @FXML
    private PasswordField passField;
    @FXML
    private Label exceptionLabelStu;
    @FXML
    private Label passLabel;
    private Parent root;
    private Scene scene;
    private Stage stage;
    double x = 0, y = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void StudentLoggedIn(ActionEvent event) {
        System.out.println("Log In Clicked(Student)");
        boolean verified = false;
        boolean exception = false;
        String userId = txtField.getText();
        String password = passField.getText();
        try{
            double uid = Double.parseDouble(userId);
        }catch(NumberFormatException ex){
            exceptionLabelStu.setText("and UserID can't contain letters");
            exception = true;
        }
        if(!exception){
            exceptionLabelStu.setText("");
        }
        verified = LoginVerification.studentLoginVerify(userId, password);
        System.out.println(verified);
        if(verified){
            try {
                UserID.setUserID(userId);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageStudent.fxml"));
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            passLabel.setText("UserID and Password doesn't match!!");
        }
    }
    @FXML
    void forgotPassword(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentForgotPassword.fxml"));
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
