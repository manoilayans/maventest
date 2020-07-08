package maventest;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
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

	private String testCaseNumber;
	private String sampleInput;
	private String sampleOutput;
	private String testCaseFlag;
	private String classAndMethodName;

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
				testCaseFlag = line.split(",")[4].toLowerCase();
				
				if (testCaseNumber != null && testCaseFlag.equals("true")) {
					
					classAndMethodName = line.split(",")[1];
					sampleInput = line.split(",")[2].toLowerCase();
					sampleOutput = line.split(",")[3].toLowerCase();
					
					System.out.println("\n"+ this.toString());			
				
					String[] value;
					Object obj = new Object();
					System.out.println("Class & Method to Invoke : " + classAndMethodName);
					value = classAndMethodName.split("\\.");
					String classvalue = value[0];
					String methodValue = value[1];
					Class className = Class.forName("maventest."+classvalue);				
					
					Method method = className.getDeclaredMethod(methodValue);
					method.invoke(obj);
				}
			}

			fr.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "TEST DATA- [ testCaseNumber= " + testCaseNumber + ", classAndMethodName=" + classAndMethodName +  ", sampleInput=" + sampleInput + ", sampleOutput=" + sampleOutput + ", testCaseFlag="
				+ testCaseFlag + "]";
	}
	
	

}




