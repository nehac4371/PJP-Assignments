package com.Assignments.IntraDayTransactions.operations;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Assignments.IntraDayTransactions.loaddata.TransactionPOJO;

public class SortTranscations {

	List<TransactionPOJO> data = null;

	Map<String, Comparator<TransactionPOJO>> sortMap = new HashMap<String, Comparator<TransactionPOJO>>();

	{
		Comparator<TransactionPOJO> compareByClientId = (TransactionPOJO t1, TransactionPOJO t2) -> t1.getClientId()
				.compareTo(t2.getClientId());

		Comparator<TransactionPOJO> compareByTransactionDate = (TransactionPOJO t1, TransactionPOJO t2) -> t1
				.getTransactionDate().compareTo(t2.getTransactionDate());

		Comparator<TransactionPOJO> compareBySecurityId = (TransactionPOJO t1, TransactionPOJO t2) -> t1
				.getSecurityId().compareTo(t2.getSecurityId());

		sortMap.put("ClientId", compareByClientId);
		sortMap.put("TransactionDate", compareByTransactionDate);
		sortMap.put("SecurityId", compareBySecurityId);
	}

	public SortTranscations(List<TransactionPOJO> data) {
		super();
		this.data = data;
	}

	public SortTranscations() {

	}

	public List<TransactionPOJO> getData() {
		return data;
	}

	public void setData(List<TransactionPOJO> data) {
		this.data = data;
	}

	public void sortData(String type) {
		Collections.sort(data, sortMap.get(type));
	}
	
	public void sortDataMultipleKeys() {
		Collections.sort(data,sortMap.get("ClientId"));
		Collections.sort(data,sortMap.get("SecurityId"));
		Collections.sort(data,sortMap.get("TransactionDate"));
	}

}
