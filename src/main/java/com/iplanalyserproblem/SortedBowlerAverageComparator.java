package com.iplanalyserproblem;

import java.util.Comparator;

public class SortedBowlerAverageComparator implements Comparator<IplCSVBowler> 
{
	@Override
	public int compare(IplCSVBowler bowler1,IplCSVBowler bowler2) {
		 if (bowler1.average==0.0) {
             return 1;
         }
         if (bowler2.average==0.0) {
             return -1;
         }
         return (int) (bowler1.average-bowler2.average);
	}

}
