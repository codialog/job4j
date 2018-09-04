package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Тест калькулятора идеального веса.
 *
 * @author Druzhinin Vladimir (mailto:dialog.txt@gmail.com)
 * @version $Id$
 * @since 04.09.2018
 */
public class FitTest {
    /**
     * Тест расчета идеального веса для мужчин.
     */
    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Тест расчета идеального веса для женщин.
     */
    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
