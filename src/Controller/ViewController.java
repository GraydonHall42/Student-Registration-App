package Controller;

import Model.Student;
import View.RegistrationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {
    RegistrationView theView;
    StudentController theStudentController;
    StudentListController theStudentListController;
    CourseController theCourseController;

    public ViewController(RegistrationView theView, StudentController studentController, StudentListController studentListController, CourseController courseController) {
        this.theView = theView;
        this.theStudentController = studentController;
        this.theStudentListController = studentListController;
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
                    if(theStudentListController.validateStudent(name, Integer.parseInt(id)) == null) {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }
                    else {
                        theStudentController.setCurrentStudent(theStudentListController.validateStudent(name, Integer.parseInt(id)));
                        outputString = "Hello " + theStudentController.getCurrentStudent() + "\n";
                    }

                    outputString += theStudentController.addCourse(theCourseController.searchForCourse(courseName, courseNum),
                                                                    courseName, courseNum, Integer.parseInt(secNum));
                    break;

                // Remove a course
                case 3:
                    if(theStudentListController.validateStudent(name, Integer.parseInt(id)) == null) {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }
                    else {
                        theStudentController.setCurrentStudent(theStudentListController.validateStudent(name, Integer.parseInt(id)));
                        outputString = "Hello " + theStudentController.getCurrentStudent() + "\n";
                    }

                    outputString += theStudentController.removeCourse(courseName, courseNum, Integer.parseInt(secNum));
                    break;

                // View all courses
                case 4:
                    outputString = "Course Catalogue:\n\n" + theCourseController.printAllCourses();
                    break;

                // View all courses take by student
                case 5:
                    if(theStudentListController.validateStudent(name, Integer.parseInt(id)) == null) {
                        outputString = "That is not a valid student in our database.";
                        break;
                    }
                    else {
                        theStudentController.setCurrentStudent(theStudentListController.validateStudent(name, Integer.parseInt(id)));
                        outputString = "Hello " + theStudentController.getCurrentStudent() + "\n";
                    }
                    outputString += "Your Registered Courses: \n\n";
                    outputString += theStudentController.getStudentCourses();
                    break;

                default:
                    outputString = "Error!";
                    break;
            }

            theView.setOutputAreaText(outputString);

        }
    }

}


