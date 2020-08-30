package com.Assignments.AverageIncomeConvertor.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.Assignments.AverageIncomeConvertor.basics.AverageIncomePOJO;

public class CSVReportFileWriter {

	BufferedWriter bw = null;
	File file = new File("summary_report.csv");

	public void sampleFileWriter(List<AverageIncomePOJO> report) throws Exception {

		if (!file.exists())
			file.createNewFile();

		bw = new BufferedWriter(new FileWriter(file));
		bw.write("City,Gender,Average Income(in USD)");
		bw.newLine();

		for (AverageIncomePOJO averageIncomePOJO : report) {
			bw.write(String.join(",", averageIncomePOJO.getCity(), averageIncomePOJO.getGender(),
					Double.toString(averageIncomePOJO.getAverageIncome())));
			bw.newLine();
		}
		
		bw.close();

	}

}
