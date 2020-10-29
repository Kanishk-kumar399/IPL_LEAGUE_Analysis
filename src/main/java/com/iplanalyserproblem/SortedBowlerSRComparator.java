package com.iplanalyserproblem;

import java.util.Comparator;

public class SortedBowlerSRComparator implements Comparator<IplCSVBowler> 
{
	@Override
	public int compare(IplCSVBowler bowler1,IplCSVBowler bowler2) {
		 if (bowler1.strikeRate==0.0) {
             return 1;
         }
         if (bowler2.strikeRate==0.0) {
             return -1;
         }
         return (int) (bowler1.strikeRate-bowler2.strikeRate);
	}

}
