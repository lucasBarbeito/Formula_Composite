package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.SumOperator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Double result = 7d;

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Double result = 6d;

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Double result = 13.5;

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Double result = 20.25;

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Double result = 6d;

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double result = 136d;

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double result = 136d;

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Double result = 0d;

        assertThat(result, equalTo(0d));
    }

    @Test
    public void myResolutionTest(){
        Operator sum = new SumOperator();
        Evaluable value1 = new Operand(52);
        Evaluable value2 = new Operand(5);
        Evaluable value3 = new Operand(24);
        Evaluable value4 = new Operand("x");
        ArrayList<Evaluable> list = new ArrayList<>();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        list.add(value4);
        Evaluable expression = new Expression(list,sum);
        System.out.println(expression.evaluate());

    }
}
