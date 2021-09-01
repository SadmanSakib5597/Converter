package sample;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTextFile {

    public static JSONArray generateJasonArray(String Path){

        ArrayList<Student> students = readTextFile(Path);

        JSONArray studentList = new JSONArray();

        for(int i =0;i<students.size();i++){
            Student s = new Student();
            s = students.get(i);
            JSONObject studentDetails = new JSONObject();
            try{
                studentDetails.put("Name",s.name);
                studentDetails.put("roll",s.roll);
                studentDetails.put("phoneNo",s.phoneNo);
                studentDetails.put("email",s.website);
            }catch (Exception e){
                System.out.println(e);
            }

            JSONObject studentObject = new JSONObject();
            try {
                studentObject.put("student",studentDetails);
            }catch (Exception e){
                System.out.println(e);
            }
            studentList.put(studentObject);
        }
        return studentList;
    }

    public static ArrayList readTextFile(String Path){
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(Path));
            while (sc.hasNext())
            {
                String line[] = sc.nextLine().split(",");
                Student s = new Student();
                s.name = line[0];
                s.roll = line[1];
                s.phoneNo = Integer.parseInt(line[2]);
                s.website = line[3];
                students.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
