// Leetcode: Unique Binary Search Trees II
// Author: Yinjie Huang
// Date: 12/03/2014
//
import java.util.*;

public class UniqueBinarySearchTreesII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Unique Binary Search Trees II!!!");
                UniqueBinarySearchTreesII ubst = new UniqueBinarySearchTreesII();
                ArrayList<TreeNode> res = ubst.generateTrees(3);
        }

        public ArrayList<TreeNode> generateTrees(int n) {
                return helper(1, n);
        }

        public ArrayList<TreeNode> helper(int left, int right) {
                ArrayList<TreeNode> res = new ArrayList<TreeNode>();
                if (left > right) {
                        res.add(null);
                        return res;
                }
                for (int i = left; i <= right; i++) {
                        ArrayList<TreeNode> leftlist = helper(left, i - 1);
                        ArrayList<TreeNode> rightlist = helper(i + 1, right);
                        for (int l = 0; l < leftlist.size(); l++) {
                                for (int r = 0; r < rightlist.size(); r++) {
                                        TreeNode root = new TreeNode(i);
                                        root.left = leftlist.get(l);
                                        root.right = rightlist.get(r);
                                        res.add(root);
                                }
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
