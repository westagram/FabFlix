package fabflix;

import java.io.File;
import java.util.Scanner;

public class LogProcessor {
	
	private static Scanner x;
	
	public static void main(String[] args) {
		
		Class c = null;
		try {
			c = Class.forName("MyClass");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Package: " + c.getPackage());
		/*
	
		try {
			x = new Scanner(new File("/home/ubuntu/tomcat/bin/log.txt"));
		}
		catch(Exception e) {	
		}
		
		while(x.hasNext()) {
			String result = x.next();
			System.out.println("Result: " + result);
		}
		
		x.close();
		*/
	}

}
