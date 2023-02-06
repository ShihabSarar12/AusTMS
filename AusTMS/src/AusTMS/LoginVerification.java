
package AusTMS;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class LoginVerification {
    public static boolean studentLoginVerify(String userID,String password){
        try {
            String sql = "SELECT * FROM student WHERE Student_ID= ? AND Password= ?";
            System.out.println("Field = "+userID);
            System.out.println("Field = "+password);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            System.out.println("Connection received!");
            PreparedStatement statement = connect.prepareStatement(sql);
            System.out.println("Statement created");
            statement.setString(1, userID);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return true;
            }
            else{
                System.out.println("User Name or Password doesnt match");
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean facultyLoginVerify(String userID, String password){
        try {
            String sql = "SELECT * FROM faculty WHERE Faculty_ID= ? AND Password= ?";
            System.out.println("Field = "+userID);
            System.out.println("Field = "+password);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, userID);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            System.out.println("Connection received!");
            System.out.println("Statement created");
            if(result.next()){
                return true;
            }
            else{
                System.out.println("user name or password doesnt match");
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean adminLoginVerify(String userID,String password){
        try {
            String sql = "SELECT * FROM admin WHERE Admin_ID= ? AND Password= ?";
            System.out.println("Field = "+userID);
            System.out.println("Field = "+password);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management","root","");
            System.out.println("Connection received!");
            PreparedStatement statement = connect.prepareStatement(sql);
            System.out.println("Statement created");
            statement.setString(1, userID);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return true;
            }
            else{
                System.out.println("User Name or Password doesnt match");
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
