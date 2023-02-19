package AusTMS;

import com.mysql.cj.jdbc.ServerPreparedStatement;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RoutineAdminController implements Initializable {

    @FXML
    private TableView<Routineinfrm> table;

    @FXML
    private TableColumn<Routineinfrm, String> day;

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

    @FXML
    private Label limit;

    ObservableList<Routineinfrm> listM;
    int index = -1;
    int maxRow = 0;

    String dayDB = null;
    Connection connect = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        UpdateTable();

    }

    @FXML
    void AddRoutine(ActionEvent event) {

        String sql = "insert into studentroutine(Time1,Time2,Time3)values(?,?,?)";
        String sql1 = "select * from studentroutine where day=?";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management", "root", "");
            pst = connect.prepareStatement(sql1);
            for (Integer i = 1;; i++) {
                pst.setString(1, i.toString());
                ResultSet day = pst.executeQuery();

                if (day.next()) {
                    int val = Integer.parseInt(day.getString("day"));
                    if (maxRow < val) {
                        maxRow = val;
                    }
                } else {
                    break;
                }
            }
            if (maxRow < 5 || maxRow == 0) {

                pst = connect.prepareStatement(sql);
                pst.setString(1, txt_Time1.getText());
                pst.setString(2, txt_Time2.getText());
                pst.setString(3, txt_Time3.getText());
                int row = pst.executeUpdate();
                System.out.println(row + " Added");
                UpdateTable();

            } else {
                limit.setText("you can not add anymore");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoutineAdminController.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoutineAdminController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    void getSelected(MouseEvent event) {
        index = table.getSelectionModel().getSelectedIndex();

        if (index <= -1) {
            return;
        }
        dayDB = day.getCellData(index).toString();
        txt_Time1.setText(Time1.getCellData(index).toString());
        txt_Time2.setText(Time2.getCellData(index).toString());
        txt_Time3.setText(Time3.getCellData(index).toString());
        UpdateTable();
    }

    @FXML
    void Edit(ActionEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management", "root", "");

            String value1 = txt_Time1.getText();
            String value2 = txt_Time2.getText();
            String value3 = txt_Time3.getText();

            String sql = "update studentroutine set Time1='" + value1 + "',Time2='" + value2 + "',Time3='" + value3 + "' where day=? ";

            pst = connect.prepareStatement(sql);
            pst.setString(1, dayDB);
            int row = pst.executeUpdate();
            System.out.println(row + " updated");
            UpdateTable();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoutineAdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoutineAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdateTable() {
        day.setCellValueFactory(new PropertyValueFactory<Routineinfrm, String>("day"));
        Time1.setCellValueFactory(new PropertyValueFactory<Routineinfrm, String>("Time1"));
        Time2.setCellValueFactory(new PropertyValueFactory<Routineinfrm, String>("Time2"));
        Time3.setCellValueFactory(new PropertyValueFactory<Routineinfrm, String>("Time3"));
        listM = RoutineDatabase.getData();
        table.setItems(listM);
    }

    @FXML
    void Delete(ActionEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom_management", "root", "");

            String sql = "delete from studentroutine where day=?";
            pst = connect.prepareStatement(sql);
            pst.setString(1, dayDB);
            int row = pst.executeUpdate();
            System.out.println(row + " deleted");
            String dropSql = "ALTER TABLE studentroutine\n DROP day";
            pst = connect.prepareStatement(dropSql);
            boolean done = pst.execute();
            System.out.println(done);
            String addSql = "ALTER TABLE studentroutine\n ADD day MEDIUMINT NOT NULL AUTO_INCREMENT Primary Key";
            pst = connect.prepareStatement(addSql);
            done = pst.execute();
            System.out.println(done);
            System.out.println("Successfully  resolved");
            UpdateTable();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoutineAdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoutineAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
