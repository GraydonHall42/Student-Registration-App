package Model;

import java.util.ArrayList;

public class Student {

    private String Name;
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
    public void registerForCourse (CourseCatalogue cat, String courseName, String courseNumber, int sectionNumber) {

        // get course
        Course myCourse = cat.searchCat(courseName, courseNumber);

        // validate student can not reg for more than 6 classes
        if(courseList.size() > 5) {
            System.out.println("You are only allowed to register for 6 classes.");
            return;
        }
        // validate course exists
        if(myCourse == null) {
            System.out.println("Not a valid course.");
            return;
        }
        // validate section number provided exists
        if(sectionNumber > myCourse.getCourseOfferingSize()) {
            System.out.println("Not a valid section.");
            return;
        }
        //validate student has all pre req's
        if(!this.checkPreReqs(myCourse)) {
            System.out.println("You do not have all the PreReq's needed to register for this Course.");
            return;
        }
        //validate student is not already registered in course
        if(!this.checkStudentRegistration(myCourse)) {
            System.out.println("You are already registered in this course.");
            return;
        }


        // get offering
        CourseOffering offering = myCourse.getCourseOfferingList().get(sectionNumber - 1);

        // create Registration object with offering
        new Registration(this, offering);

        // let user know they have been sucessfully registered
        System.out.println("Registered Sucessfully!");

    }

    // add Registration to student
    public void addRegistration(Registration reg) {
        courseList.add(reg);
    }

    // delete student Registration
    public void deleteCourse(int index) {
        courseList.get(index).deleteRegistration();
    }

    // remove Registered object from students course list
    public void removeRegistration(Registration reg) {
        courseList.remove(reg);
    }

    // Print courses student is registered for
    public boolean getRegisteredCourses() {
        if(courseList.size() < 1) {
            System.out.println("You are not currently registered for any courses\n");
            return false;
        }
        String temp = "";
        int count = 1;
        for(Registration reg : courseList) {
            temp += count + ".\n" + reg.getOffering().getCourse() + reg.getOffering();
            count++;
        }

        System.out.println(temp);
        return true;
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
        if(student.getName() == this.getName() && student.getStudentId() == this.getStudentId()){
            return true;
        }
        else{
            return false;
        }
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
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

}
