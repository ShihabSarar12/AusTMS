package AusTMS;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ResultController implements Initializable {

    @FXML
    private Text txtavg;
    @FXML
    private Text txtm1;
    @FXML
    private Text txtm2;
    @FXML
    private Text txtm3;
    @FXML
    private Text txtm4;
    @FXML
    private Text txtm5;
    @FXML
    private Text txtm6;
    @FXML
    private Text txtm7;
    @FXML
    private Text txtm8;
    @FXML
    private Text txtm9;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("userID=" + UserID.getUserID());
        String sql = "select * from result where Student_ID=? ";
        String stuid = UserID.getUserID();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management", "root", "");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, stuid);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                txtm1.setText(result.getString("CSE_2103"));
                txtm2.setText(result.getString("CSE_2105"));
                txtm3.setText(result.getString("EEE_2141"));
                txtm4.setText(result.getString("MATH_2101"));
                txtm5.setText(result.getString("HUM_2109"));
                txtm6.setText(result.getString("CSE_2104"));
                txtm7.setText(result.getString("CSE_2100"));
                txtm8.setText(result.getString("EEE_2142"));
                txtm9.setText(result.getString("CSE_2106"));
                txtavg.setText(result.getString("Total_CGPA"));
            }
            System.out.println("Information Saved");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultFacultyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ResultFacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
