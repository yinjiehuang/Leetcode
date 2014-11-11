// Leetcode 082: Remove Duplicates From Sorted List II
// Author: Yinjie Huang
// Date: 11/04/2014

import java.util.*;

public class RemoveDuplicatesFromSortedListII {
        public static void main(String[] args) {
                System.out.println("Leetcode 082: Remove Duplicates From Sorted List II!!!");
                RemoveDuplicatesFromSortedListII rdfsl = new RemoveDuplicatesFromSortedListII();
                ListNode head = new ListNode(1);
                head.next = new ListNode(1);
                head.next.next = new ListNode(1);
                head.next.next.next = new ListNode(2);
                head.next.next.next.next = new ListNode(3);
                ListNode result = rdfsl.deleteDuplicates(head);
                ListNode cur = result;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
        }

        public ListNode deleteDuplicates(ListNode head) {
                if (head == null) {
                        return null;
                }
                ListNode newhead = new ListNode(-1);
                newhead.next = head;
                ListNode pre = newhead;
                ListNode cur = head;
                while (cur != null) {
                        while (cur.next != null && pre.next.val == cur.next.val) {
                                cur = cur.next;
                        }
                        if (pre.next == cur) {
                                pre = pre.next;
                        } else {
                                pre.next = cur.next;
                        }
                        cur = cur.next;
                }
                return newhead.next;
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
