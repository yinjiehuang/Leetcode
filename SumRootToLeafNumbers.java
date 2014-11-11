// Leetcode 129: Sum Root To Leaf Numbers
// Author: Yinjie Huang
// Date: 10/15/2014

import java.util.*;

public class SumRootToLeafNumbers {
        public static void main(String[] args) {
                System.out.println("Leetcode 129: Sum Root to Leaf Numbers!!!");
                SumRootToLeafNumbers srtln = new SumRootToLeafNumbers();
                /*TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);*/
                TreeNode root = new TreeNode(8);
                root.left = new TreeNode(3);
                root.right = new TreeNode(5);
                root.left.right = new TreeNode(9);
                root.left.right.left = new TreeNode(9);
                root.left.right.right = new TreeNode(5);
                System.out.println(srtln.sumNumbers(root));
        }

        public int sumNumbers(TreeNode root) {
                if (root == null) {
                        return 0;
                }
                return sumHelp(root, 0);
        }
        
        public int sumHelp(TreeNode root, int sum) {
        		if (root == null) {
        				return 0;
        		}
        	
        		int res = sum * 10 + root.val;
        		
                if (root.left == null && root.right == null) {
                        return res;
                }
                return sumHelp(root.left, res) + sumHelp(root.right, res);
        }
}

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
                this.val = x;
                this.left = null;
                this.right = null;
        }
}
