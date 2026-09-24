import java.util.Scanner;
import java.util.ArrayList;

/*Concepts Covered: 
Arrays, Lists, Searching, Sorting

Description:
Create a program to store, update, search, and sort student records (ID, name, GPA).

Features:
Add / delete / update student records
Search students by ID or name (Linear & Binary Search)
Sort students by GPA or name (Bucket, Radix, Bubble, quick sort, Merge Sort)*/

public class Student_Record_Management_System{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentsList = new ArrayList<>();

        //INTERACTIVE MENU FOR READING USER INPUTS
        int choice = -1;

        System.out.println("Welcome to the Student Record Management System");
        System.out.println("Please select an option:");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Update Student Records");
        System.out.println("4. Search Student by ID");
        System.out.println("5. Search Student by Name");
        System.out.println("6. Search Student by ID using Binary Search (list must be sorted by ID)");
        System.out.println("7. Search Student by Name using Binary Search (list must be sorted by Name)");
        System.out.println("8. Sort Students by Name");
        System.out.println("9. Sort Students by GPA");
        System.out.println("0. Exit");

        while (choice!=0){
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.println ("Enter new Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println ("Enter new Student Full Name: ");
                    String name = scanner.nextLine();
                    System.out.println ("Enter new Student GPA: ");
                    double gpa = scanner.nextDouble();
                    StudentManager.addStudent(studentsList, id, name, gpa);
                    break;
                case 2:
                    // Delete Student
                    System.out.println ("Enter Student ID: ");
                    int deleteId = scanner.nextInt();
                    StudentManager.deleteStudent(studentsList, deleteId);
                    break;
                case 3:
                    // Update Student
                    System.out.println ("Enter Student ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println ("Enter new Student Name: ");
                    String newName = scanner.nextLine();
                    System.out.println ("Enter updated Student GPA: ");
                    double newGpa = scanner.nextDouble();
                    StudentManager.updateStudent(studentsList, updateId, newName, newGpa);
                    break;
                case 4:
                    // Search Student by ID
                    System.out.println ("Enter Student ID: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = StudentManager.searchStudentByID(studentsList, searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    // Search Student by Name
                    System.out.println ("Enter Student Full Name: ");
                    scanner.nextLine();
                    String searchName = scanner.nextLine();
                    Student foundStudentByName = StudentManager.searchStudentByName(studentsList, searchName);
                    if (foundStudentByName != null) {
                        System.out.println("Student found: " + foundStudentByName);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    // Search Student by ID using Binary Search
                    System.out.println ("Enter Student ID: ");
                    int searchIdBinary = scanner.nextInt();
                    Student foundStudentByIdBinary = StudentManager.searchStudentByIDBinary(studentsList, searchIdBinary);
                    if (foundStudentByIdBinary != null) {
                        System.out.println("Student found: " + foundStudentByIdBinary);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 7:
                    // Search Student by Name using Binary Search
                    System.out.println ("Enter Student Full Name: ");
                    scanner.nextLine();
                    String searchNameBinary2 = scanner.nextLine();
                    Student foundStudentByNameBinary2 = StudentManager.searchStudentByNameBinary(studentsList, searchNameBinary2);
                    if (foundStudentByNameBinary2 != null) {
                        System.out.println("Student found: " + foundStudentByNameBinary2);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 8:
                    // Sort Students by Name
                    Sorting.bubbleSort(studentsList, false);
                    System.out.println ("Students sorted by name:");
                    for (int i = 0; i < studentsList.size(); i++) {
                        System.out.println(studentsList.get(i));
                    }
                    break;
                case 9:
                    // Sort Students by GPA
                    Sorting.bucketSortByGpa(studentsList);
                    System.out.println ("Students sorted by GPA:");
                    for (int i = 0; i < studentsList.size(); i++) {
                        System.out.println(studentsList.get(i));
                    }
                    break;
                case 0:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        /* 
        //Takes the user inputs for the variables ID, Name, and GPA
        int id = scanner.nextInt();
        String name = scanner.next();
        double gpa = scanner.nextDouble();

        //StudentManager class methods can be called here to manage the student records
        StudentManager.addStudent(studentsList, id, name, gpa);
        //StudentManager.deleteStudent(studentsList, id);
        StudentManager.updateStudent(studentsList, id, name, gpa);


        //Sort by name

        //sort the studentsList by name using bubble sort
        Sorting.bubbleSort(studentsList, false);
        //sort the studetsList by name using quick sort
        Sorting.quickSort(studentsList, 0, studentsList.size() - 1, false);
        //sort the studentsList by name using merge sort
        Sorting.mergeSort(studentsList, false);

        //Sort by GPA

        //sort the studentsList by GPA using bucket sort
        Sorting.bucketSortByGpa(studentsList);
        //sort the studentsList by GPA using radix sort
        Sorting.radixSortByGpa(studentsList);

        //Student Search

        //Search for a student by ID
        Student foundStudent = StudentManager.searchStudentByID(studentsList, id);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
        //Search for a student by name
        Student foundStudentByName = StudentManager.searchStudentByName(studentsList, name);
        if (foundStudentByName != null) {
            System.out.println("Student found: " + foundStudentByName);
        } else {
            System.out.println("Student not found.");
        }

        */
        scanner.close();
    }

}

