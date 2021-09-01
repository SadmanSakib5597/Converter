package sample;
public class Student {

    String name;
    String roll;

    String website;

    int phoneNo;

    public Student(String name,String roll, int phoneNo, String website){
        this.name = name;

        this.roll = roll;

        this.phoneNo = phoneNo;

        this.website = website;
    }
    public Student(){

    }

    public String toString(){
        return "Name: " + name + " Roll: " + roll + " PhoneNo: " + phoneNo + " Website: " + website;
    }
}
