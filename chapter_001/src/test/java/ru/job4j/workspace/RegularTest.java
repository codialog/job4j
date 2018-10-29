package ru.job4j.workspace;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class RegularTest {

    @Test
    public void whenAdultWordsInItem() {
            Regular regular = new Regular();
        assertThat(regular.checkItemNameForAdultWords("Do you wona Masturbator"), is(true));
    }
    @Test
    public void whenAdultWordsInItem1() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForAdultWords("Do you wona suck"), is(false));
    }
    @Test
    public void whenAdultWordsInItem2() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForAdultWords("He is Dildo"), is(true));
    }
    @Test
    public void whenAdultWordsInItem3() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForAdultWords("He is Doldon"), is(false));
    }
    @Test
    public void whenAdultWordsInItem4() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForAdultWords("Do you have Vibrator?"), is(true));
    }
    @Test
    public void whenAdultWordsInItem5() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForAdultWords("Do you have Vibraher?"), is(false));
    }
    @Test
    public void whenAdultWordsInItem6() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForAdultWords("Hi Dildo! Do you have Vibrator?"), is(true));
    }
}