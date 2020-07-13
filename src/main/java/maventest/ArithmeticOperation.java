package maventest;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import maventest.LoadFileFromGit;

public class ArithmeticOperation {
	
	private String inputTestData;
	private String expectedOutputData;
	private int indexPosition;
  
	@BeforeSuite
	public void beforeSuite() throws AWTException, IOException {
		LoadFileFromGit.readTestCaseFromGit();
	}	
	
	/* 
	 * true - Valid Method to Execute the Test Case as per JIRA
	 * false - Invalid Method / Not Enabled as per JIRA
	 * */
	 public boolean isMethodAllowed (String methodName){
		 indexPosition = LoadFileFromGit.isClassMethodEligible(this.getClass().toString(), methodName);		 
		 
		 if(indexPosition != -1 ) {
			 inputTestData = LoadFileFromGit.inputTestDataList.get(indexPosition);
			 expectedOutputData = LoadFileFromGit.expOutputDataList.get(indexPosition);
			 
			 /* Return true to Start execute the Code logic present in the Method */
			 return true;
	     } 
		  
		 throw new SkipException(methodName);
     }

	  @Test
	  public void methodAdd() {		  
		this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
	    
		/* Code logic */
		int addData = Integer.parseInt(inputTestData) + Integer.parseInt(inputTestData);
		System.out.println("addData:"+addData+"; expectedOutputData:"+Integer.parseInt(expectedOutputData));
		
		/* Assert Check */
		Assert.assertEquals(addData, Integer.parseInt(expectedOutputData));
	  }
	  
	  @Test
	  public void methodSub() {
		 this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
		 
		 /* Code logic */
		 int subData = Integer.parseInt(inputTestData) - Integer.parseInt(inputTestData);
		 System.out.println("subData:"+subData+"; expectedOutputData:"+Integer.parseInt(expectedOutputData));
		 
		 /* Assert Check */
		 Assert.assertEquals(subData, Integer.parseInt(expectedOutputData));
	  }
	  
	  @Test
	  public void methodMul() {
		this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
		
		/* Code logic */
		int mulData = Integer.parseInt(inputTestData) * Integer.parseInt(inputTestData);
		System.out.println("mulData:"+mulData+"; expectedOutputData:"+Integer.parseInt(expectedOutputData));
		
		/* Assert Check */
		Assert.assertEquals(mulData, Integer.parseInt(expectedOutputData));
	  }	
	
	  @Test
	  public void methodDiv() {
		 this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
	    
		 /* Code logic */
		 int divData = Integer.parseInt(inputTestData) / Integer.parseInt(inputTestData);
		 System.out.println("addData:"+divData+"; expectedOutputData:"+Integer.parseInt(expectedOutputData));
			
		 /* Assert Check */
		 Assert.assertEquals(divData, Integer.parseInt(expectedOutputData));
	  }

}