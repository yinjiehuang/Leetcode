// Leetcode 100: Same Tree
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class SameTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 100: Same Tree!!!");
                SameTree st = new SameTree();
                TreeNode p = new TreeNode(1);
                p.left = new TreeNode(2);
                p.right = new TreeNode(3);
                TreeNode q = new TreeNode(1);
                q.left = new TreeNode(2);
                q.right = new TreeNode(3);
                System.out.println(st.isSameTree(p, q));
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
                if (p == null && q == null) {
                        return true;
                }
                if (p == null && q != null || p != null && q == null) {
                        return false;
                }
                if (p.val != q.val) {
                        return false;
                }
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
