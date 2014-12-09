// Leetcode 110: Balanced Binary Tree
// Author: Yinjie Huang
// Date: 11/19/2014
//
import java.util.*;

public class BalancedBinaryTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 110: Balanced Binary Tree!!!");
                BalancedBinaryTree bbt = new BalancedBinaryTree();
                TreeNode root = new TreeNode(2);
                root.left = new TreeNode(1);
                root.right = new TreeNode(2);
                System.out.println(bbt.isBalanced(root));
        }

        public boolean isBalanced(TreeNode root) {
                if (root == null) {
                        return true;
                }
                if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
                        return false;
                }
                return isBalanced(root.left) && isBalanced(root.right);
        }

        public int depth(TreeNode root) {
                if (root == null) {
                        return 0;
                }
                return 1 + Math.max(depth(root.left), depth(root.right));
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
