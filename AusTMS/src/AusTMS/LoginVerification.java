
package AusTMS;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class LoginVerification {
    public static void studentLoginVerify(String userID,String password){
        try {
            //String sql = "SELECT * FROM data WHERE Name = Misha";
             //Class.forName("com.mysql.cj.jdbc.Driver");
             //Class.forName("com.mysql.jdbc.Driver");
//             
//            Driver driver = (Driver) driver_class.newInstance();
//            DriverManager.registerDriver(driver);
//            
            //Connection connect = Database.connectDB();
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","shihabsarar");
            String sql = "SELECT * FROM data";
             //Class.forName("com.mysql.cj.jdbc.Driver");
             Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connection received!");
            Statement statement = connect.createStatement();
            System.out.println("Statement created");
            ResultSet result = statement.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
