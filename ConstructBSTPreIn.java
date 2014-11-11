// Leetcode 105: Construct Binary Tree from Preorder and Inorder Traversal
// Author: Yinjie Huang
// Date: 11/05/2014
//
import java.util.*;

public class ConstructBSTPreIn {
        public static void main(String[] args) {
                System.out.println("Leetcode 105: Construct Binary Tree from Preorder and Inorder Traversal!!!");
                ConstructBSTPreIn cbpi = new ConstructBSTPreIn();
                int[] pre = new int[]{5, 2, 1, 3, 8, 7, 9, 6};
                int[] in = new int[]{1, 2, 3, 5, 7, 8, 6, 9};
                TreeNode root = cbpi.buildTree(pre, in);
                cbpi.print(root);
        }

      public TreeNode buildTree(int[] preorder, int[] inorder) {
                int len1 = preorder.length;
                int len2 = inorder.length;
                if (len1 != len2) {
                        return null;
                }
                if (len1 == 0 && len2 == 0) {
                        return null;
                }
                TreeNode root = helper(preorder, 0, len1 - 1, inorder, 0, len2 - 1);
                return root;
        }
        
        public TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
                if (ps > pe || is > ie) {
                        return null;
                }
                TreeNode root = new TreeNode(preorder[ps]); // This is the node
                int index = 0;
                for (int i = is; i <= ie; i++) {
                        if (inorder[i] == preorder[ps]) {
                                index = i;
                                break;
                        }
                }
                int len = index - is;
                root.left = helper(preorder, 1 + ps, ps + len, inorder, is, index - 1);
                root.right = helper(preorder, ps + len + 1, pe, inorder, index + 1, ie );
                return root;
        }

        void print(TreeNode root) {// preorder print
                if (root == null) {
                        return;
                }
                System.out.print(root.val + "->");
                print(root.left);
                print(root.right);
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
