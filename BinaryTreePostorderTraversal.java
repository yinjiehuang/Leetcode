// Leetcode: Binary Tree Postorder Traversal
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class BinaryTreePostorderTraversal {
        public static void main(String[] args) {
                System.out.println("Leetcode: Binary Tree Postorder Traversal!!!");
                BinaryTreePostorderTraversal btpt = new BinaryTreePostorderTraversal();
                TreeNode root = new TreeNode(1);
                root.right = new TreeNode(2);
                root.right.left = new TreeNode(3);
                ArrayList<Integer> res = btpt.postorderTraversal(root);
                for (Integer i : res) {
                        System.out.print(i + ", ");
                }
                System.out.println();
        }
        
        public ArrayList<Integer> postorderTraversal(TreeNode root) {
                ArrayList<Integer> res = new ArrayList<Integer>();
                if (root == null) {
                        return res;
                }
                Stack<TreeNode> sta = new Stack<TreeNode>();
                HashMap<TreeNode, Boolean> hm = new HashMap<TreeNode, Boolean>();
                sta.push(root);
                hm.put(root, true);
                while (!sta.isEmpty()) {
                        TreeNode cur = sta.peek();
                        if (cur.left != null && !hm.containsKey(cur.left)) {
                        	sta.push(cur.left);
                        	hm.put(cur.left, true);
                        } else if (cur.right != null && !hm.containsKey(cur.right)) {
                        	sta.push(cur.right);
                        	hm.put(cur.right, true);
                        } else if (cur.left == null && cur.right == null || 
                                        hm.containsKey(cur) && 
                                        (cur.left == null || hm.containsKey(cur.left)) && 
                                        (cur.right == null || hm.containsKey(cur.right))) {
                                res.add(cur.val);
                                sta.pop();
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
        }
}
