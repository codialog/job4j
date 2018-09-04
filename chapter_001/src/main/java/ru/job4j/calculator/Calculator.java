package ru.job4j.calculator;

/**
 * Calculator.
 * <p>
 * Класс для расчета простых арифметических выражений.
 *
 * @author Druzhinin Vladimir (mailto:dialog.txt@gmail.com)
 * @version 1
 * @since 04.9.2018
 */
public class Calculator {
    private double result;

    /**
     * Method sum - сложение.
     *
     * @param first - дробное слогаемое число.
     * @param second - дробное слогаемое число.
     */
    public void sum(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method dif - вычитание.
     *
     * @param first - дробное уменьшаемое число.
     * @param second - дробное вычитаемое число.
     */
    public void dif(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method mult - умножение.
     *
     * @param first - дробное число множитель.
     * @param second - дробное число множитель.
     */
    public void mult(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method div - диление.
     *
     * @param first - дробное делимое число.
     * @param second - дробное число делитель.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method getResult - полчение результата.
     *
     * @return - результат математического выражения
     */
    public double getResult() {
        return this.result;
    }
}
