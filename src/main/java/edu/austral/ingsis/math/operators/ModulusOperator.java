package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Evaluable;

import java.util.List;

public class ModulusOperator implements Operator{
    private final char name = '|';

    @Override
    public double evaluate(List<Evaluable> evaluableList) {
        return 0;
    }

    @Override
    public char getName() {
        return name;
    }
}
