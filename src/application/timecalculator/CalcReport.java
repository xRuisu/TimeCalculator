package application.timecalculator;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class CalcReport {

	//Gets users desktop destination
	private static String sysDest = System.getProperty("user.home") + "/Desktop//TimeReport.txt";

	//Handles both methods in one.
	public static void fileReport() {
		createReport();
		writeReport();
	}

	//Create users report file
	private static void createReport() {
		try {			
			var file = new File((sysDest));
			if (file.createNewFile()) { print("Report filed: " + file.getName());
			} else { print("Report already exists, report was overwritten."); }
		} catch (IOException e) { 
			print("Program error occured"); 
			e.printStackTrace(); 
		}
	}

	//Writes to the users report file
	private static void writeReport() {
		try { 
			var myWriter = new FileWriter((sysDest));
			myWriter.write(Calc.getReport()); myWriter.close();
		} catch (IOException e) { print("An error occurred.");
		e.printStackTrace();
		}
	}

	private static void print(String text) {
		System.out.println(text);
	}
}