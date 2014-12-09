// Leetcode: Reorder List
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class ReorderList {
        public static void main(String[] args) {
                System.out.println("Leetcode: Reorder List!!!");
                ReorderList rl = new ReorderList();
                ListNode head = new ListNode(1);
                head.next = new ListNode(2);
                head.next.next = new ListNode(3);
                head.next.next.next = new ListNode(4);
                rl.reorderList(head);
                ListNode cur = head;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
        }

        public void reorderList(ListNode head) {
        // Three step, 1. find middle point, 2. reverse second, 3. merge
                if (head == null) {
                        return;
                }
                ListNode walker = head, runner = head;
                while (runner.next != null && runner.next.next != null) {
                        walker = walker.next;
                        runner = runner.next.next;
                }
                // Reverse the second
                ListNode head2 = reverse(walker.next);
                walker.next = null;
                // Merge two lists
                ListNode cur1 = head;
                ListNode cur2 = head2;
                while (cur2 != null) {
                        ListNode temp = cur2.next;
                        cur2.next = cur1.next;
                        cur1.next = cur2;
                        cur1 = cur2.next;
                        cur2 = temp;
                }
        }

        public ListNode reverse(ListNode head) {
                if (head == null || head.next == null) {
                        return head;
                }
                ListNode nhead = new ListNode(-1);
                nhead.next = head;
                ListNode cur = head;
                while (cur != null && cur.next != null) {
                        ListNode n = cur.next;
                        cur.next = n.next;
                        n.next = nhead.next;
                        nhead.next = n;
                }
                return nhead.next;
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
