package AusTMS;

import javafx.scene.control.Button;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class ResultFacultyController implements Initializable {

    @FXML
    private TextField txtm1;
    @FXML
    private TextField txtm2;
    @FXML
    private TextField txtm3;
    @FXML
    private TextField txtm4;
    @FXML
    private TextField txtm5;
    @FXML
    private TextField txtm6;
    @FXML
    private TextField txtm7;
    @FXML
    private TextField txtm8;
    @FXML
    private TextField txtm9;
    @FXML
    private TextField stuID;
    @FXML
    private Label txtavg;
    @FXML
    private Button calbtn;
    @FXML
    private Button clearbtn;
    @FXML
    private Button btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void Cal(ActionEvent event) {
        double n1, n2, n3, n4, n5, n6, n7, n8, n9;
        n1 = Double.parseDouble(txtm1.getText());
        n2 = Double.parseDouble(txtm2.getText());
        n3 = Double.parseDouble(txtm3.getText());
        n4 = Double.parseDouble(txtm4.getText());
        n5 = Double.parseDouble(txtm5.getText());
        n6 = Double.parseDouble(txtm6.getText());
        n7 = Double.parseDouble(txtm7.getText());
        n8 = Double.parseDouble(txtm8.getText());
        n9 = Double.parseDouble(txtm9.getText());
        double total, avg;
        total = n1 * 3 + n2 * 3 + n3 * 3 + n4 * 3 + n5 * 3 + n6 * 1.5 + n7 * 0.75 + n8 * 1.5 + n9 * 1.5;
        avg = (total / 20.25);
        txtavg.setText(String.format("%.3f", avg));
    }

    @FXML
    void Clear(ActionEvent event) {
        txtm1.setText("");
        txtm2.setText("");
        txtm3.setText("");
        txtm4.setText("");
        txtm5.setText("");
        txtm6.setText("");
        txtm7.setText("");
        txtm8.setText("");
        txtm9.setText("");
        txtavg.setText("");
        stuID.setText("");
        txtm1.requestFocus();
    }

    @FXML
    void Submit(ActionEvent event) {
        String sql = "INSERT INTO result (Student_ID,CSE_2103,CSE_2105,EEE_2141,MATH_2101,HUM_2109,CSE_2104,CSE_2100,EEE_2142,CSE_2106,Total_CGPA) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String m1 = txtm1.getText();
        String m2 = txtm2.getText();
        String m3 = txtm3.getText();
        String m4 = txtm4.getText();
        String m5 = txtm5.getText();
        String m6 = txtm6.getText();
        String m7 = txtm7.getText();
        String m8 = txtm8.getText();
        String m9 = txtm9.getText();
        String stuid = stuID.getText();
        String m10 = txtavg.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management", "root", "");
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, stuid);
            statement.setString(2, m1);
            statement.setString(3, m2);
            statement.setString(4, m3);
            statement.setString(5, m4);
            statement.setString(6, m5);
            statement.setString(7, m6);
            statement.setString(8, m7);
            statement.setString(9, m8);
            statement.setString(10, m9);
            statement.setString(11, m10);
            int row = statement.executeUpdate();
            System.out.println(row + " inserted successfully!");
            System.out.println("Information Saved");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultFacultyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ResultFacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
