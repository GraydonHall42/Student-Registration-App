package mvcCalculator;

public class CalculatorModel {
    private int result;

    public void addTwoNumbers(int a, int b){
        result = a + b;
    }

    public int getResult() {
        return result;
    }
}
