// Leetcode: Linked List Cycle II
// Author: Yinjie Huang
// Date: 12/05/2014
//
import java.util.*;

public class LinkedListCycleII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Linked List Cycle II!!!");
                LinkedListCycleII llc = new LinkedListCycleII();
                ListNode head = new ListNode(1);
                head.next = new ListNode(2);
        }

        public ListNode detectCycle(ListNode head) {
                if (head == null) {
                        return null;
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
                                return null;
                        }
                        if (runner != null) {
                                if (walker == runner) {
                                        break;
                                }
                        } else {
                                return null;
                        }
                }
                walker = head;
                while (walker != runner) {
                        walker = walker.next;
                        runner = runner.next;
                }
                return walker;
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
