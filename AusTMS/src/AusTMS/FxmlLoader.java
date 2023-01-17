
package AusTMS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlLoader {
    private Pane view;
    public Pane getPage(String fileName){
        try{
            URL fileUrl = FXMain.class.getResource("/AusTMS/"+fileName+".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file can't be found!!");
            }
            view = new FXMLLoader().load(fileUrl);
        }catch(FileNotFoundException ex){
            System.out.println("No page"+fileName);
        } catch (IOException ex) {
            Logger.getLogger(FxmlLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return view;
    }
}
