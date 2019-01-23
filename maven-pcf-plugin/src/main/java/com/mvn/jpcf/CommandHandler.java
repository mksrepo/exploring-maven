package com.mvn.jpcf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandHandler {

	public static String cfPush() {
		StringBuilder messageBuilder = new StringBuilder();
		try {

			String command = "/usr/local/bin/cf login -a https://api.run.pivotal.io -u mrinmay.santra@cognizant.com -p Password@11 -o MS-COE -s development";
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			System.out.println("Here is the standard output of the command:\n");
			String line;
			while ((line = stdInput.readLine()) != null) {
				messageBuilder.append(line);
			}
			command = "/usr/local/bin/cf push apartment-service -p /Users/mrinmaysantra/git/springboot/apartment-parent/apartment-user-service/target/apartment-user-service-1.0-SNAPSHOT.jar\n";
			p = Runtime.getRuntime().exec(command);
			while ((line = stdInput.readLine()) != null) {
				messageBuilder.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageBuilder.toString();
	}

}
