package maventest;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import maventest.LoadFileFromGit;

public class LogicalOperation {
 
  
	@BeforeSuite
	public void beforeSuite() throws MalformedURLException, AWTException {
		LoadFileFromGit.readTestCaseFromGit();
	}	
	
	/* 
	 * true - Valid Method to Execute the Test Case as per JIRA
	 * false - Invalid Method / Not Enabled as per JIRA
	 * */
	 public boolean isMethodAllowed (String methodName){
	  if( LoadFileFromGit.isClassMethodEligible(this.getClass().toString(), methodName)) {
		  return false;
      } 
	  
	  throw new SkipException(methodName);
     }

	  @Test
	  public void methodOr() {		  
		this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
	    
	    Assert.assertEquals("1","1");
	  }
	  
	  @Test
	  public void methodAnd() {
		 this.isMethodAllowed(new Throwable().getStackTrace()[0].getMethodName());
		 
		 Assert.assertEquals("1","1");
	  }  
	  

}