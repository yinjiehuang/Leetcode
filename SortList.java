// Leetcode: Sort List
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class SortList {
        public static void main(String[] args) {
                System.out.println("Leetcode: Sort List!!!");
                SortList sl = new SortList();
                ListNode head = new ListNode(2);
                head.next = new ListNode(3);
                head.next.next = new ListNode(5);
                head.next.next.next = new ListNode(1);
                head.next.next.next.next = new ListNode(4);
                ListNode res = sl.sortList(head);
                ListNode cur = res;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();

        }

        public ListNode sortList(ListNode head) {
                // Merge sort
                if (head == null || head.next == null) {
                        return head;
                }
                ListNode walker = head, runner = head;
                while (runner.next != null && runner.next.next != null) {
                        walker = walker.next;
                        runner = runner.next.next;
                }
                // Here walker is the middle point
                ListNode left = head;
                ListNode right = walker.next;
                walker.next = null;
                
                ListNode leftlist = sortList(left);
                ListNode rightlist = sortList(right);

                return mergeList(leftlist, rightlist);
        }

        public ListNode mergeList(ListNode left, ListNode right) {
                if (left == null) {
                        return right;
                }
                if (right == null) {
                        return left;
                }
                ListNode head = new ListNode(-1);
                ListNode cur = head;
                while (left != null && right != null) {
                        if (left.val <= right.val) {
                                cur.next = left;
                                left = left.next;
                        } else {
                                cur.next = right;
                                right = right.next;
                        }
                        cur = cur.next;
                }
                if (left == null) {
                        cur.next = right;
                }
                if (right == null) {
                        cur.next = left;
                }
                return head.next;
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
