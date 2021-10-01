package Model;

import java.util.ArrayList;

public class StudentList {

    private ArrayList<Student> studentList;

    public StudentList() {
        studentList = UniversityDatabaseGenerator.getStudentDatabase();
    }

    public Student authenticateStudent(String name, int id){
        Student student = new Student(name, id);
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
