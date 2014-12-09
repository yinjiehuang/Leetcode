// Leetcode 101: Symmetric Tree
// Author: Yinjie Huang
// Date: 11/10/2014
//
import java.util.*;

public class SymmetricTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 101: Symmetric Tree!!!");
                SymmetricTree st = new SymmetricTree();
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(2);
                System.out.println(st.isSymmetric(root));
        }

        public boolean isSymmetric(TreeNode root) {
                if (root == null) {
                        return true;
                }
                return compare(root.left, root.right);
        }

        public boolean compare(TreeNode l, TreeNode r) {
                if (l == null && r != null || l != null && r == null) {
                        return false;
                }
                if (l == null && r == null) {
                        return true;
                }
                if (l.val != r.val) {
                        return false;
                }
                return compare(l.right, r.left) && compare(l.left, r.right);
        }

        public boolean isSymmetric_i(TreeNode root) {
                if (root = null) {
                        return true;
                }
                Stack<TreeNode> sl = new Stack<TreeNode>();
                Stack<TreeNode> sr = new Stack<TreeNode>();

                sl.push(root.left);
                sr.push(root.right);
                while(!sl.empty() && !sr.empty()) {
                        TreeNode l = sl.push();
                        TreeNode r = sr.push();
                        if (l == null && r == null) {
                                continue;
                        }
                        if (l == null && r != null || l != null && r == null) {
                                return false;
                        }
                        if (l.val != r.val) {
                                return false;
                        }
                        sl.push(l.right);
                        sl.push(l.left);
                        sr.push(r.left);
                        sr.push(r.right);
                }
                if (!sr.empty()) {
                        return false;
                }
                return true;
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
