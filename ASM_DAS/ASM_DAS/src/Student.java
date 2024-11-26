public class Student {

    private String studentName;
    private double studentMarks;
    private String studentId;
    private String studentClass;
    private String studentRank;


    //constructor
    public Student(String studentId, String studentName,String studentClass, double studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentMarks = studentMarks;
        this.studentRank = getRank();
    }

    // getter and setter
    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass(){
        return studentClass;
    }

    public void setStudentClass(String studentClass){
        this.studentClass = studentClass;
    }

    public double getMarks() {
        return studentMarks;
    }

    public void setMarks(double studentMarks) {
        this.studentMarks = studentMarks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentRank() {
        return studentRank;
    }

    public void setStudentRank(int studentRank) {
        this.studentRank = String.valueOf(studentRank);
    }

    public String printStudent(){
        return "- Student Id: " + studentId
                + "\n- Student Name: " + studentName
                + "\n- Student Class: " + studentClass
                + "\n- Student Marks: " + studentMarks
                + "\n- Student Rank: " + studentRank
                +"\n-----";
    }

    String getRank() {
        if (studentMarks >= 0 && studentMarks < 5) {
            studentRank = "FAIL";
        } else if (studentMarks >= 5 && studentMarks < 6.5) {
            studentRank = "MEDIUM";
        } else if (studentMarks >= 6.5 && studentMarks < 7.5) {
            studentRank = "GOOD";
        } else if (studentMarks >= 7.5 && studentMarks < 9.0) {
            studentRank = "VERY GOOD";
        } else {
            studentRank = "EXCELLENT";
        }
        return studentRank;
    }



}
