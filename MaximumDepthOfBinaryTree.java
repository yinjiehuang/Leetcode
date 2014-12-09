// Leetcode 104: Maximum Depth of Binary Tree
// Author: Yinjie Huang
// Date: 12/01/2014
import java.util.*;

public class MaximumDepthOfBinaryTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 104: Maximum Depth of Binary Tree!!");
                MaximumDepthOfBinaryTree mdbt = new MaximumDepthOfBinaryTree();
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(1);
                System.out.println(mdbt.maxDepth(root));
        }

        public int maxDepth(TreeNode root) {
                if (root == null) {
                        return 0;
                }
                return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
}

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
                val = x;
        }
}
