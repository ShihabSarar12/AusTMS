
package AusTMS;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CSE2103CourseSubController implements Initializable {

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
        }catch (SQLException ex) {
                Logger.getLogger(NewRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @FXML
    void Graph(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(java.net.URI.create(getLink("Graph")));
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void LinkedList(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(java.net.URI.create(getLink("LinkedList")));
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
