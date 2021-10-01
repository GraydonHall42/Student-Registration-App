package Model;

import java.util.ArrayList;

public class Student {

    private String name;
    private int studentId;
    private ArrayList<Registration> courseList;
    private ArrayList<Course> takenCourses; // pre-reqs

    public Student (String Name, int studentId) {

        this.setName(Name);
        this.setStudentId(studentId);
        courseList = new ArrayList<Registration>();
        takenCourses = new ArrayList<Course>();
    }

    // Register a student for a course
    public String registerForCourse (CourseList cat, String courseName, String courseNumber, int sectionNumber) {

        // get course
        Course myCourse = cat.searchCat(courseName, courseNumber);

        // validate student can not reg for more than 6 classes
        if(courseList.size() > 5) {
            return "You are only allowed to register for 6 classes.";
        }
        // validate course exists
        if(myCourse == null) {
            return "Not a valid course.";
        }
        // validate section number provided exists
        if(sectionNumber > myCourse.getCourseOfferingSize()) {
            return "Not a valid section.";
        }
        //validate student has all pre req's
        if(!this.checkPreReqs(myCourse)) {
            return "You do not have all the PreReq's needed to register for this Course.";
        }
        //validate student is not already registered in course
        if(!this.checkStudentRegistration(myCourse)) {
            return "You are already registered in this course.";
        }


        // get offering
        CourseOffering offering = myCourse.getCourseOfferingList().get(sectionNumber - 1);

        // create Registration object with offering
        new Registration(this, offering);

        // let user know they have been sucessfully registered
        return "Registered Sucessfully for " + courseName + " " + courseNumber
                + " - section " + sectionNumber + ".";

    }

    // add Registration to student
    public void addRegistration(Registration reg) {
        courseList.add(reg);
    }

    // delete student Registration
    public String deleteCourse(String courseName, String courseNumber, int sectionNumber) {
        if(this.courseList.size() < 1){
            return "You are not enrolled in any courses";
        }
        int index = 0;
        while(index < courseList.size()){
            CourseOffering off = courseList.get(index).getOffering();
            if(off.getCourse().equals(new Course(courseName, courseNumber)) && off.getOfferingNumber() == sectionNumber){
                courseList.get(index).deleteRegistration();
                return "You have been removed from " + off.getCourse().getCourseName() + " " + off.getCourse().getCourseNumber() + ".";
            }
            index++;
        }

        return "You are not registered in that class";
    }

    // remove Registered object from students course list
    public void removeRegistration(Registration reg) {
        courseList.remove(reg);
    }

    // Print courses student is registered for
    public String getRegisteredCourses() {
        if(courseList.size() < 1) {
            return "You are not currently registered for any courses\n";
        }
        String temp = "";
        int count = 1;
        for(Registration reg : courseList) {
            temp += count + ".\n" + reg.getOffering().getCourse() + reg.getOffering();
            count++;
        }

        return temp;
    }

    // check students taken courses agaisnt courses pre reqs
    private boolean checkPreReqs(Course regResult) {
        for(Course c : regResult.getPrereqs()) {
            int isIn = 0;
            for(Course tc : this.getPreReq()) {
                if(c.equals(tc)) {
                    isIn = 1;
                }
            }
            if(isIn == 0) {
                return false;
            }
        }
        return true;

    }

    // check if a student is registered in a given course
    private boolean checkStudentRegistration(Course course) {
        for(Registration reg: courseList) {
            if(reg.getOffering().getCourse().equals(course)) {
                return false;
            }
        }
        return true;
    }


    public boolean equals(Student student){
        if(student.getName().equals(this.getName()) && student.getStudentId() == this.getStudentId()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return this.name + " - " + this.studentId + "\n";
    }

    // add a taken course to student
    public void addPreReq(Course course) {
        takenCourses.add(course);
    }

    // GETTERS AND SETTERS

    public ArrayList<Course> getPreReq() {
        return takenCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

}
