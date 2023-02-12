
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

public class MainPageStudentController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private BorderPane mainPane;
    @FXML
    private TextField chatTxtField;
    @FXML
    private ListView<String> listView;
    double x = 0, y = 0;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    public void ChatSystem(ActionEvent event) {
        System.out.println("Inside Chat System");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("Chat");
        mainPane.setCenter(view);
    }
    @FXML
    public void SendMessage(ActionEvent event) {
        System.out.println("Sending Message");
        String message = chatTxtField.getText();
        listView.getItems().add("Shihab: "+message);
        chatTxtField.setText("");
    }
    @FXML
    public void Close(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    public void Dragged(MouseEvent event) {
        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    public void Pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    @FXML
    void NoticeStudent(ActionEvent event) {
        System.out.println("Inside Notice System");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("StudentNotice");
        mainPane.setCenter(view);
    }
    @FXML
    public void Course(ActionEvent event) {
          System.out.println("Inside course transition");
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Course.fxml"));
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
    void Result(ActionEvent event) {
        System.out.println("Inside Result System");
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("Result");
        mainPane.setCenter(view);
    }
    @FXML
    void BackToMain(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageStudent.fxml"));
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
    void goToEdit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfrmEdit.fxml"));
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
    void routine(ActionEvent event) {
      System.out.println("Inside routine System");
      FxmlLoader loader = new FxmlLoader();
      Pane view = loader.getPage("Routine");
      mainPane.setCenter(view);
    
    }
}
