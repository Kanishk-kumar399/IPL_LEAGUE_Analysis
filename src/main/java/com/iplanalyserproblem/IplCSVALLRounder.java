package com.iplanalyserproblem;

public class IplCSVALLRounder
{
	public String name;
	public int battingRuns;
	public double battingAvg;
	public double bowlingAvg;
	public int wickets;
	public IplCSVALLRounder(String name, int battingRuns, double battingAvg, double bowlingAvg, int wickets) {
		super();
		this.name = name;
		this.battingRuns = battingRuns;
		this.battingAvg = battingAvg;
		this.bowlingAvg = bowlingAvg;
		this.wickets = wickets;
	}
	@Override
	public String toString() {
		return "IplCSVALLRounder [name=" + name + ", battingRuns=" + battingRuns + ", battingAvg=" + battingAvg
				+ ", bowlingAvg=" + bowlingAvg + ", wickets=" + wickets + "]";
	}
	
}
