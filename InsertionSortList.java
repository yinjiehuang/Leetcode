// Leetcode: Insertion Sort List
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class InsertionSortList {
        public static void main(String[] args) {
                System.out.println("Leetcode: Inertion Sort List!!!");
                InsertionSortList isl = new InsertionSortList();
                ListNode head = new ListNode(2);
                head.next = new ListNode(3);
                head.next.next = new ListNode(5);
                head.next.next.next = new ListNode(1);
                head.next.next.next.next = new ListNode(4);
                ListNode res = isl.insertionSortList(head);
                ListNode cur = res;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
        }

        public ListNode insertionSortList(ListNode head) {
                if (head == null || head.next == null) {
                        return head;
                }
                ListNode cur = head;
                while (cur != null && cur.next != null) {
                        if (cur.val > cur.next.val) { // need to switch
                                ListNode sw = head;
                                ListNode node = cur.next;
                                while (true) {
                                        if (sw == head && sw.val > node.val) { // we need insert the value at the beginning of the list
                                                cur.next = node.next;
                                                node.next = sw;
                                                head = node;
                                                break;
                                        } else if (sw.val <= node.val && node.val <= sw.next.val) { // we need to switch node to sw.next
                                                cur.next = node.next;
                                                node.next = sw.next;
                                                sw.next = node;
                                                break;
                                        } else {
                                                sw = sw.next;
                                        }
                                }
                        } else {
                                cur = cur.next;
                        }
                }
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
