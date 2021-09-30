package Controller;

import Model.StudentModel;
import View.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentControllerJK {
    StudentView theView;
    StudentModel theModel;

    public StudentControllerJK(StudentView theView, StudentModel theModel) {
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

            // talk to back end using this input...
            // and get a string back to output to the user
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }

            String outPutString = "ID: " + id
                    + "\nName: " + name
                    + "\noption selected: " + option
                    + "\ncourse name: " + courseName
                    + "\ncourse number: " + courseNum
                    + "\nsection number: " + secNum;

            // send output back to view
            theView.setOutputAreaText(outPutString);

        }
    }

}


