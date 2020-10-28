package com.iplanalyserproblem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortedField 
{
	static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
	public enum Field {
		RUN,AVERAGE,STRIKE_RATE,FOUR_AND_SIX,FOUR_AND_SIX_STRIKE_RATE, AVERAGE_WITH_BEST_STRIKE_RATE,MAXIMUM_RUNS_WITH_BEST_AVERAGE

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

}
