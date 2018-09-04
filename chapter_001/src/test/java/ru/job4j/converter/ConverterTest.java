package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test конвертации
 *
 * @author Druzhinin Vladimir (mailto:dialog.txt@gmail.com)
 * @version $Id$
 * @since 04.09.2018
 * @since 0.1
 */
public class ConverterTest {
    /**
     * Test конвертации рублей в доллар.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    @Test
    /**
     * Test конвертации рублей в евро.
     */
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
}
