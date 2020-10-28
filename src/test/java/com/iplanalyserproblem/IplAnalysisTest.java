package com.iplanalyserproblem;

import org.junit.Test;

import junit.framework.Assert;

public class IplAnalysisTest
{
	public static final String CRICKET_CSV_FILE ="/IPLAnalyser/src/test/resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenIPL_CSVFileShouldReturnCorrectRecords() throws IplAnalysisException {
        IplAnalysis iplAnalyser = new IplAnalysis();
        int battingAverage = iplAnalyser.loadCricketIPLData(CRICKET_CSV_FILE);
        Assert.assertEquals(101, battingAverage);
    }
}
