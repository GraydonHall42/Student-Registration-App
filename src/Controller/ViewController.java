package Controller;

import Model.Student;
import View.RegistrationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {
    RegistrationView theView;
    StudentController theStudentController;
    CourseController theCourseController;

    public ViewController(RegistrationView theView, StudentController studentController, CourseController courseController) {
        this.theView = theView;
        this.theStudentController = studentController;
        this.theCourseController = courseController;

        theView.addSearchButtonListener(new SearchButtonListener());

    }

    class SearchButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            // exit if inputs are invalid
            if(!theView.validateInputs()){
                return;
            }

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
            switch (option + 1) {
                // search for course
                case 1:
                    outputString = theCourseController.printCourse(courseName, courseNum);
                    break;

                // add a course
                case 2:
                    if(theStudentController.validateStudent(name, Integer.parseInt(id))) {
                        outputString = "Hello " + theStudentController.getCurrentStudent() + "\n";
                    }
                    else {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }

                    outputString += theStudentController.addCourse(theCourseController.searchForCourse(courseName, courseNum),
                                                                    courseName, courseNum, Integer.parseInt(secNum));
                    break;

                // Remove a course
                case 3:
                    if(theStudentController.validateStudent(name, Integer.parseInt(id))) {
                        outputString = "Hello " + theStudentController.getCurrentStudent() + "\n";
                    }
                    else {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }

                    outputString += theStudentController.removeCourse(courseName, courseNum, Integer.parseInt(secNum));
                    break;

                // View all courses
                case 4:
                    outputString = "Course Catalogue:\n\n" + theCourseController.printAllCourses();
                    break;

                // View all courses take by student
                case 5:
                    if(theStudentController.validateStudent(name, Integer.parseInt(id))) {
                        outputString = "Hello " + theStudentController.getCurrentStudent() + "\n";
                    }
                    else {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }
                    outputString += "Your Registered Courses: \n\n";
                    outputString += theStudentController.getStudentCourses();
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


