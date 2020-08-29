package com.Assignments.IntraDayTransactions.loaddata;

import java.util.Date;
import java.util.List;

public interface TransactionDAO {

	public void addTransaction(TransactionPOJO newTranscation);

	public TransactionPOJO retrieveByTransactionId(String externalTransactionId);

	public List<TransactionPOJO> retrieveByClientId(String clientId);

	public List<TransactionPOJO> retrieveForIntraDayFee(String clientId, String securityId, Date transcationData);

}
