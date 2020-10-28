package com.iplanalyserproblem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortedField 
{
	static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
	public enum Field {
		AVERAGE,STRIKE_RATE,FOUR_AND_SIX,FOUR_AND_SIX_STRIKE_RATE

	}
	public static Comparator getComparatorField(Field field) 
	{
	      Comparator<IplCSVBatsman> iplAverageComparator = Comparator.comparing(census->census.average);
	      sortFieldComparator.put(Field.AVERAGE, iplAverageComparator);
	      Comparator<IplCSVBatsman> iplStrikeRateComparator = Comparator.comparing(census->census.strikeRate);
	      sortFieldComparator.put(Field.STRIKE_RATE, iplStrikeRateComparator);
	      sortFieldComparator.put(Field.FOUR_AND_SIX, new SortedFieldComparator());
	      sortFieldComparator.put(Field.FOUR_AND_SIX_STRIKE_RATE, new SortedFieldComparator().thenComparing(iplStrikeRateComparator));
	      Comparator<IplCSVBatsman> FieldComparator = sortFieldComparator.get(field);
	        return FieldComparator;
	}

}
