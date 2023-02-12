
package AusTMS;

import java.awt.Desktop;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CourseSubController implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public String getLink(String chapter){
        String link = null;
        String sql = "SELECT * FROM material WHERE Chapter=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, chapter);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                link = result.getString("Link");
            }
            return link;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CSE2103CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(NewRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @FXML
    void Derby(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(java.net.URI.create(getLink("Derby")));
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void JavaFX(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(java.net.URI.create(getLink("JavaFX")));
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void JavaSocket(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(java.net.URI.create(getLink("JavaSocket")));
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void CSE2100Online(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CSE2100Online.fxml"));
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
