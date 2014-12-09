// Leetcode 092: Reverse Linked List II
// Author: Yinjie Huang
// Date: 11/24/2014
//
import java.util.*;

public class ReverseLinkedListII {
        public static void main(String[] args) {
                System.out.println("Leetcode 091: Reverse Linked List II!!!");
                ReverseLinkedListII rll = new ReverseLinkedListII();
                ListNode head = new ListNode(1);
                int[] array = new int[]{2, 3, 4, 5, 6, 7};
                ListNode cur = head;
                for (int i = 0; i < array.length; i++) {
                        cur.next = new ListNode(array[i]);
                        cur = cur.next;
                }
                // Print the array
                cur = head;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();

                // Do the reverse
                ListNode newhead = rll.reverseBetween(head, 2, 5);
                cur = newhead;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
        }
        
        public ListNode reverseBetween(ListNode head, int m, int n) {
                if (head == null) {
                        return head;
                }
                ListNode newhead = new ListNode(-1);
                newhead.next = head;
                ListNode sp = newhead;
                ListNode node1 = null, node2 = null;
                for (int i = 0; i < n; i++) {
                        if (i < m- 1) {
                                sp = sp.next;
                        } else if (i == m - 1) {
                                node1 = sp.next;
                                node2 = node1.next;
                        } else {
                                node1.next = node2.next;
                                node2.next = sp.next;
                                sp.next = node2;
                                node2 = node1.next;
                        }
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
