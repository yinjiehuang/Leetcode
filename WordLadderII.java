// Leetcode: Word Ladder II
// Author: Yinjie Huang
// Date: 12/02/2014
//
import java.util.*;

public class WordLadderII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Word Ladder II!!!");
                WordLadderII wdii = new WordLadderII();
                String start = "hit";
                String end = "cog";
                HashSet<String> dict = new HashSet<String>();
                dict.add("hot");
                dict.add("dot");
                dict.add("dog");
                dict.add("lot");
                dict.add("log");
                ArrayList<ArrayList<String>> res = wdii.findLadders(start, end, dict);
                for (ArrayList<String> al : res) {
                        for (String s : al) {
                                System.out.print(s + "->");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {  
                HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();    
                dict.add(start);  
                dict.add(end);  
          
                // init adjacent graph          
                for(String str : dict){  
                        calcNeighbours(neighbours, str, dict);  
                }  
          
                ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();  
          
                // BFS search queue  
                LinkedList<Node> queue = new LinkedList<Node>();  
                queue.add(new Node(null, start, 1)); //the root has not parent and its level == 1 
          
                // BFS level  
                int previousLevel = 0;  
          
                // mark which nodes have been visited, to break infinite loop  
                HashMap<String, Integer> visited = new HashMap<String, Integer>();   
                while(!queue.isEmpty()){  
                 Node n = queue.pollFirst();              
                if(end.equals(n.str)){   
                        // fine one path, check its length, if longer than previous path it's valid  
                        // otherwise all possible short path have been found, should stop  
                        if(previousLevel == 0 || n.level == previousLevel){  
                                previousLevel = n.level;  
                                findPath(n, result);                      
                        }else {  
                                // all path with length *previousLevel* have been found  
                                break;  
                        }                  
                 }else {  
                         HashSet<String> set = neighbours.get(n.str);                   
                  
                        if(set == null || set.isEmpty()) continue;  
                        // note: I'm not using simple for(String s: set) here. This is to avoid hashset's  
                        // current modification exception.  
                        ArrayList<String> toRemove = new ArrayList<String>();  
                        for (String s : set) {
                                if(visited.containsKey(s)){  
                                        Integer occurLevel = visited.get(s);  
                                        if(n.level+1 > occurLevel){  
                                                neighbours.get(s).remove(n.str);  
                                                toRemove.add(s);  
                                                continue;  
                                        }  
                                }  
                                visited.put(s,  n.level+1);  
                                queue.add(new Node(n, s, n.level + 1));  
                                if(neighbours.containsKey(s))  
                                neighbours.get(s).remove(n.str);  
                        }  
                        for(String s: toRemove){  
                                set.remove(s);  
                        }  
                }  
        }  
  
        return result;  
    }  
      
    public void findPath(Node n, ArrayList<ArrayList<String>> result){
                ArrayList<String> path = new ArrayList<String>();  
                Node p = n;  
                while(p != null) {  
                        path.add(0, p.str);  
                        p = p.parent;   
                }  
                result.add(path);  
    }  
    
    void calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict) {  
                int length = str.length();
                char [] chars = str.toCharArray();  
                for (int i = 0; i < length; i++) {    
                        char old = chars[i];   
                        for (char c = 'a'; c <= 'z'; c++) {   
                                if (c == old) {
                                        continue;
                                }
                                chars[i] = c;  
                                String newstr = new String(chars);                  
                  
                                if (dict.contains(newstr)) {  
                                        HashSet<String> set = neighbours.get(str);  
                                        if (set != null) {  
                                                set.add(newstr);  
                                        } else {  
                                                HashSet<String> newset = new HashSet<String>();  
                                                newset.add(newstr);  
                                                neighbours.put(str, newset);  
                                        }  
                                }                  
                        }  
                        chars[i] = old;  
                }  
    }  
      
    private class Node {  
                public Node parent;  //previous node
                public String str;  
                public int level;  
                public Node(Node p, String s, int l) {  
                        parent = p;  
                        str = s;  
                        level = l;  
                }  
        }
}
