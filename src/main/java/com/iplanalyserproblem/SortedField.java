package com.iplanalyserproblem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortedField 
{
	static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
	static Map<Field, Comparator> sortBowlerFieldComparator=new HashMap<>();
	static Map<Field, Comparator> sortAllRounderComparator=new HashMap<>();
	public enum Field {
		RUN,AVERAGE,STRIKE_RATE,FOUR_AND_SIX,FOUR_AND_SIX_STRIKE_RATE, AVERAGE_WITH_BEST_STRIKE_RATE,MAXIMUM_RUNS_WITH_BEST_AVERAGE
		,BOWLING_AVERAGE, BOWLING_STRIKE_RATE,ECONOMY,BEST_STRIKING_RATE_WITH_4AND5WICKET,BEST_BOWLING_AVG_AND_SR,
		MAXIMUM_WICKETS_WITH_BEST_AVG, BEST_BATTING_AND_BOWLING_AVEARGE
	}
	public static Comparator getComparatorField(Field field) 
	{
		  Comparator<IplCSVBatsman> iplRunComparator = Comparator.comparing(census -> census.runs);
	      Comparator<IplCSVBatsman> iplAverageComparator = Comparator.comparing(census->census.average);
	      sortFieldComparator.put(Field.AVERAGE, iplAverageComparator);
	      Comparator<IplCSVBatsman> iplStrikeRateComparator = Comparator.comparing(census->census.strikeRate);
	      sortFieldComparator.put(Field.STRIKE_RATE, iplStrikeRateComparator);
	      sortFieldComparator.put(Field.FOUR_AND_SIX, new SortedFieldComparator());
	      sortFieldComparator.put(Field.FOUR_AND_SIX_STRIKE_RATE, new SortedFieldComparator().thenComparing(iplStrikeRateComparator));
	      sortFieldComparator.put(Field.AVERAGE_WITH_BEST_STRIKE_RATE,iplAverageComparator.thenComparing(iplStrikeRateComparator));
	      sortFieldComparator.put(Field.MAXIMUM_RUNS_WITH_BEST_AVERAGE,(iplRunComparator).thenComparing(iplAverageComparator));
	      Comparator<IplCSVBatsman> FieldComparator = sortFieldComparator.get(field);
	        return FieldComparator;
	}
	public static Comparator getBowlingComparatorField(Field field)
	{
	    sortBowlerFieldComparator.put(Field.BOWLING_AVERAGE, new SortedBowlerAverageComparator());
	    sortBowlerFieldComparator.put(Field.BOWLING_STRIKE_RATE,new SortedBowlerSRComparator());
	    Comparator<IplCSVBowler> economyComparator=Comparator.comparing(census->census.economy);
	    Comparator<IplCSVBowler> wicketComparator=Comparator.comparing(census->census.wickets);
	    sortBowlerFieldComparator.put(Field.ECONOMY,economyComparator);
	    Comparator<IplCSVBowler> fourWicketAndFiveWicket=Comparator.comparing(census->(census.fourWicket*4+census.fiveWicket*5));
	    Comparator<IplCSVBowler> strikeRate4wAnd5w=fourWicketAndFiveWicket.reversed().thenComparing(new SortedBowlerSRComparator());
	    sortBowlerFieldComparator.put(Field.BEST_STRIKING_RATE_WITH_4AND5WICKET,strikeRate4wAnd5w);
	    Comparator<IplCSVBowler> averageAndStrikeRate=new SortedBowlerAverageComparator().thenComparing(new SortedBowlerSRComparator());
	    sortBowlerFieldComparator.put(Field.BEST_BOWLING_AVG_AND_SR,averageAndStrikeRate);
	    Comparator<IplCSVBowler> maximumWicketsAndBestAverage=wicketComparator.reversed().thenComparing(new SortedBowlerAverageComparator());
	    sortBowlerFieldComparator.put(Field.MAXIMUM_WICKETS_WITH_BEST_AVG,maximumWicketsAndBestAverage);
	    Comparator<IplCSVBowler> bowlingFieldComparator = sortBowlerFieldComparator.get(field);
        return bowlingFieldComparator; 
	}
	public static Comparator getAllRounderComparatorField(Field field) 
	{
		Comparator<IplCSVALLRounder> battingAverageComparator=Comparator.comparing(census->census.battingAvg);
	    Comparator<IplCSVALLRounder> bowlingAverageComparator=Comparator.comparing(census->census.bowlingAvg);;
	    Comparator<IplCSVALLRounder> bothAverageComparator=battingAverageComparator.reversed().thenComparing(bowlingAverageComparator);
	    sortAllRounderComparator.put(Field.BEST_BATTING_AND_BOWLING_AVEARGE,bothAverageComparator);
	    Comparator<IplCSVALLRounder> allRounderFieldComparator = sortAllRounderComparator.get(field);
        return allRounderFieldComparator; 
	}
}
