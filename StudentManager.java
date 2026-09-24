import java.util.ArrayList;

public class StudentManager {//this will be where we manage the student list/data
    public static void addStudent(ArrayList<Student> studentsList, int id, String name, double gpa){
        Student newStudent = new Student(id, name, gpa);
        for (int i = 0; i < studentsList.size(); i++){
            if (newStudent.getId() == studentsList.get(i).getId() ){//we use the .getId() after .get(i) because studentsList.get(i) would return all the student info inside the list on that position, and we only want the id here
                System.out.println("Invalid - duplicated ID");
                return;
            }
        }
        studentsList.add(newStudent);
    }

    public static void deleteStudent(ArrayList<Student> studentsList, int id){
        for (int i =0; i < studentsList.size(); i++){
            if (id == studentsList.get(i).getId()){
                studentsList.remove(i);
                return;
            }
        }
        System.out.println("Student not found");
    }

    public static void updateStudent(ArrayList<Student> studentsList, int id, String name, double gpa){
        for (int i = 0; i<studentsList.size(); i++){
            if (studentsList.get(i).getId() == id){
                studentsList.get(i).setName(name);
                studentsList.get(i).setGpa(gpa);
                return;
            }
        }
        System.out.println ("Invalid ID - Student not found");
    }

    public static Student searchStudentByID (ArrayList<Student> studentsList, int id){
        for (int i = 0; i<studentsList.size(); i++){
            if (studentsList.get(i).getId() == id){
                return studentsList.get(i);
            }
        }
        return null;
    }

    public static Student searchStudentByName (ArrayList<Student> studentsList, String name){
        for (int i = 0; i<studentsList.size(); i++){
            if (studentsList.get(i).getName().equals(name)){
                return studentsList.get(i);
            }
        }
        return null;
    }

    //Search Student by ID (Binary search) --> list have to be sorted by name first 
    public static Student searchStudentByIDBinary (ArrayList<Student> studentsList, int id){
        int left = 0;
        int right = studentsList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Student midStudent = studentsList.get(mid);

            if (midStudent.getId() == id) {
                return midStudent;
            } else if (midStudent.getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Student not found
    }

    //Search Student by name (Binary search) --> list have to be sorted by name first 
    public static Student searchStudentByNameBinary (ArrayList<Student> studentsList, String name){
        int left = 0;
        int right = studentsList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Student midStudent = studentsList.get(mid);

            if (midStudent.getName().equals(name)) {
                return midStudent;
            } else if (midStudent.getName().compareTo(name) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Student not found
    }
}
