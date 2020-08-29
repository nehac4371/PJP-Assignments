package com.Assignments.IntraDayTransactions.loaddata;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionPOJO {



	private String externalTransactionId;
	protected String clientId;
	private String securityId;
	private String transactionType;
	private Date transactionDate;
	private double marketValue;
	private String priorityFlag;
	DateFormat format = new SimpleDateFormat("MM/dd/yyyy");  

	public TransactionPOJO() {

	}

	public TransactionPOJO(String externalTransactionId, String clientId, String securityId, String transactionType,
			String transactionDate, String marketValue, String priorityFlag) throws Exception {
		super();
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = format.parse(transactionDate);
		this.marketValue = Double.parseDouble(marketValue);
		this.priorityFlag = priorityFlag;
	}
	
	public TransactionPOJO(String[] element) throws Exception {
		super();
		this.externalTransactionId = element[0];
		this.clientId = element[1];
		this.securityId = element[2];
		this.transactionType = element[3];
		this.transactionDate = format.parse(element[4]);
		this.marketValue = Double.parseDouble(element[5]);
		this.priorityFlag = element[6];
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public String getPriorityFlag() {
		return priorityFlag;
	}

	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	
	
	@Override
	public String toString() {
		return "TransactionPOJO [externalTransactionId=" + externalTransactionId + ", clientId=" + clientId
				+ ", securityId=" + securityId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue + ", priorityFlag=" + priorityFlag + "]";
	}


}
