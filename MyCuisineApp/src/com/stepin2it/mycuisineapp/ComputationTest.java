package com.stepin2it.mycuisineapp;

import org.junit.Test;

import junit.framework.TestCase;

public class ComputationTest extends TestCase {
 private final static String TAG = "ComputationTest";
	@Test
	public void testMultiply() 
	{
	   MyClass tester = new MyClass();
	   assertEquals(50, tester.multiply(10,5));
	   
	}
	
	@Test
	public void testDivide()
	{
		MyClass tester = new MyClass();
		assertEquals(5, tester.divide(10, 2));
	}
	
}
