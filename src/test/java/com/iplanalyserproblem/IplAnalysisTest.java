package com.iplanalyserproblem;

import org.junit.Test;

import com.google.gson.Gson;

import org.junit.Assert;

public class IplAnalysisTest
{
	public static final String CRICKET_CSV_FILE ="C:\\Users\\Asus\\eclipse-workspace\\IPLAnalyser\\src\\test\\resources\\WP DP Data_01 IPL2019FactsheetMostRuns (1).csv";
	public static final String BOWLER_CSV_FILE="C:\\Users\\Asus\\eclipse-workspace\\IPLAnalyser\\src\\test\\resources\\WP DP Data_02 IPL2019FactsheetMostWkts (1).csv";
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
    @Test
    public void givenIPLData_WhenSortedAsHighestStrikingRate_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketIPLCSVData( CRICKET_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLCricketRecords(SortedField.Field.STRIKE_RATE);
        IplCSVBatsman[] highestStrikeRate = new Gson().fromJson(iplPlayersRecords, IplCSVBatsman[].class);
        Assert.assertEquals("Ishant Sharma", highestStrikeRate[highestStrikeRate.length-1].player);
    }
    @Test
    public void givenIPLData_WhenSortedAsHighest_4sand6s_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketIPLCSVData( CRICKET_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLCricketRecords(SortedField.Field.FOUR_AND_SIX);
        IplCSVBatsman[] fourAndSixSorted = new Gson().fromJson(iplPlayersRecords, IplCSVBatsman[].class);
        Assert.assertEquals("Andre Russell", fourAndSixSorted[fourAndSixSorted.length-1].player);
    }
    @Test
    public void givenIPLData_WhenSortedAsHighest_4sand6sAlongWithHighestStrikeRate_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketIPLCSVData( CRICKET_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLCricketRecords(SortedField.Field.FOUR_AND_SIX_STRIKE_RATE);
        IplCSVBatsman[] fourAndSixSortedWithHighestSR = new Gson().fromJson(iplPlayersRecords, IplCSVBatsman[].class);
        Assert.assertEquals("Andre Russell", fourAndSixSortedWithHighestSR[fourAndSixSortedWithHighestSR.length-1].player);
    }
    @Test
    public void givenIPLData_WhenSortedOn_GreatAverage_WithHighestStrikeRate_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketIPLCSVData( CRICKET_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLCricketRecords(SortedField.Field.AVERAGE_WITH_BEST_STRIKE_RATE);
        IplCSVBatsman[] averageWithHighestSR = new Gson().fromJson(iplPlayersRecords, IplCSVBatsman[].class);
        Assert.assertEquals("MS Dhoni", averageWithHighestSR[averageWithHighestSR.length-1].player);
    }
    @Test
    public void givenIPLData_WhenSortedOn_MaximumRuns_AndBestAverage_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketIPLCSVData( CRICKET_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLCricketRecords(SortedField.Field.MAXIMUM_RUNS_WITH_BEST_AVERAGE);
        IplCSVBatsman[] maximumRunsWithBestAverage = new Gson().fromJson(iplPlayersRecords, IplCSVBatsman[].class);
        Assert.assertEquals("David Warner ", maximumRunsWithBestAverage[maximumRunsWithBestAverage.length-1].player);
    }
    @Test
    public void givenIPLData_WhenSortedOnTopBowlingAverages_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketBowlerIPLCSVData( BOWLER_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLBowlerRecords(SortedField.Field.BOWLING_AVERAGE);
        IplCSVBowler[] bestAverageBowler = new Gson().fromJson(iplPlayersRecords, IplCSVBowler[].class);
        Assert.assertEquals("Anukul Roy", bestAverageBowler[0].player);
    }
    @Test
    public void givenIPLData_WhenSortedOnTopBowlingStrikeRate_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketBowlerIPLCSVData( BOWLER_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLBowlerRecords(SortedField.Field.BOWLING_STRIKE_RATE);
        IplCSVBowler[] bestStrikeRateBowler = new Gson().fromJson(iplPlayersRecords, IplCSVBowler[].class);
        Assert.assertEquals("Alzarri Joseph", bestStrikeRateBowler[0].player);
    }
    @Test
    public void givenIPLData_WhenSortedOnBestEconomyRate_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketBowlerIPLCSVData( BOWLER_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLBowlerRecords(SortedField.Field.ECONOMY);
        IplCSVBowler[] bestEconomyBowler = new Gson().fromJson(iplPlayersRecords, IplCSVBowler[].class);
        Assert.assertEquals("Shivam Dube", bestEconomyBowler[0].player);
    }
    @Test
    public void givenIPLData_WhenSortedOnStrikeRateWith4wAnd5w_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketBowlerIPLCSVData( BOWLER_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLBowlerRecords(SortedField.Field.BEST_STRIKING_RATE_WITH_4AND5WICKET);
        IplCSVBowler[] bestSR4wAnd5wBowler = new Gson().fromJson(iplPlayersRecords, IplCSVBowler[].class);
        Assert.assertEquals("Kagiso Rabada", bestSR4wAnd5wBowler[0].player);
    }
    @Test
    public void givenIPLData_WhenSortedOnBestBowlingAverageWithBestSR_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketBowlerIPLCSVData( BOWLER_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLBowlerRecords(SortedField.Field.BEST_BOWLING_AVG_AND_SR);
        IplCSVBowler[] bestAverageAndStrikeRate = new Gson().fromJson(iplPlayersRecords, IplCSVBowler[].class);
        Assert.assertEquals("Anukul Roy", bestAverageAndStrikeRate[0].player);
    }
    @Test
    public void givenIPLData_WhenSortedOnHighestWicketTakerWithBestAverage_ShouldReturnSortedResult() throws IplAnalysisException {
        IplAnalysis iplAnalysis = new IplAnalysis();
        iplAnalysis.loadCricketBowlerIPLCSVData( BOWLER_CSV_FILE);
        String iplPlayersRecords = iplAnalysis.getSortIPLBowlerRecords(SortedField.Field.MAXIMUM_WICKETS_WITH_BEST_AVG);
        IplCSVBowler[] highestWicketWithBestAverage = new Gson().fromJson(iplPlayersRecords, IplCSVBowler[].class);
        Assert.assertEquals("Imran Tahir", highestWicketWithBestAverage[0].player);
    }
}
