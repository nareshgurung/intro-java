package com.example.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class CalculatorTest {
	static Calculator calc;
	
	@BeforeClass
	public static void setupBeforeClass() throws Exception{
		System.out.println("this runs before any tests");
		calc = new Calculator();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println("This runs after the entire class is finished");
	}
	@Before 
	public void setup() throws Exception{
		System.out.println("This runs before every test");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("This runs after every test");
	}
	@Test
	public void positiveAdditionTest() {
		// asserEquals(String message, expected, actuals
		assertEquals("Testing 2+2=4", 4, calc.add(2, 2));
	}
	public void negetiveAdditionTest() {
		assertNotEquals("testing 2+3 != 4", 4, calc.add(2,3));
	}
	@Ignore 
	//@Test
	public void subTest() {
		assertEquals("Testing 3-1=2", 2, calc.sub(3, 1));
	}
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		calc.devide(2,0);
	}
}
