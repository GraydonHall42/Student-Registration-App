package Model;

import java.util.ArrayList;

public class CourseList {

    private ArrayList<Course> courseList;

    public CourseList(){
        courseList = ImaginaryDatabase.getCourseDatabase();
    }


    @Override
    public String toString() {
        String temp = "";
        for(Course c: courseList) {
            temp += c;
        }
        return temp;
    }

    // search catalog for course
    public Course searchCat (String courseName, String courseNumber) {

        for(Course c: courseList) {
            if(c.getCourseName().equals(courseName) && c.getCourseNumber().equals(courseNumber)){
                return c;
            }
        }
        return null;
    }




}
