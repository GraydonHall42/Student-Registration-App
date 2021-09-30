package mvcCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameFormTest extends JFrame{
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JButton btnOkay;
    private JButton btnClear;
    private JLabel tfWelcome;
    private JPanel mainPanel;

    public NameFormTest(){
        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize(450,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // action listener for our okay button
        btnOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = tfFirstName.getText();
                String lName = tfLastName.getText();
                tfWelcome.setText("Welcome " + fName + " " + lName);
            }
        });

        // action listener for our clear button
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfWelcome.setText("");
            }
        });
    }

    public static void main(String[] args) {
        NameFormTest myFrame = new NameFormTest();
    }
}
