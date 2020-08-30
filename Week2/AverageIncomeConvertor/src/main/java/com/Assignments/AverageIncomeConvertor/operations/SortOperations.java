package com.Assignments.AverageIncomeConvertor.operations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.Assignments.AverageIncomeConvertor.basics.AverageIncomePOJO;

public class SortOperations {

	List<AverageIncomePOJO> data = null;
	

	public SortOperations(List<AverageIncomePOJO> data) {
		this.data = data;
	}

	public List<AverageIncomePOJO> getData() {
		return data;
	}

	public void setData(List<AverageIncomePOJO> data) {
		this.data = data;
	}

	public List<AverageIncomePOJO> sortForOutput(){
		
		Comparator<AverageIncomePOJO> _sortForOutput = Comparator.comparing(AverageIncomePOJO::getCountry)
				.thenComparing(AverageIncomePOJO::getGender).thenComparing(AverageIncomePOJO::getAverageIncome);
		
		List<AverageIncomePOJO> sortedData = data.stream().sorted(_sortForOutput).collect(Collectors.toList());
		
		return sortedData;
		
	}
}
