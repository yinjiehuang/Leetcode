// Leetcode 002: Add Two Numbers
// Author: Yinjie Huang
// Date: 10/16/2014
//
import java.util.*;

public class AddTwoNumbers {
        public static void main(String[] args) {
                System.out.println("Leetcode 002: Add Two Numbers!!!");
                AddTwoNumbers atn = new AddTwoNumbers();
                ListNode l1 = new ListNode(2);
                l1.next = new ListNode(4);
                l1.next.next = new ListNode(3);

                ListNode l2 = new ListNode(5);
                l2.next = new ListNode(6);
                l2.next.next = new ListNode(4);

                ListNode l3 = atn.addTwoNumbers(l1,l2);
                ListNode l = l3;
                while (l != null) {
                        System.out.print(l.val);
                        l = l.next;
                }
                System.out.println();
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                if (l1 == null) {
                        return l2;
                }
                if (l2 == null) {
                        return l1;
                }
                ListNode p1 = l1;
                ListNode p2 = l2;
                ListNode l3 = new ListNode(0);
                ListNode p3 = l3;
                int carry = 0;
                while (p1 != null || p2 != null) {
                        if (p1 != null) {
                                carry += p1.val;
                                p1 = p1.next;
                        }

                        if (p2 != null) {
                                carry += p2.val;
                                p2 = p2.next;
                        }
                        p3.next = new ListNode(carry % 10);
                        carry /= 10;
                        p3 = p3.next;
                }
                if (carry == 1) {
                	p3.next = new ListNode(1);
                }
                return l3.next;
        }
}

class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
                val = x;
                next = null;
        }
}
