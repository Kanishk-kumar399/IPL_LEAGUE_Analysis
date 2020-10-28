package com.iplanalyserproblem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortedField 
{
	static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
	public enum Field {
		AVERAGE,STRIKE_RATE

	}
	public static Comparator getComparatorField(Field field) 
	{
	      Comparator<IplCSVBatsman> iplAverageComparator = Comparator.comparing(census->census.average);
	      sortFieldComparator.put(Field.AVERAGE, iplAverageComparator);
	      
	      Comparator<IplCSVBatsman> FieldComparator = sortFieldComparator.get(field);
	        return FieldComparator;
	}

}
