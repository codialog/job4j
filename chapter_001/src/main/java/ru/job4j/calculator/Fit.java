package ru.job4j.calculator;

/**
 * Calculator.
 * <p>
 * Программа расчета идеального веса.
 *
 * @author Druzhinin Vladimir (mailto:dialog.txt@gmail.com)
 * @since 04.9.2018
 */
public class Fit {

    /**
     * Идеальный вес для мужщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}