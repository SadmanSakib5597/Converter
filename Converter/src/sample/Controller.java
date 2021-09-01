package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import org.json.JSONArray;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Controller implements Initializable {

    @FXML
    Button Select_file;
    @FXML
    Label path;
    @FXML
    ComboBox choose_file;
    @FXML
    Button convert_file;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       choose_file.getItems().addAll("CSV", "Jason", "XML");
       choose_file.setDisable(true);
    }
    public String getpath(ActionEvent event){
            System.out.println("it works");
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add (new FileChooser.ExtensionFilter("word files","*.txt"));
        File f = fc.showOpenDialog(null);
        System.out.println(f.getAbsolutePath());
        setPath(f.getAbsolutePath());
        choose_file.setDisable(false);
        return f.getAbsolutePath();
        }
     public String setPath(String Path){
        path.setText(Path);
        return Path;
     }
     public void convert(String Path,String fileType){
         JSONArray studentList =  ReadTextFile.generateJasonArray(Path);
         String choice = fileType;
         if(choice.equals("CSV")){
             CreateCsvFile c = new CreateCsvFile();
             c.convert(studentList);
         }
         else if(choice.equals("Jason")){
             CreateJsonFile c = new CreateJsonFile();
             c.convert(studentList);
         }
         else if(choice.equals("XML")){
             CreateXmlFile c = new CreateXmlFile();
             c.convert(studentList);
         }
     }

    public String file_convert(ActionEvent event) {
        String fileType = (String) choose_file.getSelectionModel().getSelectedItem();
        System.out.println(fileType);
        convert(path.getText(),fileType);
        return fileType;
    }
    public void exitButton(ActionEvent event){
        Exit();
    }
    public void Exit(){
        exit(0);
    }
}
