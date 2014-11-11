// Leetcode 127: Word Ladder
// Author: Yinjie Huang
// Data: 10/10/2014
//
import java.util.*;

public class WordLadder {
        public static void main(String[] args) {
                System.out.println("Leetcode 127: Word Ladder!!!");
                String start = "hit";
                String end = "cog";
                String[] dict = new String[]{"hot","dot","dog","lot","log"};
                Set<String> s = new HashSet<String>();
                for (String str : dict) {
                        s.add(str);
                }
                WordLadder wl = new WordLadder();
                System.out.println(wl.ladderLength(start, end, s));
        }

         public int ladderLength(String start, String end, Set<String> dict) {
                if (dict.size() == 0) {
                        return 0;
                }
                dict.add(end);
                Queue<String> q = new LinkedList<String>();
                Queue<Integer> len = new LinkedList<Integer>();
                q.add(start);
                len.add(1);
                
                while(!q.isEmpty()) {
                        String word = q.remove();
                        int cur = len.remove();
                        // First of all, we decide if we have the answer
                        if (word.equals(end)) {
                                return cur;
                        }
                        // Construct the neighbor 
                        for (int i = 0; i < word.length(); i++) {
                                char[] array = word.toCharArray();
                                for (char c = 'a'; c <= 'z'; c++) {
                                        if ( c == array[i]) {
                                                continue;
                                        }
                                        array[i] = c;
                                        String temp = new String(array);
                                        if (dict.contains(temp)) {
                                                q.add(temp);
                                                len.add(cur+1);
                                                dict.remove(temp);
                                        }
                                }
                        }
                }
                return 0;
        }
}
