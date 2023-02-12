/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AusTMS;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.sql.*;

public class RoutineDatabase {
   
    
    public static Connection ConnectDb()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine","root","");
             JOptionPane.showMessageDialog(null,"connection Established");
             return connect;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoutineDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ObservableList<Routineinfrm> getData()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine","root","");
            ObservableList<Routineinfrm> list =FXCollections.observableArrayList();
            try {
                PreparedStatement ps=connect.prepareStatement("SELECT * FROM studentroutine");
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    list.add(new Routineinfrm(rs.getString("Time1"),rs.getString("Time2"),rs.getString("Time3")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RoutineDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoutineDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
}
