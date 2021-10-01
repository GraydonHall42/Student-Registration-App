package Controller;

import Model.*;

public class StudentController {

    private StudentList studentList;
    private CourseList courseList;
    private Student currentStudent;

    public StudentController() {
        studentList = new StudentList();
        courseList = new CourseList();
    }

    public String viewCourses(){
        return courseList.toString();
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

    // 1. Search for Course
    public String searchForCourse(String courseName, String courseNumber){
        Course result = courseList.searchCat(courseName, courseNumber);
        if(result == null){
            return "The class you searched for is not in our system.";
        }
        else {
            String printCourse;
            printCourse = result.getCourseName() + " " + result.getCourseNumber() + "\n\n";
            for(CourseOffering off : result.getCourseOfferingList()){
                printCourse += off.toString() + "\n";
            }
            return printCourse;
        }
    }

    // 2. Add Course
    public String addCourse(String courseName, String courseNumber, int sectionNumber){
        return this.currentStudent.registerForCourse(courseList, courseName, courseNumber, sectionNumber);
    }

    // 3. Remove Course
    public String removeCourse(String courseName, String courseNumber, int sectionNumber) {
        return this.currentStudent.deleteCourse(courseName, courseNumber, sectionNumber);
    }

    // 4. View all student courses
    public String getStudentCourses(){
        return currentStudent.getRegisteredCourses();
    }

    public String getCurrentStudentName() {
        return currentStudent.getName();
    }
}
