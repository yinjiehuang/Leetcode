// Leetcode: Binary Tree Preorder Traversal
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class BinaryTreePreorderTraversal {
        public static void main(String[] args) {
                System.out.println("Leetcode: Binary Tree Preorder Traversal!!!");
                BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
                TreeNode root = new TreeNode(1);
                root.right = new TreeNode(2);
                root.right.left = new TreeNode(3);
                ArrayList<Integer> res = btpt.preorderTraversal(root);
                for (Integer i : res) {
                        System.out.print(i + ", ");
                }
                System.out.println();
        }

        public ArrayList<Integer> preorderTraversal(TreeNode root) {
                ArrayList<Integer> res = new ArrayList<Integer>();
                if (root == null) {
                        return res;
                }
                Stack<TreeNode> sta = new Stack<TreeNode>();
                sta.push(root);
                while (!sta.isEmpty()) {
                        TreeNode temp = sta.pop();
                        res.add(temp.val);
                        if (temp.right != null) {
                                sta.push(temp.right);
                        }
                        if (temp.left != null) {
                                sta.push(temp.left);
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
        }
}
