// Leetcode 108: Convert Sorted Array to Binary Search Tree
// Author: Yinjie Huang
// Date: 10/29/2014
//
import java.util.*;

public class ConvertSortedArrayToBinarySearchTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 108: Convert Sorted Array to Binary Search Tree!!!");
                ConvertSortedArrayToBinarySearchTree csatbst = new ConvertSortedArrayToBinarySearchTree();
                int[] num = new int[]{2,5,7,11,20,13};
                TreeNode result = csatbst.sortedArrayToBST(num);
                System.out.println();
        }

        public TreeNode sortedArrayToBST(int[] num) {
                //Every time we put mid position value as root node
                if (num.length == 0) {
                        return null;
                } 

                if (num.length == 1) {
                        return new TreeNode(num[0]);
                }
                int pos = (0 + num.length) / 2;
                TreeNode root = new TreeNode(num[pos]);
                root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, pos));
                root.right = sortedArrayToBST(Arrays.copyOfRange(num, pos + 1, num.length));
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
