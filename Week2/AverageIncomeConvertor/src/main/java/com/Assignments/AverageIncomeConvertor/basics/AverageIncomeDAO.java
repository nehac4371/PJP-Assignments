package com.Assignments.AverageIncomeConvertor.basics;

import java.util.List;

public interface AverageIncomeDAO {
	
	public List<AverageIncomePOJO> getAllData();
	public void addData(AverageIncomePOJO obj);
	

}
