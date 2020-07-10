package maventest;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class LoadFileFromGit {
	
	static ArrayList<String> classAndMethodList = new ArrayList<String>();
	public static void readTestCaseFromGit() throws AWTException, MalformedURLException {

		String line= null;
		String testCaseNumber;
		String testCaseFlag;
		String classAndMethodName;
		
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
					classAndMethodList.add(classAndMethodName);					
				}
			}

			fr.close();

		}catch(Exception e){
			e.printStackTrace();
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




