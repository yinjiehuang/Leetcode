// Leetcode 057: Insert Interval
// Author: Yinjie Huang
// Date: 10/14/2014
//
import java.util.*;

public class InsertInterval {
        public static void main(String[] args) {
                System.out.println("Leetcode 057: Insert Interval!!!");
                InsertInterval ii = new InsertInterval();
                ArrayList<Interval> intervals = new ArrayList<Interval>();
                intervals.add(new Interval(1,2));
                intervals.add(new Interval(3,5));
                intervals.add(new Interval(6,7));
                intervals.add(new Interval(8,10));
                intervals.add(new Interval(12,16));
                ArrayList<Interval> result = ii.insert(intervals, new Interval(4,j9));
                for (Interval i: result) {
                        System.out.print("[" + i.start + ", " + i.end + "],");
                }
                System.out.println();

        }

        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
                intervals.add(newInterval);
                int len = intervals.size();

                if (len == 1) {
                        return intervals;
                }

                Collections.sort(intervals, new newComparator());
                ArrayList<Interval> result = new ArrayList<Interval>();
                Interval pre = intervals.get(0);
                for (int i = 1; i < len; i++) {
                        Interval cur = intervals.get(i);
                        if (pre.end >= cur.start) {
                                Interval temp = new Interval(pre.start, Math.max(pre.end, cur.end));
                                pre = temp;
                        } else {
                                result.add(pre);
                                pre = cur;
                        }
                }
                result.add(pre);
                return result;
        }
}

class newComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
        }
}

class Interval {
        public int start;
        public int end;

        Interval() {
                start = 0;
                end = 0;
        }

        Interval(int s, int e) {
                start = s;
                end = e;
        }
}
