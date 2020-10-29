package com.iplanalyserproblem;

import com.opencsv.bean.CsvBindByName;

public class IplCSVBowler 
{
		public IplCSVBowler() {
		}
	 	@CsvBindByName(column = "POS")
	    public int position;

	    @CsvBindByName(column = "PLAYER")
	    public String player;

	    @CsvBindByName(column = "Mat")
	    public int matches;

	    @CsvBindByName(column = "Inns")
	    public int inning;

	    @CsvBindByName(column = "Ov")
	    public double over;

	    @CsvBindByName(column = "Runs")
	    public int runs;

	    @CsvBindByName(column = "Wkts")
	    public int wickets;

	    @CsvBindByName(column = "BBI")
	    public int bestBowlingInning;

	    @CsvBindByName(column = "Avg")
	    public double average;

	    @CsvBindByName(column = "Econ")
	    public int economy;

	    @CsvBindByName(column = "SR")
	    public double strikeRate;

	    @CsvBindByName(column = "4w")
	    public int fourWicket;

	    @CsvBindByName(column = "5w")
	    public int fiveWicket;
	    
	    @Override
	    public String toString() {
	        return "IplCSVBowler{" +
	                "position=" + position +
	                ", player='" + player + '\'' +
	                ", matches=" + matches +
	                ", inning=" + inning +
	                ", over=" + over +
	                ", runs=" + runs +
	                ", wickets=" + wickets +
	                ", bestBallingInning=" + bestBowlingInning +
	                ", average=" + average +
	                ", economy=" + economy +
	                ", strikeRate=" + strikeRate +
	                ", fourWkt=" + fourWicket +
	                ", fiveWicket=" + fiveWicket +
	                '}';
	    }
}
