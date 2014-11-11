// Leetcode 086: Partition List
// Author: Yinjie Huang
// Date: 11/04/2014
//
import java.util.*;

public class PartitionList {
        public static void main(String[] args) {
                System.out.println("Leetcode 086: Partition List!!!");
                PartitionList pl = new PartitionList();
                int[] array = new int[]{1,4,3,2,5,2};
                ListNode head = new ListNode(1);
                ListNode cur = head;
                for (int i = 1; i < array.length; i++) {
                        cur.next = new ListNode(array[i]);
                        cur = cur.next;
                }
                System.out.println("The original List: ");
                cur = head;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();

                ListNode result = pl.partition(head, 3);
                cur = result;
                System.out.println("After partition!!!");
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
        }

        public ListNode partition(ListNode head, int x) {
                if (head == null) {
                        return null;
                }
                ListNode s = new ListNode(0);
                ListNode l = new ListNode(0);
                ListNode curs = s;
                ListNode curl = l;
                ListNode cur = head;
                while (cur != null) {
                        if (cur.val < x) {
                                curs.next = cur;
                                curs = curs.next;
                        } else {
                                curl.next = cur;
                                curl = curl.next;
                        }
                        cur = cur.next;
                }
                curl.next = null;
                curs.next = l.next;
                return s.next;
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
