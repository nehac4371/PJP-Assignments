package com.Assignments.AverageIncomeConvertor.operations;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConvertor {

	Map<String, Double> mapConversionRates = new HashMap<String, Double>();

	public CurrencyConvertor() {

		mapConversionRates.put("INR", 0.66);
		mapConversionRates.put("GBP", 0.67);
		mapConversionRates.put("SGP", 1.5);
		mapConversionRates.put("HKD", 8.0);
		mapConversionRates.put("USD", 1.0);

	}

	public Map<String, Double> getMapConversionRates() {
		return mapConversionRates;
	}

	public void setMapConversionRates(Map<String, Double> mapConversionRates) {
		this.mapConversionRates = mapConversionRates;
	}

	public void addCurrency(String currency, Double rate) {
		mapConversionRates.put(currency, rate);
	}

	public Double convert(String currency, Double valueInDollar) {

		return mapConversionRates.get(currency) * valueInDollar;

	}

}
