package com.Assignments.AverageIncomeConvertor.io;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public abstract class SampleFileReader {

	private String filePath;
	private Scanner scanner = null;
	private BufferedReader bufferedReader = null;


	public SampleFileReader(String filePath) throws FileNotFoundException {
		this.filePath = filePath;
		scanner = new Scanner(new File(filePath));
		bufferedReader = new BufferedReader(new FileReader(filePath));
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public Scanner getScanner() {
		
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	
	public void closeScanner() {
		this.scanner.close();
	}
	
	public abstract void displayData() throws Exception;

	public abstract String[] retrieveElement() throws Exception;
	
}
