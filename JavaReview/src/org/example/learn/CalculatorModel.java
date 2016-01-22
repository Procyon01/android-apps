package org.example.learn;

import org.example.learn.OperandType;

/**
 * Created by point on 1/21/2016.
 */
public class CalculatorModel {

    public double calculateInput(double in1, double in2, OperandType inOp){
       switch (inOp)
       {
           case ADDITION:
               return in1 + in2;
           case SUBTRACTION:
               return in1 - in2;
           case MULTIPLICATION:
               return in1 * in2;
           case DIVISION:
               return in1 / in2;
           default:
               return 0;
       }
    }
}
