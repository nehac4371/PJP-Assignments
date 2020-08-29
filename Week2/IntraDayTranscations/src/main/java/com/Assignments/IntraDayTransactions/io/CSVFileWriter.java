package com.Assignments.IntraDayTransactions.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.Assignments.IntraDayTransactions.report.TransactionReportPOJO;

public class CSVFileWriter {

	BufferedWriter bw = null;
	File file = new File("summary_report.csv");

	public void sampleFileWriter(List<TransactionReportPOJO> report) throws IOException {
		
		System.out.println(file.getCanonicalPath());
		
		
		
		if (!file.exists())
			file.createNewFile();

		bw = new BufferedWriter(new FileWriter(file));
		bw.write("Client Id,Transaction Type,Transaction Date,Priority,Processing Fee");
		bw.newLine();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		for (TransactionReportPOJO transactionReportPOJO : report) {

			String date = dateFormat.format(transactionReportPOJO.getTransactionDate());

			bw.write(String.join(",", transactionReportPOJO.getClientId(), transactionReportPOJO.getTransactionType(),
					date, transactionReportPOJO.getPriorityFlag(),Double.toString(transactionReportPOJO.getProcessingFee())));
			bw.newLine();

		}
		
		bw.close();

	}

}
