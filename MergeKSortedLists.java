// Leetcode 023: Merge K Sorted Lists
// Author: Yinjie Huang
// Date: 10/17/2014
//
import java.util.*;

public class MergeKSortedLists {
        public static void main(String[] args) {
                System.out.println("Leetcode 023: Merge K Sorted Lists!!!");
                MergeKSortedLists mksl = new MergeKSortedLists();
                // Testcase 1
                ListNode p1 = new ListNode(0);
                p1.next = new ListNode(7);
                p1.next.next = new ListNode(9);

                ListNode p2 = new ListNode(3);
                p2.next = new ListNode(4);
                p2.next.next = new ListNode(11);
                p2.next.next.next = new ListNode(15);

                ListNode p3 = new ListNode(2);
                p3.next = new ListNode(5);

                ArrayList<ListNode> lists = new ArrayList<ListNode>();
                lists.add(p1);
                lists.add(p2);
                lists.add(p3);

                /*ListNode result = mksl.mergeKLists(lists);
                while (result != null) {
                        System.out.print(result.val + "->");
                        result = result.next;
                }
                System.out.println();*/

                ListNode result = mksl.mergeKLists_1(lists);
                while (result != null) {
                        System.out.print(result.val + "->");
                        result = result.next;
                }
                System.out.println();

        }

        // Method 1, use heap, kinda like cheating
        public ListNode mergeKLists(ArrayList<ListNode> lists) {
                if (lists == null || lists.size() == 0) {
                        return null;
                }
                PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
                        public int compare(ListNode l1, ListNode l2) {
                                return l1.val - l2.val;
                        }
                });
                // Insert the elements into the priority queue
                for (int i = 0; i < lists.size(); i++) {
                        ListNode temp = lists.get(i);
                        if (temp != null) {
                                heap.offer(temp);
                        }
                }
                ListNode result = new ListNode(0);
                ListNode p = result;
                while(heap.size() > 0) {
                        ListNode temp = heap.poll();
                        if (temp.next != null) {
                                heap.offer(temp.next);
                        }
                        p.next = temp;
                        p = p.next;                        
                }
                return result.next;
        }

        // Method 2, use divide and conquer
        public ListNode mergeKLists_1(ArrayList<ListNode> lists) {
                if (lists == null || lists.size() == 0) {
                        return null;
                }
                return divide(lists, 0, lists.size() - 1);
        }

        public ListNode divide(ArrayList<ListNode> lists, int left, int right) {
                if (left < right) {
                        int m = (left + right)/2;
                        return merge(divide(lists, left, m), divide(lists, m + 1, right));
                }
                return lists.get(left);
        }

        public ListNode merge(ListNode l1, ListNode l2) {
                if (l1 == null || l2 == null) {
                        return null;
                }
                ListNode result = new ListNode(0);
                ListNode p = result;
                while (l1 != null && l2 != null) {
                        if (l1.val >= l2.val) {
                                p.next = new ListNode(l2.val);
                                l2 = l2.next;
                        } else {
                                p.next = new ListNode(l1.val);
                                l1 = l1.next;
                        }
                        p = p.next;
                }
                if (l1 != null) {
                        p.next = l1;
                }
                if (l2 != null) {
                        p.next = l2;
                }
                return result.next;
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
