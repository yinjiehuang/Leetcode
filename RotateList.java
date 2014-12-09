// Leetcode 061: Rotate List
// Author: Yinjie Huang
// Date: 11/23/2014
//
import java.util.*;

public class RotateList {
        public static void main(String[] args) {
                System.out.println("Leetcode 061: Rotate List!!!");
                RotateList rl = new RotateList();
                ListNode head = new ListNode(1);
                int[] array = new int[]{2, 3, 4, 5};
                ListNode cur = head;
                for (int i = 0; i < 4; i++) {
                        cur.next = new ListNode(array[i]);
                        cur = cur.next;
                }
                // Print the list
                cur = head;
                while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
                ListNode nhead = rl.rotateRight(head, 2);
                cur = nhead;
                 while (cur != null) {
                        System.out.print(cur.val + "->");
                        cur = cur.next;
                }
                System.out.println();
        }
        
        public ListNode rotateRight(ListNode head, int n) {
                if (head == null) {
                        return null;
                }

                // Define a walker and a runner
                ListNode walker = head;
                ListNode runner = head;
                ListNode cur = head;
                
                // First of all, we need to compute the length of the list
                int len = 0;
                while (cur != null) {
                		len++;
                		cur = cur.next;
                }
                
                n = n % len;
                
                // First of all, let the runner move to the nth node
                while (n > 0) { 
                        runner = runner.next;
                        n--;
                }
                
                while (runner.next != null) {
                        walker = walker.next;
                        runner = runner.next;
                }
                runner.next = head;
                head = walker.next;
                walker.next = null;
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
