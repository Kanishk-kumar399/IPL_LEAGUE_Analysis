package com.iplanalyserproblem;

import org.junit.Test;

import com.google.gson.Gson;

import junit.framework.Assert;

public class IplAnalysisTest
{
	public static final String CRICKET_CSV_FILE ="C:\\Users\\Asus\\eclipse-workspace\\IPLAnalyser\\src\\test\\resources\\WP DP Data_01 IPL2019FactsheetMostRuns (1).csv";
    @Test
    public void givenIPL_CSVFileShouldReturnCorrectRecords() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        int battingAverage = iplAnalysis.loadCricketIPLCSVData(CRICKET_CSV_FILE);
        Assert.assertEquals(101, battingAverage);
    }
    @Test
    public void givenIPLData_WhenSortedAsHighestBattingAverage_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketIPLCSVData( CRICKET_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLCricketRecords(SortedField.Field.AVERAGE);
        IplCSVBatsman[] mostAverageRuns = new Gson().fromJson(iplPlayersRecords, IplCSVBatsman[].class);
        Assert.assertEquals("MS Dhoni", mostAverageRuns[mostAverageRuns.length-1].player);
    }
}
