package Controller;

import Model.Student;
import Model.StudentList;

public class StudentListController {

    private StudentList studentList;

    public StudentListController(StudentList studentList) {
        this.studentList = studentList;
    }

    public Student validateStudent(String name, int id){
        return this.studentList.authenticateStudent(name, id);
    }



}
