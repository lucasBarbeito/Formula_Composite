package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Evaluable;

import java.util.List;

public class MultiplyOperator implements Operator{
    private final char name = '*';

    @Override
    public double evaluate(List<Evaluable> evaluableList) {
        double result = 0;
        for (int i = 0; i < evaluableList.size(); i++){
            if (!Double.isNaN(evaluableList.get(i).evaluate())){
                if (i == 0){
                    result = evaluableList.get(0).evaluate();
                }else {
                    result *= evaluableList.get(i).evaluate();
                }
            }
        }
        return result;
    }

    @Override
    public char getName() {
        return name;
    }
}
