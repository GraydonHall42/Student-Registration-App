package Model;

import java.util.ArrayList;

public class CourseOffering {

    private int offeringNumber; // Unique number
    private int offeringCap;
    private Course course;
    private boolean validCourse; // 8 ppl need to register for course to be valid
    private ArrayList <Registration> studentList;

    // constructor to initialize variables
    public CourseOffering (int offeringNumber, int offeringCap) {
        this.setOfferingNumber(offeringNumber);
        this.setOfferingCap(offeringCap);
        this.validCourse = false;
        studentList = new ArrayList <Registration>();
    }

    // add a Registration object to Offering
    public void addRegistration(Registration reg) {
        studentList.add(reg);
        this.checkCourseValid();
    }

    // remove a Registration object from Offering
    public void removeRegistration(Registration reg) {
        studentList.remove(reg);
        this.checkCourseValid();
    }

    // will update if the course is valid
    // everytime a reg is added or removed
    private void checkCourseValid() {
        if(studentList.size() < 8) {
            validCourse = false;
        }
        else {
            validCourse = true;
        }
    }

    @Override
    public String toString() {
        return "Offering Number: " + offeringNumber + "\nNumber of seats: " + offeringCap + "\n";
    }

    //GETTERS AND SETTERS

    public boolean isValidCourse() {
        return validCourse;
    }

    public int getOfferingNumber() {
        return offeringNumber;
    }

    public void setOfferingNumber(int offeringNumber) {
        this.offeringNumber = offeringNumber;
    }

    public int getOfferingCap() {
        return offeringCap;
    }

    public void setOfferingCap(int offeringCap) {
        this.offeringCap = offeringCap;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



}
