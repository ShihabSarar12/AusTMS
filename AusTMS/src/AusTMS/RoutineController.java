/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AusTMS;

import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RoutineController implements Initializable {
    
    @FXML
    private TableView<Routineinfrm> table;
    
    @FXML
    private TableColumn<Routineinfrm, String> daytime;

    @FXML
    private TableColumn<Routineinfrm, String> Time1;

    @FXML
    private TableColumn<Routineinfrm, String> Time2;

    @FXML
    private TableColumn<Routineinfrm, String> Time3; 
    
    
    
    ObservableList<Routineinfrm> listM ;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Time1.setCellValueFactory(new PropertyValueFactory<Routineinfrm,String>("Time1"));
        Time2.setCellValueFactory(new PropertyValueFactory<Routineinfrm,String>("Time2"));
        Time3.setCellValueFactory(new PropertyValueFactory<Routineinfrm,String>("Time3"));
        listM=RoutineDatabase.getData();
        table.setItems(listM);
        
        
    }    
    
}
