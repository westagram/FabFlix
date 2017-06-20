import java.io.File;
import java.util.Scanner;

public class logparser {
	
private static Scanner x;
	
	public static void main(String[] args) {
		
		try {
			x = new Scanner(new File("/home/ubuntu/tomcat/bin/log.txt"));
		}
		catch(Exception e) {	
		}
		
		long TStotal = 0;
		long TJtotal = 0;
		int totalTests = 0;
		
		while(x.hasNext()) {
			String[] line = x.next().split(":");

			if(line[0].equals("JDBCTimeElapsed")) {
				TJtotal += Long.parseLong(line[1]);
				totalTests++;
			}
			else
				TStotal += Long.parseLong(line[1]);
		}
		
		//long TS = (TStotal / totalTests)/1000000;
		//long TJ = (TJtotal / totalTests)/1000000;
		
		double TS = TStotal / totalTests;
		double TJ = TJtotal / totalTests;
		
		System.out.println("TS total time: " + TStotal);
		System.out.println("Total tests: " + totalTests);

		System.out.println("TS: " + TS/1000000);
		System.out.println("TJ: " + TJ/1000000);
		
		x.close();
		
	}

}
