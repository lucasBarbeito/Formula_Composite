package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Evaluable;

import java.util.List;

public interface Operator {
    public double evaluate(List<Evaluable> evaluableList);
    public char getName();
}
