package com.bank.app;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BankTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	static calculator calcc;
	
	@Before
	public static void setupBeforeClass() throws Exception{
		calc = new Calculator();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this runs after the entire class is finished");
	}
	
	@Before
	public void setup() throws Exception {
		System.out.println("This runs before every test");
	}
	
	@After 
	public void tearDown() throws Exception {
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
