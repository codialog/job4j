package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    int EURO = 70;
    int DOLLAR = 60;

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / EURO;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / DOLLAR;
    }

    /**
     * Конвертируем рубли в евро.
     *
     * @param value евро.
     * @return рубль.
     */
    public int euroToRuble(int value) {
        return value * EURO;
    }

    /**
     * Конвертация евро в рубли.
     *
     * @param value евро.
     * @return Доллары
     */
    public int DollarToRuble(int value) {
        return value * DOLLAR;
    }
}

