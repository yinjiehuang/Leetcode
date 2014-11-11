// Leetcode 114: Flatten Binary Tree to Linked List
// Author: Yinjie Huang
// Date: 11/05/2014
//
import java.util.*;

public class FlattenBinaryTreeToLinkedList {
        public static void main(String[] args) {
                System.out.println("Leetcode 114: Flatten Binary Tree to Linked List!!!");
                FlattenBinaryTreeToLinkedList rbttll = new FlattenBinaryTreeToLinkedList();
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(5);
                root.left.left = new TreeNode(3);
                root.left.right = new TreeNode(4);
                root.right.right = new TreeNode(6);
                rbttll.flatten(root);
                while (root != null) {
                        System.out.print(root.val + "->");
                        root = root.right;
                }
        }

       public void flatten(TreeNode root) {
                if (root == null) {
                        return;
                }
                
                if (root.left != null) {
                        TreeNode lt = root.left;
                        TreeNode rt = root.right;
                        root.left = null;
                        root.right = lt;
                        TreeNode temp = lt;
                        while (temp.right!= null) {
                                temp = temp.right;
                        }
                        temp.right = rt;
                }
                flatten(root.right);
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
