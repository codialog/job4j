package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CalculatorTest.
 *
 * @author Druzhinin Vladimir (mailto:dialog.txt@gmail.com)
 * @version $Id$
 * @since 04.09.2018
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Test сложения.
     */
    @Test
    public void whenSumOneAndOneThenTwo() {
        Calculator calc = new Calculator();
        calc.sum(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test вычитания.
     */
    @Test
    public void whenDifTwoAndOneThenTwo() {
        Calculator calc = new Calculator();
        calc.dif(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test умножения.
     */
    @Test
    public void whenMultTwoAndTwoThenFour() {
        Calculator calc = new Calculator();
        calc.mult(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    /**
     * Test деления.
     */
    @Test
    public void whenDivSixAndTwoThenThree() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }
}
