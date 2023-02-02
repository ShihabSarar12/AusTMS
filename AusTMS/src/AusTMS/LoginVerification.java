
package AusTMS;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginVerification {
    public static void studentLoginVerify(){
        try {
            String sql = "SELECT * FROM data;";
            Connection connect = Database.connectDB();
            System.out.println("Connection received!");
            Statement statement = connect.createStatement();
            System.out.println("Statement created");
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                int idDB = result.getInt("ID");
                String userNameDB = result.getString("Name");
                String passwordDB = result.getString("Password");
                System.out.println(idDB+" "+userNameDB+" "+passwordDB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
