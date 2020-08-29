package com.Assignments.IntraDayTranscations;

import com.Assignments.IntraDayTransactions.operations.TrasactionOperations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	TrasactionOperations to = new TrasactionOperations();
    	to.normalDayProcessing();
    }
}
