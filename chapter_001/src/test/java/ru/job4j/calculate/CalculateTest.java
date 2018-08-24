package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Druzhinin Vladimir (mailto:dialog.txt@gmail.com)
* @since 24.08.2018
* @version $Id$
* @since 0.1
*/

public class CalculateTest {
	/**
	* Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Vladimir Druzhinin";
		String expect = "Echo, echo, echo : " + input;
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}