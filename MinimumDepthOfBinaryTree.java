// Leetcode 111: Minimum Depth of Binary Tree
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class MinimumDepthOfBinaryTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 111: Minimum Depth of Binary Tree!!");
                MinimumDepthOfBinaryTree mdbt = new MinimumDepthOfBinaryTree();
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                //root.right = new TreeNode(3);
                //root.left.left = new TreeNode(1);
                System.out.println(mdbt.minDepth(root));
        }

        public int minDepth(TreeNode root) {
                if (root == null) {
                        return 0;
                }
                int count = 0;
                if (root.left == null && root.right == null) {
                        count = 1;
                } else if (root.left == null && root.right != null) {
                        count = 1 + minDepth(root.right);
                } else if (root.left != null && root.right == null) {
                        count = 1 + minDepth(root.left);
                } else {
                        count = 1 + Math.min(minDepth(root.left), minDepth(root.right));
                }
                return count;
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
