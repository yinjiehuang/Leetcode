// Leetcode 094: Binary Tree Inorder Traversal
// Author: Yinjie Huang
// Date: 11/16/2014
//
import java.util.*;

public class BinaryTreeInorderTraversal {
        public static void main(String[] args) {
                System.out.println("Leetcode 094: Binary Tree Inorder Traversal!!!");
                BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
                TreeNode root = new TreeNode(1);
                root.right = new TreeNode(2);
                root.right.left = new TreeNode(3);
                ArrayList<Integer> res = btit.inorderTraversal(root);
                for (Integer i : res) {
                        System.out.print(i + "->");
                }
                System.out.println();
        }

        public ArrayList<Integer> inorderTraversal(TreeNode root) {
                ArrayList<Integer> res = new ArrayList<Integer>();
                if (root == null) {
                        return res;
                }
                TreeNode current = root;
                Stack<TreeNode> sta = new Stack<TreeNode>();
                while (current != null || !sta.empty()) {
                        if (current != null) {
                                sta.push(current);
                                current = current.left;
                        } else {
                                TreeNode temp = sta.pop();
                                res.add(temp.val);
                                current = temp.right;
                        }
                }
                return res;
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
