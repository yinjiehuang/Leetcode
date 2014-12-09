// Leetcode: Linked List Cycle
// Author: Yinjie Huang
// Date: 12/05/2014
//
import java.util.*;

public class LinkedListCycle {
        public static void main(String[] args) {
                System.out.println("Leetcode: Linked List Cycle!!!");
                LinkedListCycle llc = new LinkedListCycle();
                ListNode head = new ListNode(1);
                head.next = new ListNode(2);
                System.out.println(llc.hasCycle(head));
        }

        public boolean hasCycle(ListNode head) {
                if (head == null) {
                        return false;
                }
                ListNode walker = head;
                ListNode runner = head;
                // walker moves one step ahead, runner moves two steps ahead
                while (walker != null && runner != null) {
                        walker = walker.next;
                        runner = runner.next;
                        if (runner != null) {
                                runner = runner.next;
                        } else {
                                return false;
                        }
                        if (runner != null) {
                                if (walker.val == runner.val) {
                                        return true;
                                }
                        } else {
                                return false;
                        }
                }
                return false;
        }
}

class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
                val = x;
                next = null;
        }
}
