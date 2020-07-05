package maventest;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class maventest {
	
	private String testCaseName;
	private String methodName;
	private String testCaseNumber;
	private String sampleInput;
	private String sampleOutput;
	private String testCaseFlag;

	@Test(priority=1)
	public void readTestCaseFromGit() throws AWTException, MalformedURLException {
		
		   WebDriver driver;

		   String line= null,user = null,pass = null;

	      
		   try {
		
			  
			   String path = System.getProperty("user.dir");
			      System.out.println(path + "\\testcaselist.txt");
			      File file = new File(path + "\\testcaselist.txt");
		

			           FileReader fr = new FileReader(file);
			           BufferedReader br = new BufferedReader(fr);
			           
			         
			          while ((line = br.readLine()) != null) {
			        	  
			              testCaseNumber = line.split(",")[0].toLowerCase();
			              methodName = line.split(",")[1].toLowerCase();
			              sampleInput = line.split(",")[2].toLowerCase();
			              sampleOutput = line.split(",")[3].toLowerCase();
			              testCaseFlag = line.split(",")[4].toLowerCase();
						    
			              System.out.println("\n"+ this.toString());
			           
			              }
			          
			          fr.close();

			   }catch(Exception e){
			   e.printStackTrace();
			       }
		
	      
	      
	    

	
	}

	@Override
	public String toString() {
		return "TEST DATA- [testCaseName=" + testCaseName + ", methodName=" + methodName + ", testCaseNumber="
				+ testCaseNumber + ", sampleInput=" + sampleInput + ", sampleOutput=" + sampleOutput + ", testCaseFlag="
				+ testCaseFlag + "]";
	}
	
}

    		  
    		  
    		  
    		  