package com.Assignments.IntraDayTransactions.io;

public class CSVFileReader extends SampleFileReader {

	public CSVFileReader(String filePath) throws Exception {
		super(filePath);
		getBufferedReader().readLine();
	}

	public String[] retrieveElement() throws Exception {

		String line = getBufferedReader().readLine();
		if (line == null)
			return null;
		return line.split(",");

	}

	@Override
	public void displayData() throws Exception {

		String line = getBufferedReader().readLine();

		System.out.println(line);

		String[] element = line.split(",");

		for (int i = 0; i < element.length; i++) {
			System.out.print(element[i] + " ");
		}

	}

}
