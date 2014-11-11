// Leetcode 106: Construct Binary Tree from Inorder and Postorder Traversal
// Author: Yinjie Huang
// Date: 11/05/2014
//
import java.util.*;

public class ConstructBSTInPost {
        public static void main(String[] args) {
                System.out.println("Leetcode 106: Construct Binary Tree from Inorder and Postorder Traversal!!!");
                ConstructBSTInPost cbip = new ConstructBSTInPost();
                int[] in = new int[]{1, 2, 3, 5, 7, 8, 6, 9};
                int[] post = new int[]{1, 3, 2, 7, 6, 9, 8, 5};
                TreeNode root = cbip.buildTree(in, post);
                cbip.print(root);
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
                int len1 = inorder.length;
                int len2 = postorder.length;
                if (len1 != len2) {
                        return null;
                }
                if (len1 == 0 && len2 == 0) {
                        return null;
                }
                TreeNode root = helper(inorder, 0, len1 - 1, postorder, 0, len2 - 1);
                return root;
        }

        public TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
                if (is > ie || ps > pe) {
                        return null;
                }
                TreeNode root = new TreeNode(postorder[pe]);
                int index = 0;
                for (int i = is; i <= ie; i++) {
                        if (inorder[i] == postorder[pe]) {
                                index = i;
                                break;
                        }
                }
                int len = index - is;
                root.left = helper(inorder, is, index - 1, postorder, ps, ps + len - 1);
                root.right = helper(inorder, index + 1, ie, postorder, ps + len, pe - 1);
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
