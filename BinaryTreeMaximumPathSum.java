// Leetcode 124: Binary Tree Maximum Path Sum
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class BinaryTreeMaximumPathSum {
        public static void main(String[] args) {
                System.out.println("Leetcode 124: Binary Tree Maximum Path Sum!!!");
                BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                System.out.println(btmps.maxPathSum(root));
        }

        public int maxPathSum(TreeNode root) {
                if (root == null) {
                        return 0;
                }
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(Integer.MIN_VALUE);
                int res = helper(root, al);
                return al.get(0);
        }

        public int helper(TreeNode root, ArrayList<Integer> al) {
                if (root == null) {
                        return 0;
                }
                int leftint = helper(root.left, al);
                int rightint = helper(root.right, al);
                
                int cur = root.val;
                if (leftint >= 0) {
                        cur += leftint;
                }
                if (rightint >= 0) {
                        cur += rightint;
                }
                if (cur > al.get(0)) {
                        al.set(0, cur);
                }
                return root.val + Math.max(leftint, Math.max(rightint, 0));
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
