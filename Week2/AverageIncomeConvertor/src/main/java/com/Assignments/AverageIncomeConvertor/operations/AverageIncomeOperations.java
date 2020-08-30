package com.Assignments.AverageIncomeConvertor.operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Assignments.AverageIncomeConvertor.basics.AverageIncomePOJO;

public class AverageIncomeOperations {

	List<AverageIncomePOJO> data = null;
	Map<String, String> mapCityCountry = new HashMap<String, String>();
	Map<String, String> mapCityCurrency = new HashMap<String, String>();

	public AverageIncomeOperations(List<AverageIncomePOJO> data) {
		this.data = data;
	}

	public AverageIncomeOperations() {

	}

	public List<AverageIncomePOJO> getData() {
		return data;
	}

	public void setData(List<AverageIncomePOJO> data) {
		this.data = data;
		populateCityCurrency();
		populateCityCountry();
	}

	private void populateCityCurrency() {
		for (AverageIncomePOJO averageIncomePOJO : data) {
			mapCityCurrency.put(averageIncomePOJO.getCity(), averageIncomePOJO.getCurrency());
		}
	}

	private void populateCityCountry() {

		for (AverageIncomePOJO averageIncomePOJO : data) {
			mapCityCountry.put(averageIncomePOJO.getCity(), averageIncomePOJO.getCountry());
		}

	}

	public List<AverageIncomePOJO> getOutput() {
		
		setData(data);

		CurrencyConvertor cc = new CurrencyConvertor();
		SortOperations so = new SortOperations(data);

		for (AverageIncomePOJO averageIncomePOJO : data) {
			averageIncomePOJO.setAverageIncome(
					cc.convert(mapCityCurrency.get(averageIncomePOJO.getCity()), averageIncomePOJO.getAverageIncome()));
		}

		return so.sortForOutput();
	}
	
	public List<AverageIncomePOJO> getOutputForReport(){
		setData(data);
		SortOperations so = new SortOperations(data);
		return so.sortForOutput();
	}

}
