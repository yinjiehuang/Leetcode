// Leetcode 102: Binary Tree Level Order Traversal
// Author: Yinjie Huang
// Date: 10/22/2014
//
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
        public static void main(String[] args) {
                System.out.println("Leetcode 102: Binary Tree Level Order Traversal!!!");
                BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();
                TreeNode root = new TreeNode(3);
                root.left = new TreeNode(9);
                root.right = new TreeNode(20);
                root.right.left = new TreeNode(15);
                root.right.right = new TreeNode(7);

                ArrayList<ArrayList<Integer>> result = btlot.levelOrder(root);
                for (ArrayList<Integer> al : result) {
                        for (int i : al) {
                                System.out.print(i + " ");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {// BFS
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                if (root == null) {
                        return result;
                }
                helper(root, result, 1);
                return result;
        }

        private void helper(TreeNode node, ArrayList<ArrayList<Integer>> result, int depth) {
                if (node == null) {
                        return;
                }
                if (result.size() >= depth) {
                        result.get(depth - 1).add(node.val);
                } else {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(node.val);
                        result.add(depth - 1, temp);
                }
                helper(node.left, result, depth + 1);
                helper(node.right, result, depth + 1);
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
