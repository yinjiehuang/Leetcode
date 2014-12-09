// Leetcode: Binary Tree Level Order Traversal II
// Author: Yinjie Huang
// Date: 12/03/2014
//
import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Binary Tree Level Order Traversal II!!!");
                BinaryTreeLevelOrderTraversalII btlot = new BinaryTreeLevelOrderTraversalII();
                TreeNode root = new TreeNode(3);
                root.left = new TreeNode(9);
                root.right = new TreeNode(20);
                root.right.left = new TreeNode(15);
                root.right.right = new TreeNode(7);

                ArrayList<ArrayList<Integer>> res = btlot.levelOrderBottom(root);
                for (ArrayList<Integer> al : res) {
                        for (Integer i : al) {
                                System.out.print(i + ", ");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
                ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                if (root == null) {
                        return res;
                }
                helper(root, res, 0);
                Collections.reverse(res);
                return res;
        }

        public void helper(TreeNode root, ArrayList<ArrayList<Integer>> res, int depth) {
                if (root == null) {
                        return;
                }
                if (res != null && res.size() > depth) {
                        res.get(depth).add(root.val);
                } else {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(root.val);
                        res.add(temp);
                }
                helper(root.left, res, depth + 1);
                helper(root.right, res, depth + 1);
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
