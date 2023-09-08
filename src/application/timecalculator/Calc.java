package application.timecalculator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Calc implements Calculatable {

	private Scanner sc = new Scanner(System.in);
	private static String report;
	private String input;

	private int hours;
	private int minutes;
	private int totalTime;

	@Override
	public void calculate() {
		print("Type: 'print' to finish and save your time report.\n"
				+ "Begin inputing minutes or hours: ");
		while(true) {
			input = sc.next();
			if(input.equalsIgnoreCase("print")) {
				break;
			} try {
				final int hour = 60;
				int value = Integer.parseInt(input);
				totalTime += value;

				this.hours = totalTime / hour;
				this.minutes = totalTime % hour;

			} catch(NumberFormatException e) {
				println("Invalid Input! Please enter a number or 'print'.");
			}
		}
		//Prints data to console too.
		print("Report finished ->: " + currentDateAndTime() + "\n"
				+ "Time Log: " + hours + " Hours " + minutes + " Minutes " +
				"\n" + "-> Thanks for using TimeCalc! ");
		//Sets whole report to a single string which is then written to file.
		setReport("Report finished ->: " + currentDateAndTime() + "\n"
				+ "Time Log: " + hours + " Hours " + minutes + " Minutes " +
				"\n" + "-> Thanks for using TimeCalc! ");
		//Files report now that calculations have been completed.
		CalcReport.fileReport();
		sc.close();
	}

	private String currentDateAndTime() {
		var now = LocalDateTime.now();
		var formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		return  "Reported: [" + formattedDateTime + "]";
	}

	private void print(String text) {
		System.out.print(text);
	}

	private void println(String text) {
		System.out.println(text);
	}

	private void setReport(String report) {
		Calc.report = report;
	}

	public static String getReport() {
		return report;
	}

}
