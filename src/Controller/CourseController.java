package Controller;

import Model.Course;
import Model.CourseList;
import Model.CourseOffering;

public class CourseController {

    private CourseList courseList;

    public CourseController(CourseList courseList) {
        this.courseList = courseList;
    }

    // Search for Course
    public Course searchForCourse(String courseName, String courseNumber){
        return courseList.searchCat(courseName, courseNumber);
    }


    // case 1 - search and print course
    public String printCourse(String courseName, String courseNumber){

        Course result = searchForCourse(courseName, courseNumber);
        if(result == null){
            return "The class you searched for is not in our system.";
        }
        else {
            String printCourse;
            printCourse = result + "\n";
            for(CourseOffering off : result.getCourseOfferingList()){
                printCourse += off.toString() + "\n";
            }
            return printCourse;
        }


    }





    // case 4 - print all courses
    public String printAllCourses(){
        return courseList.toString();
    }


}
