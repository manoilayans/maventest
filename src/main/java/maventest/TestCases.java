package maventest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {
	
	/* Sample Method to Perform Addition Operation */
	@Test
	public static void methodAdd() {
		int data =5, expected = 10;
		System.out.println("\nAddition Operation: ");
		System.out.println("\nInput: "+data+"; Expected Output: "+expected);
		int calculated = data + data;		
		System.out.println("\nCalculated: "+calculated+"; Expected Output: "+expected);
		Assert.assertEquals(calculated, expected);
	}
	
	/* Sample Method to Perform Multiplication Operation */
	@Test
	public static void methodMul() {
		int data =5, expected = 25;
		System.out.println("\nMultiplication Operation: ");
		System.out.println("\nInput: "+data+"; Expected Output: "+expected);
		int calculated = data * data;
		System.out.println("\nCalculated: "+calculated+"; Expected Output: "+expected);
		Assert.assertEquals(calculated, expected);
	}
	
	/* Sample Method to Perform Subtraction Operation */
	@Test
	public static void methodSub() {
		int data =5, expected = 0;
		System.out.println("\nSubtraction Operation: ");
		System.out.println("\nInput: "+data+"; Expected Output: "+expected);
		int calculated = data - data;
		System.out.println("\nCalculated: "+calculated+"; Expected Output: "+expected);
		Assert.assertEquals(calculated, expected);
	}
	
	/* Sample Method to Perform Division Operation */
	@Test
	public static void methodDiv() {
		int data =5, expected = 1;
		System.out.println("\nDivision Operation: ");
		System.out.println("\nInput: "+data+"; Expected Output: "+expected);
		int calculated = data / data;
		System.out.println("\nCalculated: "+calculated+"; Expected Output: "+expected);
		Assert.assertEquals(calculated, expected);
	}
	
	/* Sample Method to Perform Square Root Operation */
	@Test
	public static void methodSqr() {
		int data =25, expected = 5;
		System.out.println("\nSquare Root Operation: ");
		System.out.println("\nInput: "+data+"; Expected Output: "+expected);
		int calculated = (int) Math.sqrt(data);
		System.out.println("\nCalculated: "+calculated+"; Expected Output: "+expected);
		Assert.assertEquals(calculated, expected);
	}
}
