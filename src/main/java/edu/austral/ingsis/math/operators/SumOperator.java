package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Evaluable;
import edu.austral.ingsis.math.Operand;

import java.util.List;
import java.util.Scanner;

public class SumOperator implements Operator{

    private final char name = '+';

    @Override
    public double evaluate(List<Evaluable> evaluableList) {
        double result = 0;
        for (Evaluable evaluable : evaluableList){
            if (Double.isNaN(evaluable.evaluate())){
                result+=0;
            }else {
                result += evaluable.evaluate();
            }
        }
        return result;
    }

    @Override
    public char getName() {
        return name;
    }
}
