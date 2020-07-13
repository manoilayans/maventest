package maventest;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.apache.maven.surefire.booter.SystemUtils;

public class LoadFileFromGit {
	
	static ArrayList<String> classAndMethodList = new ArrayList<String>();
	static ArrayList<String> inputTestDataList = new ArrayList<String>();
	static ArrayList<String> expOutputDataList = new ArrayList<String>();
	static boolean readTestCaseFromGitFlag = false;
	public static void readTestCaseFromGit() throws AWTException, IOException {

		String line= null;
		String testCaseNumber;
		String testCaseClassMethod;
		
		/* Load Testcases only one in a TestSuite 
		 * Otherwise skip the Fileread operation */
		if (!readTestCaseFromGitFlag) {		
			System.out.println("readTestCaseFromGIT and Store the details into Array !");
			
			/* Getting Hostname */
			String hostname = new BufferedReader(
				    new InputStreamReader(Runtime.getRuntime().exec("hostname").getInputStream()))
				   .readLine();
			String os = System.getProperty("os.name");

	        System.out.println("OS:" + os);
	        System.out.println("HostName:" + hostname);
	        
			try {
	
				String path = System.getProperty("user.dir");
				System.out.println(path + "\\testcaselist.csv");
				File file = new File(path + "\\testcaselist.csv");
	
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				while ((line = br.readLine()) != null) {
					testCaseNumber = line.split(",")[0].toLowerCase();				
					testCaseClassMethod = line.split(",")[1];
					
					if (testCaseNumber != null && !testCaseClassMethod.equals("")) {
						
						/* Store input Test Data into Array */
						inputTestDataList.add(line.split(",")[2]);
						
						/* Store expected Output Test Data into Array */
						expOutputDataList.add(line.split(",")[3]);
						
						/* Store Class & Method into Array */		
						classAndMethodList.add(testCaseClassMethod);
					}
				}
				
				/* Set Flag as True */
				readTestCaseFromGitFlag = true;
						
				fr.close();
	
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static int isClassMethodEligible(String className, String methodName) {
		
		String[] identifyClass = className.split("\\.");
		if (identifyClass.length > 0) {
			className = identifyClass[identifyClass.length-1];			
			for (int i=0; i<classAndMethodList.size(); i++) {
				if ((className+"."+methodName).equals(classAndMethodList.get(i))) {
					
					//System.out.println("Allowed:"+classAndMethodList.get(i));
					//System.out.println("Allowed index:"+i);
					/* In case class & method name valid then return the index position of the Array */
					return i;
				}
			}
			
		} 		
		
		//System.out.println("NotAllowed:"+className+"."+methodName);
		/* In case class & method name Invalid then return -1 as position */
		return -1;
	}

}




