// Leetcode 099: Recover Binary Search Tree
// Author: Yinjie Huang
// Date: 11/29/2014
//
import java.util.*;

public class RecoverBinarySearchTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 099: Recover Binary");
                RecoverBinarySearchTree bbst = new RecoverBinarySearchTree();
                TreeNode root = new TreeNode(4);
                root.left = new TreeNode(7);
                root.right = new TreeNode(6);
                root.left.left = new TreeNode(1);
                root.left.right = new TreeNode(3);
                root.right.left = new TreeNode(5);
                root.right.right = new TreeNode(2);

                bbst.printTree(root);
                System.out.println();
                bbst.recoverTree(root);
                bbst.printTree(root);
                System.out.println();
        }
        TreeNode pre = null, tr1 = null, tr2 = null;

        public void recoverTree(TreeNode root) {
                if (root == null) {
                        return;
                }
                helper(root);
                if (tr1 != null && tr2 != null) {
                        int temp = tr1.val;
                        tr1.val = tr2.val;
                        tr2.val = temp;
                }
        }

        public void helper(TreeNode root) {
                if (root == null) {
                        return;
                }
                helper(root.left);
                if (pre == null) {
                        pre = root;
                } else {
                        if (pre.val > root.val) {
                                if (tr1 == null) {
                                        tr1 = pre;
                                }
                                tr2 = root;
                        }
                        pre = root;
                }
                helper(root.right);
        }

        public void printTree(TreeNode root) {
                if (root == null) {
                        return;
                }
                printTree(root.left);
                System.out.print(root.val + "->");
                printTree(root.right);
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
