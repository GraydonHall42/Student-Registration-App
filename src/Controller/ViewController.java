package Controller;

import Model.Student;
import View.RegistrationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {
    RegistrationView theView;
    StudentController theStudentController;

    public ViewController(RegistrationView theView, StudentController studentController) {
        this.theView = theView;
        this.theStudentController = studentController;

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
            switch (option) {
                // search for course
                case 0:
                    outputString = theStudentController.searchForCourse(courseName, courseNum);
                    break;

                // add a course
                case 1:
                    if(theStudentController.validateStudent(new Student(name, Integer.parseInt(id)))) {
                        outputString = "Hello " + theStudentController.getCurrentStudentName() + "!\n\n";
                    }
                    else {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }

                    outputString += theStudentController.addCourse(courseName, courseNum, Integer.parseInt(secNum));
                    break;

                // Remove a course
                case 2:
                    if(theStudentController.validateStudent(new Student(name, Integer.parseInt(id)))) {
                        outputString = "Hello " + theStudentController.getCurrentStudentName() + "!\n\n";
                    }
                    else {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }

                    outputString += theStudentController.removeCourse(courseName, courseNum, Integer.parseInt(secNum));
                    break;

                // View all courses
                case 3:
                    outputString = "Course Catalogue:\n\n" + theStudentController.viewCourses();
                    break;

                // View all courses take by student
                case 4:
                    if(theStudentController.validateStudent(new Student(name, Integer.parseInt(id)))) {
                        outputString = "Hello " + theStudentController.getCurrentStudentName() + "!\n\n";
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


