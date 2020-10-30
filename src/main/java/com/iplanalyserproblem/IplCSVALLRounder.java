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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBattingRuns() {
		return battingRuns;
	}
	public void setBattingRuns(int battingRuns) {
		this.battingRuns = battingRuns;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public double getBowlingAvg() {
		return bowlingAvg;
	}
	public void setBowlingAvg(double bowlingAvg) {
		this.bowlingAvg = bowlingAvg;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
}
