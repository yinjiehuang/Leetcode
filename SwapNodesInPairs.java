// Leetcode 024: Swap Nodes in Pairs
// Author: Yinjie Huang
// Date: 10/11/2014

import java.util.*;

public class SwapNodesInPairs {
        public static void main(String[] args) {
                System.out.println("Leetcode 024: Swap Nodes in Paris!!!");
                int[] array = new int[]{1,2,3,4};
                ListNode head = new ListNode(array[0]);
                ListNode current = head;
                for (int i = 1; i < array.length; i++) {
                        current.next = new ListNode(array[i]);
                        current = current.next;
                }
                // Let's print this ListNode
                current = head;
                while (current != null) {
                        System.out.print(current.val + "->");
                        current = current.next;
                }
                System.out.println();

                SwapNodesInPairs snip = new SwapNodesInPairs();
                ListNode result = snip.swapPairs(head);
                current = result;
                while (current != null) {
                        System.out.print(current.val + "->");
                        current = current.next;
                }
        }

        public ListNode swapPairs(ListNode head) {
                if (head == null) {
                        return null;
                }
                // Set a sentinel node
                ListNode previous = new ListNode(0);
                previous.next = head;
                ListNode result = previous;
                ListNode current = head;
                while (current != null && current.next != null) {
                        ListNode left = current;
                        ListNode right = current.next;
                        previous.next = right;
                        left.next = right.next;
                        right.next = left;
                        current = left.next;
                        previous = left;
                }
                return result.next;
        }
}

class ListNode {
        public int val;
        ListNode next;

        ListNode(int x) {
                this.val = x;
                this.next = null;
        }
}
