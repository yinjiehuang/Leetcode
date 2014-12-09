// Leetcode 113: Path Sum II
// Author: Yinjie Huang
// Date: 11/20/2014
//
import java.util.*;

public class PathSumII {
        public static void main(String[] args) {
                System.out.println("Leetcode 113: Path Sum II!!!");
                PathSumII psi = new PathSumII();
                TreeNode root = new TreeNode(5);
                root.left = new TreeNode(4);
                root.right = new TreeNode(8);
                root.left.left = new TreeNode(11);
                root.right.left = new TreeNode(13);
                root.right.right = new TreeNode(4);
                root.left.left.left = new TreeNode(7);
                root.left.left.right = new TreeNode(2);
                root.right.right.left = new TreeNode(5);
                root.right.right.right = new TreeNode(1);
                ArrayList<ArrayList<Integer>> res = psi.pathSum(root, 22);
                for (ArrayList<Integer> al : res) {
                        for (Integer i: al) {
                                System.out.print(i + "->");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
                ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                if (root == null) {
                        return res;
                }
                ArrayList<Integer> al = new ArrayList<Integer>();
                helper(res, al, root, sum);
                return res;
        }

        public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> al, TreeNode root, int sum) {
        		if (root == null) {
        				return;
        		}
                if (root.left == null && root.right == null && root.val == sum) {
                        al.add(root.val);
                        ArrayList<Integer> temp = new ArrayList<Integer>(al);
                        res.add(temp);
                        al.remove(al.size() - 1);
                        return;
                }
                al.add(root.val);
                helper(res, al, root.left, sum - root.val);
                helper(res, al, root.right, sum - root.val);
                al.remove(al.size() - 1);
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
