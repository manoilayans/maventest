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
	
	@Test(priority=1)
	public void testLogin() throws AWTException, MalformedURLException {
		
		   WebDriver driver;

		   String line= null,user = null,pass = null;

	      
		   try {
		
			  
			   String path = System.getProperty("user.dir");
			      System.out.println(path + "\\settings.txt");
			      File file = new File(path + "\\settings.txt");
		

			           FileReader fr = new FileReader(file);
			           BufferedReader br = new BufferedReader(fr);
			           
			         
			          while ((line = br.readLine()) != null) {
			              user = line.split(",")[0].toLowerCase();
			       pass = line.split(",")[1].toLowerCase();
			           
			              }
			          
			          fr.close();

			   }catch(Exception e){
			   e.printStackTrace();
			       }
		
	      
	      
	      System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Jenkins\\IEDriverServer.exe");
	      
	      
	    
	      DesiredCapabilities capabilities=DesiredCapabilities.internetExplorer();
	      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	      System.out.println("Debug 1");
//	      System.out.println(user);
      System.out.println(pass);
	      driver.get("http://45.76.149.118:8081/smcfs/console/login.jsp");
	      driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);	
	      driver.findElement(By.name("UserId")).sendKeys(user);

	      driver.findElement(By.name("Password")).sendKeys(pass);
	      System.out.println("Debug 2");
	      driver.findElement(By.name("btnLogin")).click();
	      driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	      System.out.println("Debug 3");	  
	      
	      String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("IBM Sterling Selling and Fulfillment Suite: Application Console"));

			driver.quit();

	
	}
	
}

    		  
    		  
    		  
    		  