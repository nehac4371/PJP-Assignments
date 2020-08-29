package com.Assignments.IntraDayTransactions.operations;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	Map<String, Boolean> trackRecord = new HashMap<String, Boolean>();

	public TrasactionOperations() throws Exception {

		dataHandler = new TransactionDaoImplementation();
		data = dataHandler.getData();

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

	public List<TransactionReportPOJO> getProcessingFeeReport() {
		return processingFeeReport;
	}

	public void setProcessingFeeReport(List<TransactionReportPOJO> processingFeeReport) {
		this.processingFeeReport = processingFeeReport;
	}

	public void intraDayProcessing() {

		SortTranscations st = new SortTranscations();
		st.setData(data);
		st.sortDataMultipleKeys();
		data = st.getData();
		List<TransactionPOJO> intraDayData = new ArrayList<TransactionPOJO>();

		for (TransactionPOJO transactionPOJO : data) {
			for (TransactionPOJO transactionPOJO2 : data) {
				if ((transactionPOJO.getClientId().equals(transactionPOJO2.getClientId())) && (transactionPOJO
						.getSecurityId().equals(transactionPOJO2.getSecurityId())
						&& (transactionPOJO.getTransactionDate().equals(transactionPOJO2.getTransactionDate())))) {
					if (transactionPOJO.getTransactionType().equals("SELL")
							|| transactionPOJO.getTransactionType().equals("BUY")) {
						intraDayData.add(transactionPOJO);
					}
				}
			}
		}

		for (TransactionReportPOJO transaction : processingFeeReport) {
			if (intraDayData.contains(transaction)) {
				transaction.setProcessingFee(transaction.getProcessingFee() + 10);
			}
			trackRecord.put(transaction.getExternalTransactionId(), true);
		}

	}

	public void normalDayProcessing() {

		for (TransactionReportPOJO transaction : processingFeeReport) {

			if (trackRecord.get(transaction.getExternalTransactionId()))
				continue;

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

	}

	public void operation() {
		intraDayProcessing();
		normalDayProcessing();
	}

}
