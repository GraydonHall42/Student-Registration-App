package mvcCalculator;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame{
    private JTextField firstNumber = new JTextField(10);
    private JLabel addLabel = new JLabel("+");

    private JTextField secondNumber = new JTextField(10);

    private JButton calculateButton = new JButton("Calculate");

    private JTextField theSolution = new JTextField(10);

    public CalculatorView(){
        JPanel calcPanel = new JPanel();
        setSize(300, 300);

        calcPanel.add(firstNumber);
        calcPanel.add(addLabel);

        calcPanel.add(secondNumber);
        calcPanel.add(calculateButton);
        calcPanel.add(theSolution);

        this.add(calcPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public int getFirstNumber(){
        return Integer.parseInt(firstNumber.getText());
    }

    public int getSecondNumber(){
        return Integer.parseInt(secondNumber.getText());
    }

    public void setTheSolution(int solution){
        theSolution.setText(""+solution);
    }

    public void addCalculatorListener(ActionListener listenForCalculateButton){
        calculateButton.addActionListener(listenForCalculateButton);
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
