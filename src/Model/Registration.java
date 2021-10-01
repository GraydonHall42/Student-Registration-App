package Model;

import java.util.ArrayList;

public class Registration {

    private Student student;
    private CourseOffering offering;
    private char grade;

    // constructor to initialize variables
    public Registration(Student student, CourseOffering offering) {

        this.student = student;
        this.offering = offering;
        addRegistration();
    }

    // Add Registration object to the Student and Offering
    private void addRegistration() {
        student.addRegistration(this);
        offering.addRegistration(this);

    }

    // Delete Registration object from the Student and Offering
    public void deleteRegistration() {
        student.removeRegistration(this);
        offering.removeRegistration(this);

    }

    // get course offering
    public CourseOffering getOffering() {
        return offering;
    }


}
