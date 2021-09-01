package sample;

import org.json.CDL;
import org.json.JSONArray;

import java.io.FileWriter;

public class CreateCsvFile implements Convertion {
    @Override
    public void convert(JSONArray studentList) {
        try {
            FileWriter fileWriter = new FileWriter("students.csv");
            fileWriter.write(CDL.toString(studentList));
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
