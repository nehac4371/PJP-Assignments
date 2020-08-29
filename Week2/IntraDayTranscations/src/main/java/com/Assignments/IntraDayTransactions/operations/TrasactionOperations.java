package com.Assignments.IntraDayTransactions.operations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Assignments.IntraDayTransactions.io.CSVFileWriter;
import com.Assignments.IntraDayTransactions.loaddata.TransactionDaoImplementation;
import com.Assignments.IntraDayTransactions.loaddata.TransactionPOJO;
import com.Assignments.IntraDayTransactions.report.TransactionReportPOJO;

public class TrasactionOperations {

	private Double processingFee;
	TransactionDaoImplementation dataHandler = null;

	String clientId;
	String securityId;
	Date transcationDate;

	List<TransactionReportPOJO> processingFeeReport = new ArrayList<TransactionReportPOJO>();
	List<TransactionPOJO> data = null;


	public TrasactionOperations() throws Exception {

		dataHandler = new TransactionDaoImplementation();
		data = dataHandler.getData();

		for (TransactionPOJO transactionPOJO : data) {
			System.out.println(data.toString());
		}

		for (TransactionPOJO transactionPOJO : data) {
			processingFeeReport.add(new TransactionReportPOJO(transactionPOJO, 0.0));

		}

	}
	
	
	public Double getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(Double processingFee) {
		this.processingFee = processingFee;
	}


	public void intraDayProcessing() {

	}

	public List<TransactionReportPOJO> normalDayProcessing() throws Exception {

		for (TransactionReportPOJO transaction : processingFeeReport) {

			if (transaction.getPriorityFlag().equals("Y")) {
				transaction.setProcessingFee(transaction.getProcessingFee() + 500);
			} else {
				String type = transaction.getTransactionType();
				if (type.equals("SELL") || type.equals("WITHDRAW")) {
					transaction.setProcessingFee(transaction.getProcessingFee() + 100);
				} else {
					transaction.setProcessingFee(transaction.getProcessingFee() + 50);
				}

			}

		}
		CSVFileWriter csvfile = new CSVFileWriter();
		csvfile.sampleFileWriter(processingFeeReport);
		System.out.println("Sucess Debug");
		return processingFeeReport;

	}

}
