// Leetcode: Clone Graph
// Author: Yinjie Huang
// Date: 12/04/2014

import java.util.*;

public class CloneGraph {
        public static void main(String[] args) {
                System.out.println("Leetcode: Clone Graph!!!");
                CloneGraph cg = new CloneGraph();
        }

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
                if (node == null) {
                        return node;
                }
                // we use BFS
                // We also need a HashMap to link the nodes of two graphs
                LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
                UndirectedGraphNode nnode = new UndirectedGraphNode(node.label);
                queue.add(node);
                hm.put(node, nnode);
                while (!queue.isEmpty()) {
                        UndirectedGraphNode curnode = queue.poll();
                        for (UndirectedGraphNode nei : curnode.neighbors) {
                                if (!hm.containsKey(nei)) {
                                        queue.add(nei);
                                        UndirectedGraphNode nnei = new UndirectedGraphNode(nei.label);
                                        hm.put(nei, nnei);
                                }
                                hm.get(curnode).neighbors.add(hm.get(nei));
                        }
                }
                return nnode;
        }
}

class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
                label = x;
                neighbors = new ArrayList<UndirectedGraphNode>();
        }
}
