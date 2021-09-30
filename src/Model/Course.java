package Model;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseNumber;
    private ArrayList<CourseOffering> courseOfferings;
    private ArrayList<Course> prereqs;

    // Constructor initializes variables;
    public Course(String courseName, String courseNumber) {
        this.setCourseName(courseName);
        this.setCourseNumber(courseNumber);
        prereqs = new ArrayList<Course>();
        courseOfferings = new ArrayList<CourseOffering>();
    }

    // add course offering of this course
    public void addCourseOffering(int offeringNumber, int offeringCap) {
        //courseOffering.add(new CourseOffering(offeringNumber, offeringCap, this))
        CourseOffering co = new CourseOffering(offeringNumber, offeringCap);
        co.setCourse(this);
        courseOfferings.add(co);
    }

    // add a pre-requisite class
    public void addPrereq(Course course) {
        this.prereqs.add(course);
    }

    @Override
    public String toString() {
        return this.courseName + " " + this.courseNumber + "\n";
    }

    // method to determine if two Courses equal each other using name and number
    public boolean equals(Course c) {
        return this.courseName == c.getCourseName() && this.courseNumber == c.getCourseNumber();
    }

    //GETTERS AND SETTERS BELOW

    public ArrayList<CourseOffering> getCourseOfferingList() {
        return courseOfferings;
    }

    public int getCourseOfferingSize() {
        return courseOfferings.size();
    }

    public ArrayList<Course> getPrereqs() {
        return prereqs;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }


}
