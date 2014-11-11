// Leetcode 056: Merge Intevals
// Author: Yinjie Huang
// Date: 10/13/2014

import java.util.*;

public class MergeIntervals {
        public static void main(String[] args) {
                System.out.println("Leetcode 056: Merge Intevals!!!");
                MergeIntervals mi = new MergeIntervals();
                ArrayList<Interval> intervals = new ArrayList<Interval>();
                Interval i1 = new Interval(2,3);
                Interval i2 = new Interval(4,5);
                Interval i3 = new Interval(6,7);
                Interval i4 = new Interval(8,9);
                Interval i5 = new Interval(1,10);
                intervals.add(i1);
                intervals.add(i2);
                intervals.add(i3);
                intervals.add(i4);
                intervals.add(i5);
                /*Interval i1 = new Interval(1,4);
                Interval i2 = new Interval(0,2);
                Interval i3 = new Interval(3,5);
                intervals.add(i1);
                intervals.add(i2);
                intervals.add(i3);*/
                ArrayList<Interval> result = mi.merge(intervals);
                for (Interval i: result) {
                        System.out.print("[" + i.start + ", " + i.end + "],");
                }
                System.out.println();
        }

        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
                if (intervals == null || intervals.size() <= 1) {
                        return intervals;
                }
                
                //Collections.sort(intervals, new IntervalComparator());
                Collections.sort(intervals);
                int len = intervals.size();
                ArrayList<Interval> result = new ArrayList<Interval>();
                
                Interval pre = intervals.get(0);
                for (int i = 1; i < len ; i++) {
                        Interval cur = intervals.get(i);
                        if (pre.end >= cur.start) {
                        		Interval newi = new Interval(pre.start, Math.max(pre.end, cur.end));
                        		pre = newi;
                        } else {
                        		result.add(pre);
                        		pre = cur;
                        }
                        
                }
                result.add(pre);
                
                return result;
        }
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}

class Interval implements Comparable<Interval> {
        int start;
        int end;
        Interval() {
                start = 0;
                end = 0;
        }
        Interval(int s, int e) {
                start = s;
                end = e;
        }

        public int compareTo(Interval i) {
                return this.start - i.start;
        }
}
