package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    static Scanner scanner = new Scanner(System.in);
    static Operator sum = new SumOperator();
    static Operator substract = new SubstractOperator();
    static Operator mult = new MultiplyOperator();
    static Operator div = new DivisionOperator();
    static Operator power = new ExponentOperator();

    public static void main(String[] args) {
        ArrayList<Expression> expressions = new ArrayList<>();
        createExpressions(expressions);
        String repeat = "Y";

        do {
            System.out.println("Choose an equation");
            System.out.println("1) 1 + x ");
            System.out.println("2) 12 / div");
            System.out.println("3) (9 / x) * y");
            System.out.println("4) (27 / a) ^ b");
            System.out.println("5) z ^ (1/2)");
            System.out.println("6) [(52*5*24*x)^(5-y)]^3");
            switch (scanner.nextInt() -1){
                case 0:
                    checkExpressions(expressions.get(0));
                    System.out.println(expressions.get(0).evaluate());
                    break;
                case 1:
                    checkExpressions(expressions.get(1));
                    System.out.println(expressions.get(1).evaluate());
                    break;
                case 2:
                    checkExpressions(expressions.get(2));
                    System.out.println(expressions.get(2).evaluate());
                    break;
                case 3:
                    checkExpressions(expressions.get(3));
                    System.out.println(expressions.get(3).evaluate());
                    break;
                case 4:
                    checkExpressions(expressions.get(4));
                    System.out.println(expressions.get(4).evaluate());
                    break;
                case 5:
                    checkExpressions(expressions.get(5));
                    System.out.println(expressions.get(5).evaluate());
                    break;
            }
            System.out.println("Do you want to try again? Press Y");
            repeat = scanner.nextLine();
        }while (repeat.equals("Y"));
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

    private static void createExpressions(ArrayList<Expression> expressions){
        Evaluable value11 = new Operand(1);
        Evaluable value12 = new Operand("x");
        ArrayList<Evaluable> list1 = new ArrayList<>();
        list1.add(value11);
        list1.add(value12);
        Expression expression1 = new Expression(list1,sum);
        expressions.add(expression1);

        Evaluable value21 = new Operand(12);
        Evaluable value22 = new Operand("div");
        ArrayList<Evaluable> list2 = new ArrayList<>();
        list2.add(value21);
        list2.add(value22);
        Expression expression2 = new Expression(list2,div);
        expressions.add(expression2);

        Operand value31 = new Operand(9);
        Operand value32 = new Operand("x");
        ArrayList list31 = new ArrayList();
        list31.add(value31);
        list31.add(value32);
        Expression expression31 = new Expression(list31,div);
        Operand value33 = new Operand("y",4);
        ArrayList list32 = new ArrayList();
        list32.add(expression31);
        list32.add(value33);
        Expression expression3 = new Expression(list32,mult);
        expressions.add(expression3);

        Operand value41 = new Operand(27);
        Operand value42 = new Operand("a");
        ArrayList list41 = new ArrayList();
        list41.add(value41);
        list41.add(value42);
        Expression expression41 = new Expression(list41,div);
        Operand value43 = new Operand("b");
        ArrayList list42 = new ArrayList();
        list42.add(expression41);
        list42.add(value43);
        Expression expression4 = new Expression(list42,power);
        expressions.add(expression4);

        Operand value51 = new Operand("z");
        Operand value52 = new Operand(1);
        Operand value53 = new Operand(2);
        ArrayList list51 = new ArrayList();
        list51.add(value52);
        list51.add(value53);
        Expression expression51 = new Expression(list51,div);
        ArrayList list52 = new ArrayList();
        list52.add(value51);
        list52.add(expression51);
        Expression expression5 = new Expression(list52,power);
        expressions.add(expression5);

        Evaluable value61 = new Operand(52);
        Evaluable value62 = new Operand(5);
        Evaluable value63 = new Operand(24);
        Evaluable value64 = new Operand("x");
        ArrayList<Evaluable> list61 = new ArrayList<>();
        list61.add(value61);
        list61.add(value62);
        list61.add(value63);
        list61.add(value64);
        Evaluable value65 = new Operand(5);
        Evaluable value66 = new Operand("y");
        ArrayList<Evaluable> list62 = new ArrayList<>();
        list62.add(value65);
        list62.add(value66);
        Expression expression61 = new Expression(list61,mult);
        Expression expression62 = new Expression(list62,substract);
        ArrayList<Evaluable> list63 = new ArrayList<>();
        list63.add(expression61);
        list63.add(expression62);
        Expression expression63 = new Expression(list63,power);
        Evaluable value67 = new Operand(3);
        ArrayList<Evaluable> list64 = new ArrayList<>();
        list64.add(expression63);
        list64.add(value67);
        Expression expression6 = new Expression(list64,power);
        expressions.add(expression6);





    }
}
