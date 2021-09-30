package Controller;

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
                case 1:
                    break;
                case 2:
//                    outputString = theStudent.addcourse()
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    outputString = "Error!";
                    break;
            }

            String outPutString = "ID: " + id
                    + "\nName: " + name
                    + "\noption selected: " + option
                    + "\ncourse name: " + courseName
                    + "\ncourse number: " + courseNum
                    + "\nsection number: " + secNum
                    +"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nthis is end";  // test for long output
            // send output back to view
            theView.setOutputAreaText(outPutString);

        }
    }

}

