package sample;

import org.json.JSONArray;
import org.json.XML;

import java.io.FileWriter;

public class CreateXmlFile implements Convertion {
    @Override
    public void convert(JSONArray studentList) {
        try {
            FileWriter fileWriter = new FileWriter("students.xml");
            fileWriter.write(XML.toString(studentList));
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
