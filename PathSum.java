// Leetcode 112: Path Sum
// Author: Yinjie Huang
// Date: 10/28/2014
//
import java.util.*;

public class PathSum {
        public static void main(String[] args) {
                System.out.println("Leetcode 112: Path Sum!!!");
                PathSum ps = new PathSum();
                //TreeNode root = new TreeNode(5);
                //root.left = new TreeNode(4);
                //root.right = new TreeNode(8);
                //root.left.left = new TreeNode(11);
                //root.left.left.left = new TreeNode(7);
                //root.left.left.right = new TreeNode(2);
                //root.right.left = new TreeNode(13);
                //root.right.right = new TreeNode(4);
                //root.right.right.right = new TreeNode(1);
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                System.out.println(ps.hasPathSum(root, 1));
        }

        public boolean hasPathSum(TreeNode root, int sum) {
                if (root == null) {
                        return false;
                }
                if (root.left == null && root.right == null && root.val == sum) {
                		return true;
                }
                return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
