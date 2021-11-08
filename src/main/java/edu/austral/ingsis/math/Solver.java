package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.Operator;

import java.util.ArrayList;

public class Solver {

    public double solve(ArrayList<Evaluable> evaluables, Operator operator){
        double result = 0;
        ArrayList<Double> results = new ArrayList<>();
        for (Evaluable evaluable: evaluables){
            if (evaluable instanceof Expression){
                results.add(((Expression) evaluable).getOperator().evaluate(((Expression) evaluable).getEvaluables()));
            }else {
                results.add(evaluable.evaluate());
            }
        }
        switch (operator.getName()){
            case '+':
                for (int i = 0; i < results.size(); i++){
                    if (i == 0){
                        result = results.get(0);
                    }else {
                        result += results.get(i);
                    }
                }
                break;
            case '-':
                for (int i = 0; i < results.size(); i++){
                    if (i == 0){
                        result = results.get(0);
                    }else {
                        result -= results.get(i);
                    }
                }
                break;
            case '*':
                for (int i = 0; i < results.size(); i++){
                    if (i == 0){
                        result = results.get(0);
                    }else {
                        result *= results.get(i);
                    }
                }
                break;
            case '/':
                for (int i = 0; i < results.size(); i++){
                    if (i == 0){
                        result = results.get(0);
                    }else {
                        result /= results.get(i);
                    }
                }
                break;
            case '^':
                for (int i = 0; i < results.size(); i++){
                    if (i == 0){
                        result = results.get(0);
                    }else {
                        result = Math.pow(result,results.get(i));
                    }
                }
                break;
        }
        return result;
    }

    private void cases(){

    }
}
