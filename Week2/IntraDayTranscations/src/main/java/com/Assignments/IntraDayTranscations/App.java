package com.Assignments.IntraDayTranscations;

import java.util.List;

import com.Assignments.IntraDayTransactions.io.CSVFileWriter;
import com.Assignments.IntraDayTransactions.operations.TrasactionOperations;
import com.Assignments.IntraDayTransactions.report.TransactionReportPOJO;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	TrasactionOperations to = new TrasactionOperations();
    	to.operation();
    	List<TransactionReportPOJO> processingFeeReport = to.getProcessingFeeReport();
		
    	CSVFileWriter csvfile = new CSVFileWriter();
		csvfile.sampleFileWriter(processingFeeReport);
		System.out.println("Sucess Debug");
    }
}
