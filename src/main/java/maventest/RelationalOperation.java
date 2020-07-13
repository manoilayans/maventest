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

public class RelationalOperation {
 
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
	  public void methodLessThan() {		  
		this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
	    
		 /* Code logic */
		 String lessThanData = (Integer.parseInt(inputTestData) < 0) ? "true" : "false";
		 System.out.println("lessThanData:"+lessThanData+"; expectedOutputData:"+expectedOutputData);
		 
		 /* Assert Check */
		 Assert.assertEquals(lessThanData, expectedOutputData);
	  }
	  
	  @Test
	  public void methodLessThanOrEqual() {
		 this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
		 
		 /* Code logic */
		 String lessThanOrEqualData = (Integer.parseInt(inputTestData) <= 0) ? "true" : "false";
		 System.out.println("lessThanOrEqualData:"+lessThanOrEqualData+"; expectedOutputData:"+expectedOutputData);
		 
		 /* Assert Check */
		 Assert.assertEquals(lessThanOrEqualData, expectedOutputData);
	  }  
	  
	  @Test
	  public void methodGreaterThan() {
		 this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
		 
		 /* Code logic */
		 String greaterThanData = (Integer.parseInt(inputTestData) > 0) ? "true" : "false";
		 System.out.println("greaterThanData:"+greaterThanData+"; expectedOutputData:"+expectedOutputData);
		 
		 /* Assert Check */
		 Assert.assertEquals(greaterThanData, expectedOutputData);
	  } 
	  
	  @Test
	  public void methodGreaterThanOrEqual() {
		 this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
		 
		 /* Code logic */
		 String greaterThanOrEqualData = (Integer.parseInt(inputTestData) >= 0) ? "true" : "false";
		 System.out.println("greaterThanOrEqualData:"+greaterThanOrEqualData+"; expectedOutputData:"+expectedOutputData);
		 
		 /* Assert Check */
		 Assert.assertEquals(greaterThanOrEqualData, expectedOutputData);
	  } 
	  

}