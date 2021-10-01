package Controller;

import Model.Student;
import View.StudentView;
import Model.StudentModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {
    StudentView theView;
    StudentModel theModel;

    public StudentController(StudentView theView, StudentModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        theView.addSearchButtonListener(new SearchButtonListener());

    }

    class SearchButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int option = theView.getSelectedOption();
            String name = theView.getStudetnName();
            String id = theView.getStudentID();
            String courseName = theView.getCourseName();
            String courseNum = theView.getCourseNum();
            String secNum = theView.getSecNum();
            String outputString = "";

            //find the student using getStudent() method

            // talk to back end using this input...
            // and get a string back to output to the user
            switch (option) {
                // search for course
                case 0:
                    outputString = theModel.searchForCourse(courseName, courseNum);
                    break;

                // add a course
                case 1:
                    if(theModel.validateStudent(new Student(name, Integer.parseInt(id)))) {
                        outputString = "Hello " + theModel.getCurrentStudentName() + "!\n\n";
                    }
                    else {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }

                    outputString += theModel.addCourse(courseName, courseNum, Integer.parseInt(secNum));
                    break;

                // Remove a course
                case 2:
                    if(theModel.validateStudent(new Student(name, Integer.parseInt(id)))) {
                        outputString = "Hello " + theModel.getCurrentStudentName() + "!\n\n";
                    }
                    else {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }

                    outputString += theModel.removeCourse(courseName, courseNum, Integer.parseInt(secNum));
                    break;

                // View all courses
                case 3:
                    outputString = "Course Catalogue:\n\n" + theModel.viewCourses();
                    break;

                // View all courses take by student
                case 4:
                    if(theModel.validateStudent(new Student(name, Integer.parseInt(id)))) {
                        outputString = "Hello " + theModel.getCurrentStudentName() + "!\n\n";
                    }
                    else {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }
                    outputString += "Your Registered Courses: \n\n";
                    outputString += theModel.getStudentCourses();
                    break;

                default:
                    outputString = "Error!";
                    break;
            }

//            String outPutString = "ID: " + id
//                    + "\nName: " + name
//                    + "\noption selected: " + option
//                    + "\ncourse name: " + courseName
//                    + "\ncourse number: " + courseNum
//                    + "\nsection number: " + secNum
//                    +"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nthis is end";  // test for long output
//            // send output back to view
            theView.setOutputAreaText(outputString);

        }
    }

}


