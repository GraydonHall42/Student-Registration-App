package mvcCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    CalculatorView theView;

    CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        theView.addCalculatorListener(new CalculateListener());
    }

    // inner class
    class CalculateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int firstNumber = 0;
            int secondNumber = 0;
            try{
                // reading data from the view
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();

                // invoking the model for the calculations
                theModel.addTwoNumbers(firstNumber, secondNumber);

                // write to DB here if we ever had a database

                // reading results from the model
                int solution = theModel.getResult();

                // passing results to the view
                theView.setTheSolution(solution);
            }catch(NumberFormatException err){
                theView.displayErrorMessage("Error: Must enter a number");
            }
        }
    }


}
