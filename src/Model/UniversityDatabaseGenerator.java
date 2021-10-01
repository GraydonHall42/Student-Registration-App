package Model;

import java.util.ArrayList;

public final class UniversityDatabaseGenerator {

    private static ArrayList<Course> courseDatabase;
    private static ArrayList<Student> studentDatabase;

    private UniversityDatabaseGenerator() { }

    public static ArrayList<Course> getCourseDatabase() {

        courseDatabase = new ArrayList<Course>();

        courseDatabase.add(new Course("ENSF", "607"));
        courseDatabase.add(new Course("ENSF", "608"));
        courseDatabase.add(new Course("ENSF", "611"));
        courseDatabase.add(new Course("ENSF", "612"));
        courseDatabase.add(new Course("ENSF", "614"));
        courseDatabase.add(new Course("ENGG", "687"));

        // add spring / summer classes as pre req for each fall class
        for(Course c : courseDatabase) {
            c.addPrereq(new Course("ENSF", "592"));
            c.addPrereq(new Course("ENSF", "593"));
            c.addPrereq(new Course("ENSF", "594"));
        }

        // pretend each class has 2 sections
        for(Course c : courseDatabase) {
            c.addCourseOffering(1, 60);
            c.addCourseOffering(2, 60);
        }

        return courseDatabase;

    }

    public static ArrayList<Student> getStudentDatabase() {

        studentDatabase = new ArrayList<Student>();

        studentDatabase.add(new Student("Kevin", 1111));
        studentDatabase.add(new Student("Jane", 2222));
        studentDatabase.add(new Student("Karen", 3333));

        for(Student s : studentDatabase){
            s.addPreReq(new Course("ENSF", "592"));
            s.addPreReq(new Course("ENSF", "593"));
            s.addPreReq(new Course("ENSF", "594"));
        }

        // Timmy does not have PreReqs needed to Register
        studentDatabase.add(new Student("Timmy", 4444));

        return studentDatabase;
    }



}
