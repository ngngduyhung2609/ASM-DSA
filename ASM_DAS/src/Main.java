
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentList list = new StudentList();

    public static void main(String[] args) {
        while (true) {
            System.out.println(">MENU<\n 1. Student Information\n 2. Add New Student\n 3. Edit Student\n 4. Delete Student\n 5. Sort Student\n 6. Search Student\n 7. Exit Programme");
            System.out.print("Enter your option: ");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    studentInfor();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortStudent();
                    break;
                case 6:
                    searchStudent();
                    break;
                case 7:
                    System.out.println("See you again.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number in Menu");
            }
        }
    }

    public static void studentInfor() {
        System.out.println("List of Student: \n");
        if (list.size() == 0 ){
            System.out.println("List is empty. Add at least one student");
            return;
        }else {
            list.printList();
            System.out.println("Total Student: " + list.size());
        }

    }

    public static void addStudent() {
        System.out.print("Enter number of Student: ");

        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input");
            sc.next();
        }

        int studentNum = sc.nextInt();

        if (studentNum <= 0) {
            System.out.println("Invalid! Please enter number greater than 0.\n ");
            return;
        }
        for (int i = 0; i < studentNum; i++) {
            String studentID;
            while (true){
                System.out.print("Enter student ID: ");
                studentID = sc.next();
                if (!list.contain(new Student(studentID,"","",0))){
                break;
                }
                else {
                    System.out.println("ID can not be duplicate");
                }
            }


            System.out.print("Enter student Name: ");
            String studentName = sc.next();

            System.out.print("Enter student Class: ");
            String studentClass = sc.next();

            double studentMarks;
            while (true) {
                System.out.print("Enter student Mark:");
                if (sc.hasNextDouble()) {
                    studentMarks = sc.nextDouble();

                    if (studentMarks >= 0 && studentMarks <= 10) {
                        sc.nextLine();
                        break;

                    } else {
                        System.out.println("Invalid! Please enter a number that GREATER THAN 0 AND SMALLER THAN 10");
                        sc.nextLine();
                    }
                } else {
                    System.out.println("Please enter a number");
                    sc.nextLine();
                }
            }
            System.out.println("------");
            Student student = new Student(studentID, studentName, studentClass, studentMarks);
            list.add(student);

        }
    }
    public static void editStudent(){
        if (list.size() == 0 ){
            System.out.println("List is empty. Add at least one student");
            return;
        }

        System.out.println("EDIT STUDENT INFORMATION");
        list.printList();

        System.out.println("Enter Student Information \n>>> Enter Student ID: ");
        String EditID = sc.next();
        if(!list.contain(new Student(EditID,"","",0))) {
            System.out.println("Student with this ID are not exist");
            sc.next();
        }

            String newStudentID;
            while (true){
                System.out.println("Enter new Student ID: ");
                newStudentID = sc.next();
                if (!list.contain(new Student(newStudentID,"","",0))){
                    break;
                }
                else {
                    System.out.println("Duplicate");
                }
            }
            if(!list.contain(new Student(EditID,"","",0))){
                System.out.println("Student not found. ");
                sc.next();
            }

            System.out.println("Enter new Student Name: ");
            String newStudentName = sc.next();

            System.out.println("Enter new Student Class: ");
            String newStudentClass = sc.next();

            double newStudentMark;
            while (true){
                System.out.println("Enter new Student Mark: ");
                if (sc.hasNextDouble()){
                    newStudentMark = sc.nextDouble();
                    if (newStudentMark >= 0 && newStudentMark <= 10 ){
                        sc.nextLine();
                        break;
                    }
                    else {
                        System.out.println("Invalid marks! Please enter number that smaller or equal 10");
                    }
                }
                else {
                    System.out.println("Invalid! please enter valid mark");
                    sc.next();
                }
            }
            list.edit(EditID, newStudentID,newStudentName, newStudentClass,newStudentMark);
            System.out.println("Edited Student " + EditID + " successful");
        System.out.println(">***<");

    }
    public static void deleteStudent() {
        if (list.size() == 0 ){
            System.out.println("List is empty. Add at least one student");
            return;
        }

        System.out.println("DELETE STUDENT");
        System.out.println("List of Student: ");
        list.printList();

        System.out.print("Enter Student ID to DELETE: ");
        String studentID = sc.next();

        boolean del = false;
        for (int i = 0;i < list.size(); i++ ){
            Student student = list.list[i];
            if (student.getStudentId().equals(studentID)){
                del = true;
                list.delete(i);
                System.out.println("Student with ID " + studentID + "has been deleted");
                System.out.println("Total Student after delete: " + list.size());
                return;
            }
        }
        if (!del){
            System.out.println("Can not found this Student ID");

        }
    }
    public static void sortStudent(){
        if (list.size() == 0 ){
            System.out.println("List is empty. Add at least one student");
            return;
        }
        System.out.println("SORT STUDENT BY RANK");
        System.out.println("Enter Student ID to search");
        for (int i = 1; i < list.size(); i++){
            Student key = list.list[i];
            int j = i - 1;

            while (j >= 0 && list.list[j].getMarks() < key.getMarks()){
                list.list[j + 1] = list.list[j];
                j--;
            }
            list.list[j + 1] = key;
        }

        System.out.println("Student Ranking: ");
        list.printList();
        System.out.println("------");

    }
    public static void searchStudent(){
        System.out.println("Student List: ");
        if (list.size() == 0 ){
            System.out.println("List is empty. Add at least one student");
            return;
        }else {
            list.printList();
        }
        System.out.print("Enter Student ID to search: ");
        String studentID = sc.next();

        boolean found = false;
        for (int i = 0;i < list.size(); i++ ){
            Student student = list.list[i];
            if (student.getStudentId().equals(studentID)){
                found = true;
                System.out.println("Student ID: " + student.getStudentId() + "\nStudent Name: " + student.getName() + "\nStudent Class: " + student.getStudentClass() + "\nStudent Mark: " + student.getMarks() + "\nStudent Rank: " + student.getStudentRank());
                return;
            }
        }
        if (!found){
            System.out.println("Can not found this Student ID, return to MENU");
            return;
        }


    }
}







