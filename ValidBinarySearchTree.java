// Leetcode 098: Valid Binary Search Tree
// Author: Yinjie Huang
// Data: 10/09/2014
//
public class ValidBinarySearchTree {
        public static void main(String[] args) {
                System.out.println("Leetcode 098: Valid Binary Search Tree!!!");
                ValidBinarySearchTree vbst = new ValidBinarySearchTree();
                TreeNode tn = new TreeNode(9);
                tn.insertBST(tn, 4);
                tn.insertBST(tn, 5);
                tn.insertBST(tn, 10);
                tn.insertBST(tn, 1);
                tn.insertBST(tn, 2);

                System.out.println("Is the binary search tree valid? " + vbst.isValidBST(tn));
        }

        public boolean isValidBST(TreeNode root) {
                return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public boolean valid(TreeNode root, int min, int max) {
                if (root == null) {
                        return true;
                }

                if (root.val <= min || root.val >= max) {
                        return false;
                }

                return valid(root.left, min, root.val) && valid(root.right, root.val, max);
        }
}

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
                this.val = val;
                this.left = null;
                this.right = null;
        }

        public TreeNode insertBST(TreeNode root, int n) {
                if (root == null) {
                       return new TreeNode(n);
                }

                if (root.val > n) {
                        root.left = insertBST(root.left, n);
                } else {
                        root.right = insertBST(root.right, n);
                }
                return root;
        }
}
