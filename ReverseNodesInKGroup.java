// Leetcode 025: Reverse Nodes in k - Group
// Author: Yinjie Huang
// Date: 11/24/2014
//
import java.util.*;

public class ReverseNodesInKGroup {
        public static void main(String[] args) {
                System.out.println("Leetcode 025: Reverse Nodes in k-Group!!!");
                ReverseNodesInKGroup rnik = new ReverseNodesInKGroup();
                ListNode head = new ListNode(1);
                int[] array = new int[]{2, 3, 4, 5, 6, 7, 8};
                ListNode cur = head;
                for (int i = 0; i < array.length; i++) {
                        cur.next = new ListNode(array[i]);
                        cur = cur.next;
                }
                cur = head;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
                ListNode newhead = rnik.reverseKGroup(head, 3);
                cur = newhead;
                 while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
        }

        public ListNode reverseKGroup(ListNode head, int k) {
                if (head == null || k == 1) {
                        return head;
                }
                ListNode newhead = new ListNode(-1);
                newhead.next = head;
                ListNode sp = newhead, cur = head;
                ListNode node1 = null, node2 = null;
                while (true) {
                        int index = 0;
                        while (cur != null && index < k) {
                                cur = cur.next;
                                index++;
                        }
                        if (cur == null && index != k) {
                                break;
                        }
                        node1 = sp.next;
                        node2 = node1.next;
                        index = 0;
                        while (index < k - 1) {
                                node1.next = node2.next;
                                node2.next = sp.next;
                                sp.next = node2;
                                node2 = node1.next;
                                index++;
                        }
                        sp = node1;
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
