// Leetcode: Binary Search Tree Iterator
// Author: Yinjie Huang
// Date: 1/1/2015
//
import java.util.*;

public class BinarySearchTreeIterator {
        public static void main(String[] args) {
                System.out.println("Leetcode: Binary Search Tree Iterator!!!");
                TreeNode root = new TreeNode(7);
                root.left = new TreeNode(5);
                root.right = new TreeNode(9);
                root.right.left = new TreeNode(8);
                root.right.right = new TreeNode(15);
                BSTIterator i = new BSTIterator(root);
                while (i.hasNext()) {
                        System.out.println(i.next());
                }
        }
}

class BSTIterator {
        public Stack<TreeNode> sta = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
                // push into the stack
                TreeNode cur = root;
                while (cur != null) {
                        sta.push(cur);
                        cur = cur.left;
                }
        }

        public boolean hasNext() {
                return !sta.isEmpty();
        }

        public int next() {
                TreeNode cur = sta.pop();
                TreeNode ncur = cur.right;
                while (ncur != null) {
                        sta.push(ncur);
                        ncur = ncur.left;
                }
                return cur.val;
        }
}

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
                val = x;
        }
}
