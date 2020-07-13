package maventest;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class LoadFileFromGit {
	
	static ArrayList<String> classAndMethodList = new ArrayList<String>();
	static boolean readTestCaseFromGitFlag = false;
	public static void readTestCaseFromGit() throws AWTException, MalformedURLException {

		String line= null;
		String testCaseNumber;
		String testCaseClassMethod;
		
		/* Load Testcases only one in a TestSuite 
		 * Otherwise skip the Fileread operation */
		if (!readTestCaseFromGitFlag) {		
			System.out.println("readTestCaseFromGIT and Store the details into Array !");
			
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
	
	public static boolean isClassMethodEligible(String className, String methodName) {
		
		String[] identifyClass = className.split("\\.");
		if (identifyClass.length > 0) {
			className = identifyClass[identifyClass.length-1];			
			for (int i=0; i<classAndMethodList.size(); i++) {
				if ((className+"."+methodName).equals(classAndMethodList.get(i))) {
					
					System.out.println("Allowed:"+classAndMethodList.get(i));
					return true;
				}
			}
			
		} 		
		
		System.out.println("NotAllowed:"+className+"."+methodName);
		return false;
	}

}




