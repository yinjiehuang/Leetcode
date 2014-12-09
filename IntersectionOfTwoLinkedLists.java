// Leetcode: Intersection of Two Linked Lists
// Author: Yinjie Huang
// Date: 12/07/2014
//
import java.util.*;

public class IntersectionOfTwoLinkedLists {
        public static void main(String[] args) {
                System.out.println("Leetcode: Intersection of Two Linked Lists!!!");
                IntersectionOfTwoLinkedLists itll = new IntersectionOfTwoLinkedLists();
                ListNode headA = new ListNode(1);
                ListNode headB = new ListNode(11);
                headA.next = new ListNode(2);
                headB.next = new ListNode(12);
                headB.next.next = new ListNode(13);
                headA.next.next = new ListNode(3);
                headB.next.next.next = headA.next.next;
                System.out.println(itll.getIntersectionNode(headA, headB).val);
        }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                // Counting the two lists, align them to have same start
                if (headA == null || headB == null) {
                        return null;
                }
                int countA = 0, countB = 0;
                ListNode curA = headA, curB = headB;
                while (curA != null || curB != null) {
                        if (curA != null) {
                                countA++;
                                curA = curA.next;
                        }
                        if (curB != null) {
                                countB++;
                                curB = curB.next;
                        }
                }
                // Let curA means short List
                if (countA > countB) {
                        ListNode temp = headA;
                        headA = headB;
                        headB = temp;
                }
                int diff = Math.abs(countA - countB);
                while (diff > 0) {
                        if (headB == headA) {
                                return headB;
                        }
                        headB = headB.next;
                        diff--;
                }
                // We align the list together
                while (headA != null && headB != null) {
                        if (headA == headB) {
                                return headA;
                        }
                        headA = headA.next;
                        headB = headB.next;
                }
                return null;
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
