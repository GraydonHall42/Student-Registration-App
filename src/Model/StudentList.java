package Model;

import java.util.ArrayList;

public class StudentList {

    private ArrayList<Student> studentList;

    public StudentList() {
        studentList = ImaginaryDatabase.getStudentDatabase();
    }

    public boolean authenticateStudent(Student currentStudent){
        for(Student s : studentList){
            if(s.equals(currentStudent)){
                return true;
            }
        }
        return false;
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
