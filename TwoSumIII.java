// Leetcode: Two Sum III
// Author: Yinjie Huang
// Date: 12/25/2014
//
//
public class TwoSum {
    ArrayList<Integer> list = new ArrayList<Integer>();
	public void add(int number) {
	    list.add(number);
	}

	public boolean find(int value) {
	    HashSet<Integer> hs = new HashSet<Integer>();
	    for (int i = 0; i < list.size(); i++) {
	        int num = value - list.get(i);
	        if (hs.contains(num)) {
	            return true;
	        } else {
	            hs.add(list.get(i));
	        }
	    }
	    return false;
	}
}
