package Controller;

import Model.*;

public class StudentController {

    private Student currentStudent;

    public StudentController() {
    }


    public void setCurrentStudent(Student currentStudent) {
       this.currentStudent = currentStudent;
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
