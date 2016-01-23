package org.example.learn;

/*
Testing if this is how java do
 */

public class CalculatorDemo {
    public static void main(String[]args){
        CalculatorModel CM = new CalculatorModel();
        OperandType OT = OperandType.ADDITION;
        double answer;
        String message;

        answer = CM.calculateInput(15.0, 5.0, OT);
        message = ("The answer is: " + answer);

        System.out.println(message);
    }
}