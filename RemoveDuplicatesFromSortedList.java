// Leetcode 083: Remove Duplicates From Sorted List
// Author: Yinjie Huang
// Date: 10/24/2014
//
import java.util.*;

public class RemoveDuplicatesFromSortedList {
        public static void main(String[] args) {
                System.out.println("Leetcode 083: Remove Duplicates from Sorted List!!!");
                RemoveDuplicatesFromSortedList rdfsl = new RemoveDuplicatesFromSortedList();
                ListNode head = new ListNode(1);
                int[] a = new int[]{1,2,3,3,4,5,5};
                ListNode current = head;
                for (int i = 0; i < a.length; i++) {
                        current.next = new ListNode(a[i]);
                        current = current.next;
                }
                current = head;
                while (current != null) {
                        System.out.print(current.val + "->");
                        current = current.next;
                }
                System.out.println();
                ListNode result = rdfsl.deleteDuplicates(head);
                current = result;
                while (current != null) {
                    	System.out.print(current.val + "->");
                    	current = current.next;
                }
                System.out.println();
        }

        public ListNode deleteDuplicates(ListNode head) {
                if (head == null || head.next == null) {
                        return head;
                }
                ListNode p = head;
                ListNode q = head.next;
                while (q != null) {
                        if (p.val == q.val) {
                                q = q.next;
                        } else {
                                p.next = q;
                                p = q;
                                q = q.next;
                        }
                }
                p.next = null;
                return head;
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
