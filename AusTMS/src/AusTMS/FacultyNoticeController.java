
package AusTMS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FacultyNoticeController implements Initializable {
    private double x = 0,y = 0;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextArea noticeTextArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            File reader = new File(FXMain.noticePath);
            Scanner input = new Scanner(reader);
            while(input.hasNext()){
                String item = input.nextLine();
                listView.getItems().add(item);
            }
            input.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainPageFacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void PostNotice(ActionEvent event){
        String notice = noticeTextArea.getText();
        try {
            FileWriter fWriter = new FileWriter(FXMain.noticePath,true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.write(notice);
            pWriter.write("\n");
            pWriter.close();
            bWriter.close();
            fWriter.close();
            System.out.println("File appended successfully!!");
        } catch (IOException ex) {
            Logger.getLogger(MainPageFacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listView.getItems().add(notice);
        noticeTextArea.setText("");
    }
    
}
