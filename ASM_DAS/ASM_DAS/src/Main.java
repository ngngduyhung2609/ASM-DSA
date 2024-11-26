import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentList list = new StudentList();

    public static void main(String[] args) {
        while (true) {
            System.out.println(">MENU<" +
                    "\n 1. Student Information" +
                    "\n 2. Add New Student" +
                    "\n 3. Edit Student" +
                    "\n 4. Delete Student" +
                    "\n 5. Sort Student" +
                    "\n 6. Search Student" +
                    "\n 7. Exit Programme");
            System.out.print("Enter your option: ");

            try {
                int input = sc.nextInt();
                sc.nextLine();

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
                        mergeSortStudent();
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    public static void studentInfor() {
        System.out.println("List of Student: \n");
        if (list.size() == 0 ){
            System.out.println("List is empty. Add at least one student");
        }else {
            list.printList();
            System.out.println("Total Student: " + list.size());
            System.out.println("-----");
        }
    }

    public static void addStudent() {
        System.out.print("Enter number of Student: ");

        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input! Please enter an integer");
            sc.next();
        }

        int studentNum = sc.nextInt();
        sc.nextLine();

        if (studentNum <= 0) {
            System.out.println("Invalid! Please enter number greater than 0.");
            return;
        }

        for (int i = 0; i < studentNum; i++) {
            String studentID;
            while (true){
                System.out.print("Enter student ID: ");
                studentID = sc.nextLine();
                if (!list.contain(new Student(studentID,"","",0))){
                break;
                }
                else {
                    System.out.println("ID can not be duplicate");
                }
            }

            System.out.print("Enter student Name: ");
            String studentName = sc.nextLine();

            System.out.print("Enter student Class: ");
            String studentClass = sc.nextLine();

            double studentMarks;
            while (true) {
                System.out.print("Enter student Mark: ");
                if (sc.hasNextDouble()) {
                    studentMarks = sc.nextDouble();

                    if (studentMarks >= 0 && studentMarks <= 10) {
                        sc.nextLine();
                        break;

                    } else {
                        System.out.println("Invalid! Please enter a number that GREATER THAN 0 AND SMALLER THAN 10");

                    }
                } else {
                    System.out.println("Please enter a number");
                    sc.next();
                }
            }
            System.out.println(">> Add success");
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

        System.out.print("Enter Student Information \n>>> Enter Student ID: ");
        String EditID = sc.nextLine();
        if(!list.contain(new Student(EditID,"","",0))) {
            System.out.println("Student with this ID are not exist");
            return;
        }

            String newStudentID;
            while (true){
                System.out.print("Enter new Student ID: ");
                newStudentID = sc.next();
                if (!list.contain(new Student(newStudentID,"","",0))){
                    break;
                }
                else {
                    System.out.println("This ID was exist, Enter another ID");
                }
            }

            System.out.print("Enter new Student Name: ");
            String newStudentName = sc.next();

            System.out.print("Enter new Student Class: ");
            String newStudentClass = sc.next();

            double newStudentMark;
            while (true){
                System.out.print("Enter new Student Mark: ");
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
                    sc.nextLine();
                }
            }
            list.edit(EditID, newStudentID,newStudentName, newStudentClass,newStudentMark);
            System.out.println("Student has been Edited");
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
                list.delete(i);
                System.out.println("Student with ID " + studentID + " has been deleted");
                System.out.println("Total Student after delete: " + list.size());
                System.out.println("-----");
                del = true;
                return;
            }
        }
        if (!del){
            System.out.println("Can not found this Student ID");
            sc.nextLine();
        }
    }

    @SuppressWarnings("unused")
    public static void sortStudent(){
        if (list.size() == 0 ){
            System.out.println("List is empty. Add at least one student");
            return;
        }
        System.out.println("SORT STUDENT BY RANK");
        System.out.println("Do you want to sort from Highest -> Lowest or from Lowest -> Highest ?" +
                "\n 1. Highest -> Lowest" +
                "\n 2. Lowest -> Highest");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                for (int i = 1; i < list.size(); i++){
                    Student key = list.list[i];
                    int j = i - 1;

                    while (j >= 0 && list.list[j].getMarks() < key.getMarks()){
                        list.list[j + 1] = list.list[j];
                        j--;
                    }
                    list.list[j + 1] = key;
                }

                System.out.println("Student Ranking (Highest -> Lowest): ");
                list.printList();
                break;
            case 2:
                for (int i = 1; i < list.size(); i++){
                    Student key = list.list[i];
                    int j = i - 1;

                    while (j >= 0 && list.list[j].getMarks() > key.getMarks()){
                        list.list[j + 1] = list.list[j];
                        j--;
                    }
                    list.list[j + 1] = key;
                }

                System.out.println("Student Ranking (Lowest -> Highest): ");
                list.printList();
                break;
            default:
                System.out.println("Invalid choice! Please select 1 or 2");
                break;
        }
    }

    public static void mergeSortStudent() {
        if (list.size() == 0) {
            System.out.println("List is empty. Add at least one student");
            return;
        }

        System.out.println("SORT STUDENT BY RANK");
        System.out.println("Do you want to sort from Highest -> Lowest or from Lowest -> Highest ?" +
                "\n 1. Highest -> Lowest" +
                "\n 2. Lowest -> Highest");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                mergeSort(list.list, 0, list.size() - 1, true);
                System.out.println("Student Ranking (Highest -> Lowest): ");
                list.printList();
                break;
            case 2:
                mergeSort(list.list, 0, list.size() - 1, false);
                System.out.println("Student Ranking (Lowest -> Highest): ");
                list.printList();
                break;
            default:
                System.out.println("Invalid choice! Please select 1 or 2");
                break;
        }
    }

    private static void mergeSort(Student[] array, int left, int right, boolean highestFirst) {
        if (left < right) {
            int mid = (left + right) / 2; // Tìm ra số ở giữa


            mergeSort(array, left, mid, highestFirst);
            mergeSort(array, mid + 1, right, highestFirst);


            merge(array, left, mid, right, highestFirst);
        }
    }

    private static void merge(Student[] array, int left, int mid, int right, boolean highestFirst) {

        //tính kích thước
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //tạo mảng
        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        //sao chép dữ liệu
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) { //hợp nhất 2 mảng
            if ((highestFirst && leftArray[i].getMarks() >= rightArray[j].getMarks()) ||
                    (!highestFirst && leftArray[i].getMarks() <= rightArray[j].getMarks())) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void searchStudent(){
        System.out.println("Student in List: ");
        if (list.size() == 0 ){
            System.out.println("List is empty. Add at least one student");
            return;
        }else {
            list.printID();
        }
        System.out.print("Enter Student ID to search: ");
        String studentID = sc.next();

        boolean found = false;
        for (int i = 0;i < list.size(); i++ ){
            Student student = list.list[i];
            if (student.getStudentId().equals(studentID)){
                found = true;
                System.out.println("Student ID: " + student.getStudentId()
                        + "\nStudent Name: " + student.getName()
                        + "\nStudent Class: " + student.getStudentClass()
                        + "\nStudent Mark: " + student.getMarks()
                        + "\nStudent Rank: " + student.getStudentRank());
                return;
            }
        }
        if (!found){
            System.out.println("Can not found this Student ID, return to MENU");
            return;
        }
    }
}