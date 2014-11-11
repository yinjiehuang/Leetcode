// Leetcode 049: Anagrams
// Author: Yinjie Huang
// Date: 10/20/2014

import java.util.*;

public class Anagrams {
        public static void main(String[] args) {
                System.out.println("Leetcode 049: Anagrams!!!");
                String[] jimo = new String[]{"abb", "jimo", "bba", "jiom", "ijmo", "bab"};
                Anagrams a = new Anagrams();
                ArrayList<String> result = a.anagrams(jimo);
                for (String s : result) {
                        System.out.println(s);
                }
        }

        public ArrayList<String> anagrams(String[] strs) {
            if (strs.length == 0 || strs == null) {
                    return null;
            }
            ArrayList<String> al = new ArrayList<String>();
            HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
            for (String s : strs) {
                    char[] c = s.toCharArray();
                    Arrays.sort(c);
                    String temp = new String(c);
                    if (hm.containsKey(temp)) {
                            hm.get(temp).add(s);
                    } else {
                            ArrayList<String> nal = new ArrayList<String>();
                            nal.add(s);
                            hm.put(temp, nal);
                    }
            }
            Iterator<ArrayList<String>> i = hm.values().iterator();
            while (i.hasNext()) {
            		ArrayList<String> item = (ArrayList<String>) i.next();
            		if (item.size() > 1) {
            			al.addAll(item);
            		}
            }
            return al;
    }
}
