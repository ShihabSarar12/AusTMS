
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainPageFacultyController implements Initializable {
    @FXML
    private TextField chatTxtField;
    @FXML
    private ListView<String> listView;
    @FXML
    private BorderPane mainPane;
    private double x = 0,y = 0;
    @FXML
    private AnchorPane anchorPane;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    public void ChatSystem(ActionEvent event) {
        System.out.println("Inside Chat System");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("FacultyChat");
        mainPane.setCenter(view);
    }
    @FXML
    public void NoticeFaculty(ActionEvent event) {
        System.out.println("Inside Notice System");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("FacultyNotice");
        mainPane.setCenter(view);
    }
    @FXML
    public void Close(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    public void Dragged(MouseEvent event) {
        stage = (Stage)anchorPane.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    public void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    @FXML
    public void Course(ActionEvent event) {
          System.out.println("Inside course transition");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FacultyCourse.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void SendMessage(ActionEvent event) {
        System.out.println("Sending Message");
        String message = chatTxtField.getText();
        listView.getItems().add("Faculty: "+message);
        chatTxtField.setText("");
    }
    @FXML
    void BackToMainFac(ActionEvent event) {
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
    void BackToLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
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
    void StudentInfoFac(ActionEvent event) {
        System.out.println("Inside Student Find");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("StudentFind");
        mainPane.setCenter(view);
    }
    
}
