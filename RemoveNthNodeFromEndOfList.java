// Leetcode 019: Remove Nth Node From End of List
// Author: Yinjie Huang
// Date: 10/29/2014
//
import java.util.*;

public class RemoveNthNodeFromEndOfList {
        public static void main(String[] args) {
                System.out.println("Leetcode 019: Remove Nth Node From End of List!!!");
                RemoveNthNodeFromEndOfList rnnfeol = new RemoveNthNodeFromEndOfList();
                ListNode head = new ListNode(1);
                head.next = new ListNode(2);
                head.next.next = new ListNode(3);
                head.next.next.next = new ListNode(4);
                head.next.next.next.next = new ListNode(5);
                ListNode cur = head;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
                ListNode result = rnnfeol.removeNthFromEnd(head, 2);
                cur = result;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {
                if (head == null || head.next == null) {
                        return null;
                }
                ListNode pre = head;
                ListNode cur = head;
                while (n > 0) {
                        cur = cur.next;
                        n--;
                }
                if (cur == null) {
                	head = head.next;
                	return head;
                }
                while (cur.next != null) {
                        pre = pre.next;
                        cur = cur.next;
                }
                pre.next = pre.next.next;
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
