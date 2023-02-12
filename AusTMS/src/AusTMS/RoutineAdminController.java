/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AusTMS;

import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RoutineAdminController implements Initializable {

  @FXML
    private TableView<Routineinfrm> table;
    
    
    @FXML
    private TableColumn<Routineinfrm, String> Time1;

    @FXML
    private TableColumn<Routineinfrm, String> Time2;

    @FXML
    private TableColumn<Routineinfrm, String> Time3; 
    
    @FXML
    private TextField txt_Time1;

    @FXML
    private TextField txt_Time2;

    @FXML
    private TextField txt_Time3;
    
    ObservableList<Routineinfrm> listM ;
    
    int index=-1;
    Connection connect=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    @FXML
    void AddRoutine(ActionEvent event) {
       connect=(Connection)RoutineDatabase.ConnectDb();
        String sql="insert into Routineinfrm(Time1,Time2,Time3)values(?,?,?)";
        
      try {
          
          Class.forName("com.mysql.cj.jdbc.Driver");
          java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine","root","");
          pst=connect.prepareStatement(sql);
          pst.setString(1, txt_Time1.getText());
          pst.setString(2, txt_Time2.getText());
          pst.setString(3, txt_Time3.getText());
          pst.execute();
          JOptionPane.showMessageDialog(null,"Added Successfully");
      } catch (SQLException ex) {
          Logger.getLogger(RoutineAdminController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null,ex);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(RoutineAdminController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null,ex);
      }
    }
    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Time1.setCellValueFactory(new PropertyValueFactory<Routineinfrm,String>("Time1"));
        Time2.setCellValueFactory(new PropertyValueFactory<Routineinfrm,String>("Time2"));
        Time3.setCellValueFactory(new PropertyValueFactory<Routineinfrm,String>("Time3"));
        listM=RoutineDatabase.getData();
        table.setItems(listM);
    }    
    
    
}
