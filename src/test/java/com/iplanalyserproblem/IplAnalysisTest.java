package com.iplanalyserproblem;

import org.junit.Test;

import junit.framework.Assert;

public class IplAnalysisTest
{
	public static final String CRICKET_CSV_FILE ="C:\\Users\\Asus\\eclipse-workspace\\IPLAnalyser\\src\\test\\resources\\WP DP Data_01 IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenIPL_CSVFileShouldReturnCorrectRecords() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        int battingAverage = iplAnalysis.loadCricketIPLCSVData(CRICKET_CSV_FILE);
        Assert.assertEquals(101, battingAverage);
    }
}
