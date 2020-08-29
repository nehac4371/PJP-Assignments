package com.Assignments.IntraDayTransactions.loaddata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.Assignments.IntraDayTransactions.io.CSVFileReader;
import com.Assignments.IntraDayTransactions.io.SampleFileReader;

public class TransactionDaoImplementation implements TransactionDAO {

	private List<TransactionPOJO> data = null;


	SampleFileReader sfr = null;

	public TransactionDaoImplementation() throws Exception {
		data = new ArrayList<TransactionPOJO>();
		sfr = new CSVFileReader("Sample_Data_Fee_Calculator.csv");
	}

	@Override
	public void addTransaction(TransactionPOJO newTranscation) {

		data.add(newTranscation);

	}
	
	public List<TransactionPOJO> getData() throws Exception {
		
		String[] element = sfr.retrieveElement();
		while(element!=null) {
			data.add(new TransactionPOJO(element));
			element = sfr.retrieveElement();
		}
		
		return data;
	}

	public void setData(List<TransactionPOJO> data) {
		this.data = data;
	}

	@Override
	public TransactionPOJO retrieveByTransactionId(String externalTransactionId) {

		TransactionPOJO transaction = data.stream()
				.filter(obj -> externalTransactionId.equals(obj.getExternalTransactionId())).findFirst().orElse(null);

		return transaction;
	}

	@Override
	public List<TransactionPOJO> retrieveByClientId(String clientId) {

		List<TransactionPOJO> clientData = data.stream().filter(obj -> clientId.equals(obj.getClientId()))
				.collect(Collectors.toList());

		return clientData;

	}

	@Override
	public List<TransactionPOJO> retrieveForIntraDayFee(String clientId, String securityId, Date transcationDate) {
		
		List<TransactionPOJO> intraDayData = data.stream()
				.filter(obj -> clientId.equals(obj.getClientId()))
				.filter(obj -> securityId.equals(obj.getSecurityId()))
				.filter(obj -> transcationDate.equals(obj.getTransactionDate()))
				.filter(obj -> ("BUY".equals(obj.getTransactionType()) || "SELL".equals(obj.getTransactionType())))
				.collect(Collectors.toList());
		
		return intraDayData;
	}

}
