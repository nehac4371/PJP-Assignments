package com.Assignments.AverageIncomeConvertor;


import java.util.Iterator;
import java.util.List;

import com.Assignments.AverageIncomeConvertor.basics.AverageIncomeDAO;
import com.Assignments.AverageIncomeConvertor.basics.AverageIncomeDAOImpl;
import com.Assignments.AverageIncomeConvertor.basics.AverageIncomePOJO;
import com.Assignments.AverageIncomeConvertor.readers.CSVFileReader;
import com.Assignments.AverageIncomeConvertor.readers.SampleFileReader;

/**
 * Hello world!
 *
 */
public class App {

	public static void print(String[] sample) {
		for (int i = 0; i < sample.length; i++) {
			System.out.print(sample[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
			
		AverageIncomeDAOImpl averageIncomeData = new AverageIncomeDAOImpl();
		averageIncomeData.setAllData();
		List<AverageIncomePOJO> sample = averageIncomeData.getAllData();
		
		for (Iterator<AverageIncomePOJO> iterator = sample.iterator(); iterator.hasNext();) {
			
			AverageIncomePOJO averageIncomePOJO = (AverageIncomePOJO) iterator.next();
			System.out.println(averageIncomePOJO.toString());
		}
		

	}

	// AverageIncomePOJO av = new AverageIncomePOJO("PN", " ", "M", "INR",
	// "12345.0");
	// System.out.println(av.toString());
	// System.out.println(av.aveargeIncomeFloat()+10);
}
