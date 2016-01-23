package org.example.learn;

/**
 * Created by point on 1/21/2016.
 */

enum OperandType {ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION}

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
