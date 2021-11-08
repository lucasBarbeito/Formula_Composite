package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.Operator;

import java.util.ArrayList;

public class Expression implements Evaluable {
    ArrayList<Evaluable> evaluables;
    Operator operator;

    public Expression(ArrayList<Evaluable> evaluables, Operator operator){
        this.evaluables = evaluables;
        this.operator = operator;
    }


    @Override
    public double evaluate() {
        Solver solver = new Solver();
        return solver.solve(evaluables,operator);
    }

    public ArrayList<Evaluable> getEvaluables() {
        return evaluables;
    }

    public Operator getOperator() {
        return operator;
    }
}
