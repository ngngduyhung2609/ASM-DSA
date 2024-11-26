public class StudentList {
    Student[] list = new Student[0]; //Create a List with size = 0
    private int index = -1; //Set index = -1

    void reSize(){
        if(list.length == 0){
            list = new Student[1];
        }
        else{
            Student[] tempList = new Student[list.length * 2];
            System.arraycopy(list, 0, tempList, 0, list.length);
            list = tempList;
        }
    }

    void printList(){
        for (Student s : list){
            if(s != null){
                System.out.println(s.printStudent());
            }
        }
    }

    public void printID() {
        for (Student s : list)
            if (s != null){
                System.out.println(" - ID: " + s.getStudentId());
        }
    }

    void add(Student student){
        if(index + 1 == list.length){
            reSize();
        }
        index++;
        list[index] = student;
    }

    void delete(int i){
        if (i < 0 || i > index){
            System.out.println("Invalid");
        }
        for (int j = i; j < index; j++){
            list[j] = list[j + 1];
        }
        list[index]=null;
        index--;
    }

    int size(){
        return index + 1;
    }

    boolean contain (Student student){
        for(Student s : list){
            if (s != null && student.getStudentId().equals(s.getStudentId())){
                return true;
            }
        }
        return false;
    }



    void edit(String studentIDEdit, String newStudentID, String newStudentName,String newStudentClass, double newStudentMark ){
        for (int i = 0; i <= index; i++){
            if (list[i] != null && list[i].getStudentId().equals(studentIDEdit)){
                list[i].setStudentId(newStudentID);
                list[i].setStudentClass(newStudentClass);
                list[i].setName(newStudentName);
                list[i].setMarks(newStudentMark);
                list[i].getRank();
                break;
            }
        }
    }
}
