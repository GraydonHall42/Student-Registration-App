package View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentView extends JFrame{
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

    public StudentView(){

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
                            tfCourseName.setEnabled(true);
                            tfCourseName.setText("");
                            tfCourseNum.setEnabled(true);
                            tfCourseNum.setText("");
                            tfSecNum.setEnabled(false);
                            tfSecNum.setText("N/A");
                            break;
                        case 2:
                        case 3:
                            tfCourseName.setEnabled(true);
                            tfCourseName.setText("");
                            tfCourseNum.setEnabled(true);
                            tfCourseNum.setText("");
                            tfSecNum.setEnabled(true);
                            tfSecNum.setText("");
                            break;
                        case 4:
                        case 5:
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
        //this is a test comment
        // this is a test comment from GHBranch2
        //this is a test comment from main
    }

    public String getStudentID(){
        return tfStudentID.getText();
    }

    public int getSelectedOption(){
        return optionList.getSelectedIndex();
    }

}
