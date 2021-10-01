package View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationView extends JFrame{
    private JTextField tfStudentName;
    private JTextField tfStudentID;
    private JList optionList;
    private JTextArea outputArea;
    private JButton searchButton;
    private JButton clearButton;
    private JPanel mainPanel;
    private JButton exitButton;
    private JTextField tfCourseName;
    private JTextField tfCourseNum;
    private JTextField tfSecNum;
    private JScrollPane outputScrollPane;

    public RegistrationView(){

        String[] studentOptions = {
                "1. Search catalogue courses",
                "2. Add course to student courses",
                "3. Remove course from student courses",
                "4. View All courses in catalogue",
                "5. View all courses taken by student"};

        optionList.setListData(studentOptions);
        optionList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        optionList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        optionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // add functionality to option list
        formatOptionList();

        // add functionality to clear and close button
        formatClearCloseButtons();

        // disable search button till selection is made.
        searchButton.setEnabled(false);

        setContentPane(mainPanel);
        setTitle("Student Menu");
        setSize(450,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public boolean validateInputs(){

        // validate StudentID and secNumber
        String studentID = tfStudentID.getText();
        String secNum = tfSecNum.getText();

        // validate ID is 4 digits
        var IDLength =  studentID.length();
        if(IDLength!=4 && !studentID.equals("N/A")){
            outputArea.setText("Error: Student ID Must be a 4 digit integer");
            return false;
        }


        if(!isInteger(studentID) && !studentID.equals("N/A")){
            outputArea.setText("Error: Student ID Must be a 4 digit integer");
            return false;
        }
        else if(!secNum.equals("N/A") && !isInteger(secNum)) {
            outputArea.setText("Error: Section Number must be an integer");
            return false;
        }

        // all validations passed
        return true;

    }

    public boolean isInteger( String input ) {
        // from: https://stackoverflow.com/questions/237159/whats-the-best-way-to-check-if-a-string-represents-an-integer-in-java
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }


    private void formatClearCloseButtons() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfStudentName.setText("");
                tfStudentID.setText("");
                outputArea.setText("");
                tfCourseName.setText("");
                tfCourseNum.setText("");
                tfSecNum.setText("");
            }
        });


    }

    public void addSearchButtonListener(ActionListener listenerForSearchButton){
        searchButton.addActionListener(listenerForSearchButton);
    }

    private void formatOptionList(){
        tfCourseName.setEnabled(false);
        tfCourseName.setText("N/A");
        tfCourseNum.setEnabled(false);
        tfCourseNum.setText("N/A");
        tfSecNum.setEnabled(false);
        tfSecNum.setText("N/A");
        tfStudentID.setEnabled(false);
        tfStudentID.setText("N/A");
        tfStudentName.setEnabled(false);
        tfStudentName.setText("N/A");
        optionList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // enable search button once selection is made
                if(optionList.isSelectionEmpty()){
                    searchButton.setEnabled(false);
                }
                else {
                    searchButton.setEnabled(true);
                    switch (optionList.getSelectedIndex() + 1) {
                        case 1:
                            tfStudentID.setEnabled(false);
                            tfStudentID.setText("N/A");
                            tfStudentName.setEnabled(false);
                            tfStudentName.setText("N/A");
                            tfCourseName.setEnabled(true);
                            tfCourseName.setText("");
                            tfCourseNum.setEnabled(true);
                            tfCourseNum.setText("");
                            tfSecNum.setEnabled(false);
                            tfSecNum.setText("N/A");
                            break;
                        case 2:
                        case 3:
                            tfStudentID.setEnabled(true);
                            tfStudentID.setText("");
                            tfStudentName.setEnabled(true);
                            tfStudentName.setText("");
                            tfCourseName.setEnabled(true);
                            tfCourseName.setText("");
                            tfCourseNum.setEnabled(true);
                            tfCourseNum.setText("");
                            tfSecNum.setEnabled(true);
                            tfSecNum.setText("");
                            break;
                        case 4:
                            tfCourseName.setEnabled(false);
                            tfCourseName.setText("N/A");
                            tfCourseNum.setEnabled(false);
                            tfCourseNum.setText("N/A");
                            tfSecNum.setEnabled(false);
                            tfSecNum.setText("N/A");
                            tfStudentID.setEnabled(false);
                            tfStudentID.setText("N/A");
                            tfStudentName.setEnabled(false);
                            tfStudentName.setText("N/A");
                            break;
                        case 5:
                            tfStudentID.setEnabled(true);
                            tfStudentID.setText("");
                            tfStudentName.setEnabled(true);
                            tfStudentName.setText("");
                            tfCourseName.setEnabled(false);
                            tfCourseName.setText("N/A");
                            tfCourseNum.setEnabled(false);
                            tfCourseNum.setText("N/A");
                            tfSecNum.setEnabled(false);
                            tfSecNum.setText("N/A");
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    public String getCourseName() {
        return tfCourseName.getText();
    }

    public String getCourseNum() {
        return tfCourseNum.getText();
    }

    public String getSecNum() {
        return tfSecNum.getText();
    }

    public void setOutputAreaText(String s){
        outputArea.setText(s);
        outputArea.setCaretPosition(0);  // place caret at top
    }

    public String getStudetnName(){
        return tfStudentName.getText();
    }

    public String getStudentID(){
        return tfStudentID.getText();
    }

    public int getSelectedOption(){
        return optionList.getSelectedIndex();
    }

}
