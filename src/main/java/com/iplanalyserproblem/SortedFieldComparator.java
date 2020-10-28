package com.iplanalyserproblem;

import java.util.Comparator;

public class SortedFieldComparator implements Comparator<IplCSVBatsman> {

	@Override
	public int compare(IplCSVBatsman batsman1,IplCSVBatsman batsman2) 
	{
		 return (((batsman1.sixes * 6) + (batsman1.fours * 4)) - ((batsman2.sixes * 6) + (batsman2.fours * 4)));
	}

}
