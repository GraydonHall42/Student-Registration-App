package Controller;

import Model.*;

public class StudentController {

    private StudentList studentList;
    private Student currentStudent;

    public StudentController() {
        studentList = new StudentList();
    }


    public boolean validateStudent(Student student){
        if(this.currentStudent == null){
            this.currentStudent = this.studentList.authenticateStudent(student);
        }
        else if(this.currentStudent.equals(student)){
            return true;
        }
        else {
            this.currentStudent = this.studentList.authenticateStudent(student);
        }

        if(this.currentStudent == null){
            return false;
        }
        else{
            return true;
        }
    }


    // case 2 - Add Course
    public String addCourse(Course course, String courseName, String courseNumber, int sectionNumber){
        return this.currentStudent.registerForCourse(course, courseName, courseNumber, sectionNumber);
    }

    // case 3 - Remove Course
    public String removeCourse(String courseName, String courseNumber, int sectionNumber) {
        return this.currentStudent.deleteCourse(courseName, courseNumber, sectionNumber);
    }

    // case 5 - View all student courses
    public String getStudentCourses(){
        return currentStudent.getRegisteredCourses();
    }

    // Get current Student
    public Student getCurrentStudent() {
        return currentStudent;
    }
}
