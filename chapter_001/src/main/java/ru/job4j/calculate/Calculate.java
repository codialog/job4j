package ru.job4j.calculate;

/** Calculate.
*
* Класс для вывода теста "Hello World" на экран.
* @author Druzhinin Vladimir (mailto:dialog.txt@gmail.com)
* @since 23.08.2018
* @version 1
*/

public class Calculate {
	
	/**
	*Main.
	*@param args - массив строк.
	*/
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
 
}