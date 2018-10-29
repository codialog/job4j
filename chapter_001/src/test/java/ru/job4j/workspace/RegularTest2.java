package ru.job4j.workspace;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RegularTest2 {
    String word1 = "Price";
    String word2 = "difference";
    String word3 = "Payment";
    String word4 = "Extra";
    String word5 = "costs";

    @Test
    public void whenPaymentWordsInItem1() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word1 + " is the placeholder text automatically generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem2() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word2 + " is the placeholder text automatically generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem3() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word3 + " is the placeholder text automatically generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem4() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word4 + " is the placeholder text automatically generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem5() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word5 + " is the placeholder text automatically generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem6() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word1 + " is the placeholder text " + word2 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem7() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word2 + " " + word1 + " is the placeholder text"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem8() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word2 + " is the placeholder text " + word2 + " generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem9() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word2 + " " + word3 + " is the placeholder text"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem10() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word3 + " is the placeholder text " + word4 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem11() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word4 + " is the placeholder text " + word5 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem12() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word5 + " is the placeholder text " + word4 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem13() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word4 + " " + word3 + " is the placeholder text"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem14() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word3 + " is the placeholder text " + word2 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem15() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word1 + " is the placeholder text " + word5 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem16() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word1 + " is the placeholder text " + word4 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem17() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word1 + " is the placeholder text " + word3 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem18() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word1 + " is the placeholder text " + word1 + " generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem19() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word2 + " is the placeholder text " + word1 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem20() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word2 + " is the placeholder text " + word4 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem21() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word2 + " is the placeholder text " + word5 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem22() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word3 + " is the placeholder text " + word3 + " generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem23() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word3 + " is the placeholder text " + word1 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem24() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word3 + " is the placeholder text " + word5 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem25() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word4 + " is the placeholder text " + word1 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem26() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word4 + " is the placeholder text " + word2 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem27() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word4 + " is the placeholder text " + word4 + " generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem28() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word5 + " is the placeholder text " + word5 + " generated"), is(false));
    }

    @Test
    public void whenPaymentWordsInItem29() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word5 + " is the placeholder text " + word1 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem30() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word5 + " is the placeholder text " + word2 + " generated"), is(true));
    }

    @Test
    public void whenPaymentWordsInItem31() {
        Regular regular = new Regular();
        assertThat(regular.checkItemNameForPaymentWords("Sample " + word5 + " is the placeholder text " + word3 + " generated"), is(true));
    }
}
