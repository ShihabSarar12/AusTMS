
package AusTMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","shihabsarar");
            return connect;  
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        } catch (SQLException ex) {
            System.out.println("Sql Exception");
        }
        return null;
    }
}
