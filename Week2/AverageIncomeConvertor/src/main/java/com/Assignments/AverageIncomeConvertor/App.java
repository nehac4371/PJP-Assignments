package com.Assignments.AverageIncomeConvertor;

import java.util.List;

import com.Assignments.AverageIncomeConvertor.basics.AverageIncomeDAOImpl;
import com.Assignments.AverageIncomeConvertor.basics.AverageIncomePOJO;
import com.Assignments.AverageIncomeConvertor.io.CSVReportFileWriter;
import com.Assignments.AverageIncomeConvertor.operations.AverageIncomeOperations;


public class App {

	public static void main(String[] args) throws Exception {

		AverageIncomeDAOImpl averageIncomeData = new AverageIncomeDAOImpl();
		averageIncomeData.setAllData();
		List<AverageIncomePOJO> sample = averageIncomeData.getAllData();

		AverageIncomeOperations aio = new AverageIncomeOperations(sample);
		List<AverageIncomePOJO> sampleoutput = aio.getOutputForReport();

		for (AverageIncomePOJO averageIncomePOJO : sampleoutput) {
			System.out.println(averageIncomePOJO.toString());
		}
		
		CSVReportFileWriter reportWriter = new CSVReportFileWriter();
		reportWriter.sampleFileWriter(sampleoutput);

	}
}
