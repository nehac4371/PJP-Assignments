package com.Assignments.AverageIncomeConvertor.basics;

import java.util.ArrayList;
import java.util.List;

import com.Assignments.AverageIncomeConvertor.io.CSVFileReader;
import com.Assignments.AverageIncomeConvertor.io.SampleFileReader;

public class AverageIncomeDAOImpl implements AverageIncomeDAO{
	
	private List<AverageIncomePOJO> data = null;
	SampleFileReader sfr = null;
	
	public AverageIncomeDAOImpl() throws Exception {
		data = new ArrayList<AverageIncomePOJO>();
		sfr = new CSVFileReader("SampleInput.csv");
	}

	public void setAllData() throws Exception{
		
		String[] element = sfr.retrieveElement();
		
		while(element!=null) {
			
			data.add(new AverageIncomePOJO(element));
			element = sfr.retrieveElement();
			
		}
	}
	
	@Override
	public List<AverageIncomePOJO> getAllData() {
		return data;
	}

	@Override
	public void addData(AverageIncomePOJO obj) {
		data.add(obj);
	}
	
	
}
