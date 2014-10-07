// Leetcode: Merge Two Sorted Lists
// Author: Yinjie Huang
// Data: 10/06/2014
//
import java.util.*;

public class MergeTwoSortedLists {
        public static void main(String[] args) {
                System.out.println("Leetcode: Merge Two Sorted Lists!!");
                int[] a1 = new int[]{1,4,7,9,10,15,16};
                int[] a2 = new int[]{2,3,6,8,11};
                ListNode temp1 = new ListNode(0);
                ListNode l1 = temp1;
                ListNode temp2 = new ListNode(0);
                ListNode l2 = temp2;

                for (int i = 1; i < a1.length; i++) {
                        temp1.next = new ListNode(a1[i]);
                        temp1 = temp1.next;
                }
                l1 = l1.next;

                for (int j = 1; j < a2.length; j++) {
                        temp2.next = new ListNode(a2[j]);
                        temp2 = temp2.next;
                }
                l2 = l2.next;

                ListNode l3 = null;
                ListNode l4 = null;

                MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
                // Testcase 1
                ListNode l = mtsl.mergeTwoLists(l1, l2);
                System.out.println("Test case 1: ");
                while (l != null) {
                        System.out.print(l.val + ",");
                        l = l.next;
                }
                System.out.println();

                // Testcase 2
                ListNode ll = mtsl.mergeTwoLists(l1, l3);
                System.out.println("Test case 2: ");
                while (ll != null) {
                        System.out.print(ll.val + ",");
                        ll = ll.next;
                }
                System.out.println();
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                if (l1 == null && l2 == null) {
                        return null;
                }
                if (l1 == null) {
                        return l2;
                }
                if (l2 == null) {
                        return l1;
                }
                ListNode l = new ListNode(-500);
                ListNode temp = l;
                while (l1!= null && l2!= null) {
                        if (l1.val <= l2.val) {
                                temp.next = new ListNode(l1.val);
                                l1 = l1.next;
                        } else {
                                temp.next = new ListNode(l2.val);
                                l2 = l2.next;
                        }
                        temp = temp.next;
                }
                if (l1 == null) {
                        temp.next = l2;
                }
                if (l2 == null) {
                        temp.next = l1;
                }
                return l.next;
        }
}

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
                this.val = x;
                this.next = null;
        }
}
