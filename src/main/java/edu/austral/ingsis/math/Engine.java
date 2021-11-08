package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Operator sum = new SumOperator();
        Operator substract = new SubstractOperator();
        Operator mult = new MultiplyOperator();
        Operator div = new DivisionOperator();
        Evaluable value1 = new Operand(52);
        Evaluable value2 = new Operand(5);
        Evaluable value3 = new Operand(24);
        Evaluable value4 = new Operand("x");
        ArrayList<Evaluable> list1 = new ArrayList<>();
        list1.add(value1);
        list1.add(value2);
        list1.add(value3);
        list1.add(value4);
        Evaluable value5 = new Operand(52);
        Evaluable value6 = new Operand("y");
        ArrayList<Evaluable> list2 = new ArrayList<>();
        list2.add(value5);
        list2.add(value6);
        Expression expression1 = new Expression(list1,mult);
        Expression expression2 = new Expression(list2,substract);
        ArrayList<Evaluable> list = new ArrayList<>();
        list.add(expression1);
        list.add(expression2);
        Expression expression = new Expression(list,div);
        checkExpressions(expression);
        System.out.println(expression.evaluate());
    }

    private static void checkExpressions(Expression expression){
        ArrayList<Evaluable> expressions = expression.getEvaluables();
        for (Evaluable evaluable : expressions){
            if (evaluable instanceof Operand){
                if (Double.isNaN(evaluable.evaluate())){
                    System.out.println("Must define a value for variable "+ ((Operand) evaluable).getName());
                    ((Operand) evaluable).setValue(scanner.nextDouble());
                }
            }else {
                checkExpressions((Expression) evaluable);
            }
        }
    }
}
