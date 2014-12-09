// Leetcode 103: Binary Tree Zigzag Level Order Traversal
// Author: Yinjie Huang
// Date: 11/16/2014

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
        public static void main(String[] args) {
                System.out.println("Leetcode 103: Binary Tree Zigzag Level Order Traversal!!!");
                BinaryTreeZigzagLevelOrderTraversal btzlot = new BinaryTreeZigzagLevelOrderTraversal();
                TreeNode root = new TreeNode(3);
                root.left  = new TreeNode(9);
                root.right = new TreeNode(20);
                root.right.left = new TreeNode(15);
                root.right.right = new TreeNode(7);
                ArrayList<ArrayList<Integer>> res = btzlot.zigzagLevelOrder(root);
                for (ArrayList<Integer> al : res) {
                        for (Integer i : al) {
                                System.out.print(i + "-");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
                ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                if (root == null) {
                        return res;
                }
                LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
                queue.add(root);
                int level = 0;
                while(!queue.isEmpty()) {
                        ArrayList<Integer> al = new ArrayList<Integer>();
                        int num = queue.size();
                        for (int i = 0; i < num; i++) {
                                TreeNode temp = queue.pop();
                                al.add(temp.val);

                                if (temp.left != null) {
                                        queue.add(temp.left);
                                }
                                if (temp.right != null) {
                                        queue.add(temp.right);
                                }
                        }
                        if (level % 2 == 1) {
                                Collections.reverse(al);
                        }
                        res.add(al);
                        level++;
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
