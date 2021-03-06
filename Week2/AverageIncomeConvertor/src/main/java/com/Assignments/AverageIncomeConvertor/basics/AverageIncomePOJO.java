package com.Assignments.AverageIncomeConvertor.basics;

public class AverageIncomePOJO {

	private String City;
	private String Country;
	private String Gender;
	private String Currency;
	private Double AverageIncome;

	public AverageIncomePOJO(String city, String country, String gender, String currency, String averageIncome) {
		super();
		City = city;
		Country = country;
		Gender = gender;
		Currency = currency;
		AverageIncome = Double.parseDouble(averageIncome);
	}

	public AverageIncomePOJO(String[] element) {
		super();
		City = element[0];
		Country = element[1];
		Gender = element[2];
		Currency = element[3];
		AverageIncome = Double.parseDouble(element[4]);
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public Double getAverageIncome() {
		return AverageIncome;
	}

	public void setAverageIncome(Double averageIncome) {
		AverageIncome = averageIncome;
	}



	@Override
	public String toString() {
		return "AverageIncomePOJO [City=" + City + ", Country=" + Country + ", Gender=" + Gender + ", Currency="
				+ Currency + ", AverageIncome=" + AverageIncome + "]";
	}

}
