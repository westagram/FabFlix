Load Balancers:
	Google Cloud IP Address: 35.184.206.150
	AWS IP Address: 34.210.38.183

Master Instance IP Address: 34.210.39.192
Slave Instance IP Address: 34.210.220.1

Access fabflix through this URL and replace “IP” with either the Google Cloud IP address or the AWS IP address (the load balancers). Tomcat must be turned on for both the master and slave instances.
	http://IP/fabflix_webapp/

Task 3: Measuring the performance of Fabflix search feature

	The script that parses the time of each servlet and JDBC run and calculates the TS and TJ can be found at the root of the war file. The log file is automatically stored in the "/home/ubuntu/tomcat/bin/log.txt" of the AWS server. In order to run the log parser and calculator, compile the program with:
 
	javac logparser.java

	Then, run the program with: 

	java logparser