// Leetcode: Binary Tree Upside Down
// Author: Yinjie Huang
// Date: 12/07/2014
//
import java.util.*;

public class BinaryTreeUpsideDown {
        public static void main(String[] args) {
                System.out.println("Leetcode: Binary Tree Upside Down!!!");
                BinaryTreeUpsideDown btud = new BinaryTreeUpsideDown();
        }

        public TreeNode UpsideDownBinaryTree(TreeNode root) {
                if (root == null) {
                        return root;
                }
                TreeNode cur = root, parent = null, parentRight = null;
                while (cur != null) {
                        TreeNode left = cur.left;
                        cur.left = parentRight;
                        parentRight = cur.right;
                        cur.right = parent;
                        parent = cur;
                        cur = left;
                }
                return parent;
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
