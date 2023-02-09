
package AusTMS;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
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
    @FXML
    void CSE2103Online(ActionEvent event) {
        
    }
    @FXML
    void Graph(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if(UserID.getGraphLink()==null){
                desktop.browse(java.net.URI.create("https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/"));
            }
            else{
                desktop.browse(java.net.URI.create(UserID.getGraphLink()));
            }
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void LinkedList(ActionEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if(UserID.getLinkedListLink()==null){
                desktop.browse(java.net.URI.create("https://www.geeksforgeeks.org/data-structures/linked-list/"));
            }
            desktop.browse(java.net.URI.create(UserID.getLinkedListLink()));
        } catch (IOException ex) {
            Logger.getLogger(CourseSubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
