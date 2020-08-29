package com.Assignments.IntraDayTransactions.report;



import com.Assignments.IntraDayTransactions.loaddata.TransactionPOJO;

public class TransactionReportPOJO extends TransactionPOJO{
	
		private Double processingFee = 0.0;
		
		public TransactionReportPOJO(TransactionPOJO transcation,Double processingFee) {
			
			this.setClientId(transcation.getClientId());
			this.setTransactionType(transcation.getTransactionType());
			this.setTransactionDate(transcation.getTransactionDate());
			this.setPriorityFlag(transcation.getPriorityFlag());
			this.processingFee = processingFee;
			
		}

		public Double getProcessingFee() {
			return processingFee;
		}

		public void setProcessingFee(Double processingFee) {
			this.processingFee = processingFee;
		}
		

}
