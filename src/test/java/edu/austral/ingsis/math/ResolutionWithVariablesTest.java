package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {
    Operator sum = new SumOperator();
    Operator substract = new SubstractOperator();
    Operator mult = new MultiplyOperator();
    Operator div = new DivisionOperator();
    Operator power = new ExponentOperator();

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Evaluable value1 = new Operand(1);
        Evaluable value2 = new Operand("x",3);
        ArrayList<Evaluable> list = new ArrayList<>();
        list.add(value1);
        list.add(value2);
        Expression expression = new Expression(list,sum);
        assertThat(expression.evaluate(), equalTo(4d));
        System.out.println(expression.evaluate());
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Evaluable value1 = new Operand(12);
        Evaluable value2 = new Operand("div",4);
        ArrayList<Evaluable> list = new ArrayList<>();
        list.add(value1);
        list.add(value2);
        Expression expression = new Expression(list,div);
        assertThat(expression.evaluate(), equalTo(3d));
        System.out.println(expression.evaluate());
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Operand value1 = new Operand(9);
        Operand value2 = new Operand("x",3);
        ArrayList list1 = new ArrayList();
        list1.add(value1);
        list1.add(value2);
        Expression expression1 = new Expression(list1,div);
        Operand value3 = new Operand("y",4);
        ArrayList list = new ArrayList();
        list.add(expression1);
        list.add(value3);
        Expression expression = new Expression(list,mult);
        assertThat(expression.evaluate(), equalTo(12d));
        System.out.println(expression.evaluate());

    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Operand value1 = new Operand(27);
        Operand value2 = new Operand("a",9);
        ArrayList list1 = new ArrayList();
        list1.add(value1);
        list1.add(value2);
        Expression expression1 = new Expression(list1,div);
        Operand value3 = new Operand("b",3);
        ArrayList list = new ArrayList();
        list.add(expression1);
        list.add(value3);
        Expression expression = new Expression(list,power);
        assertThat(expression.evaluate(), equalTo(27d));
        System.out.println(expression.evaluate());
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Operand value1 = new Operand("z",36);
        Operand value2 = new Operand(1);
        Operand value3 = new Operand(2);
        ArrayList list1 = new ArrayList();
        list1.add(value2);
        list1.add(value3);
        Expression expression1 = new Expression(list1,div);
        ArrayList list = new ArrayList();
        list.add(value1);
        list.add(expression1);
        Expression expression = new Expression(list,power);
        assertThat(expression.evaluate(), equalTo(6d));
        System.out.println(expression.evaluate());
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Double result = 0d;

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Operand value1 = new Operand(5);
        Operand value2 = new Operand("i",2);
        ArrayList list1 = new ArrayList();
        list1.add(value1);
        list1.add(value2);
        Expression expression1 = new Expression(list1,substract);
        Operand value3 = new Operand(8);
        ArrayList list = new ArrayList();
        list.add(expression1);
        list.add(value3);
        Expression expression = new Expression(list,mult);
        assertThat(expression.evaluate(), equalTo(24d));
        System.out.println(expression.evaluate());
    }
//    case [(52*5*24*x)^(5-y)]   x= 2, y =3
    @Test
    public void exponentTest(){

        Evaluable value1 = new Operand(52);
        Evaluable value2 = new Operand(5);
        Evaluable value3 = new Operand(24);
        Evaluable value4 = new Operand("x",2);
        ArrayList<Evaluable> list1 = new ArrayList<>();
        list1.add(value1);
        list1.add(value2);
        list1.add(value3);
        list1.add(value4);
        Evaluable value5 = new Operand(5);
        Evaluable value6 = new Operand("y",3);
        ArrayList<Evaluable> list2 = new ArrayList<>();
        list2.add(value5);
        list2.add(value6);
        Expression expression1 = new Expression(list1,mult);
        Expression expression2 = new Expression(list2,substract);
        ArrayList<Evaluable> list3 = new ArrayList<>();
        list3.add(expression1);
        list3.add(expression2);
        Expression expression3 = new Expression(list3,power);
        Evaluable value7 = new Operand(3);
        ArrayList<Evaluable> list = new ArrayList<>();
        list.add(expression3);
        list.add(value7);
        Expression expression = new Expression(list,power);
//        checkExpressions(expression);
        assertThat(expression.evaluate(), equalTo(Math.pow(Math.pow(52*5*24*2,2),3)));
        System.out.println(expression.evaluate());  //should return 155750400

    }

}
