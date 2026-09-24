//import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa){ //initializes all variables that belongs to the Student class
        this.id = id;
        this.name = name;
        this.gpa = gpa;
   
    }

    //Getter methods (ID, GPA, Name)
    public int getId (){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getGpa(){
        return gpa;
    }
    

    //Setter methods (no need for ID setter, since that does not change)
    public void setName (String name){
        this.name = name;
    }
    public void setGpa (double gpa){
        this.gpa = gpa;
    }

    public String toString(){
        return "Student name: " + name + ", Student ID: " + id + ", GPA: " + gpa;
    }
}

