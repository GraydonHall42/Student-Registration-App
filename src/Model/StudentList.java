package Model;

import java.util.ArrayList;

public class StudentList {

    private ArrayList<Student> studentList;

    public StudentList() {
        studentList = ImaginaryDatabase.getStudentDatabase();
    }

    public Student authenticateStudent(Student student){
        for(Student s : studentList){
            if(s.equals(student)){
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        String students = "";

        for(Student s : studentList){
            students += s.toString();
        }

        return students;
    }

}
