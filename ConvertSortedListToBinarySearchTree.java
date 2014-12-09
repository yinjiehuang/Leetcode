// Leetcode 109: Converted Sorted List To Binary Search Tree
// Author: Yinjie Huang
// Date: 11/16/2014

import java.util.*;

public class ConvertedSortedListToBinarySearchTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 109: Converted Sorted List To Binary Search Tree!!!");
                ConvertedSortedListToBinarySearchTree csltbst = new ConvertedSortedListToBinarySearchTree();

        }
        
        static ListNode head;
        public TreeNode sortedListToBST(ListNode head) {
                if (head == null) {
                        return null;
                }
                this.head = head;
                int len = 0;
                ListNode current = head;
                while(current != null) {
                        len++;
                        current = current.next;
                }
                return helper(0, len - 1);
        }

        public TreeNode helper(int start, int end) {
                if (start > end) {
                        return null;
                }
                int mid = (start + end) / 2;
                TreeNode left = helper(start, mid - 1);
                TreeNode root = new TreeNode(head.val);
                head = head.next;
                root.left = left;
                root.right = helper(mid + 1, end);
                return root;
        }
}

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
                val = x;
                left = null;
                right = null;
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

