// Leetcode: Copy List with Random Pointer
// Author: Yinjie Huang
// Date: 12/05/2014
//
import java.util.*;

public class CopyListWithRandomPointer {
        public static void main(String[] args) {
                System.out.println("Leetcode: Copy List With Random Pointer!!!");
                CopyListWithRandomPointer clrp = new CopyListWithRandomPointer();
        }

        public RandomListNode copyRandomList(RandomListNode head) {
                // Thought, first go over the list and establish the HashMap, second pass copy the random
                if (head == null) {
                        return null;
                }
                HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
                RandomListNode nhead = new RandomListNode(head.label);
                hm.put(head, nhead);
                RandomListNode cur = head.next;
                RandomListNode ncur = nhead;
                while (cur != null) {
                        RandomListNode nnode = new RandomListNode(cur.label);
                        ncur.next = nnode;
                        hm.put(cur, nnode);
                        cur = cur.next;
                        ncur = ncur.next;
                }
                // Now second pass, we need to copy the random information
                cur = head;
                ncur = nhead;
                while (cur != null) {
                        ncur.random = hm.get(cur.random);
                        cur = cur.next;
                        ncur = ncur.next;
                }
                return nhead;
        }
}

class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
                this.label = x;
        }
}
