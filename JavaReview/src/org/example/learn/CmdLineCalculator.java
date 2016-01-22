package org.example.learn;

import org.example.learn.CalculatorModel;
import org.example.learn.OperandType;

/*
Testing if this is how java do
 */

public class CmdLineCalculator{
    public static void main(String[]args){
        CalculatorModel CM = new CalculatorModel();
        OperandType OT = OperandType.ADDITION;
        double speg;
        String dogspeg;

        speg = CM.calculateInput(15.0, 5.0, OT);
        dogspeg = ("The answer is: " + speg);

        System.out.println(dogspeg);
    }
}