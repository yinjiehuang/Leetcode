// Leetcode 116: Populating Next Right Pointers in Each Node
// Author: Yinjie Huang
// Date: 11/06/2014
//
import java.util.*;

public class PopulatingNextRightPointersInEachNode {
        public static void main(String[] args) {
                System.out.println("Leetcode 116: Populating Next Right Pointers in Each Node!!!!");
                PopulatingNextRightPointersInEachNode pnrpien = new PopulatingNextRightPointersInEachNode();
                TreeLinkNode root = new TreeLinkNode(1);
                root.left = new TreeLinkNode(2);
                root.right = new TreeLinkNode(3);
                pnrpien.connect(root);
                pnrpien.print(root);
        }

        public void connect(TreeLinkNode root) {
                if (root == null) {
                        return;
                }
                if (root.left != null && root.right != null) {
                        root.left.next = root.right;
                }
                if (root.next != null && root.right != null) {
                        root.right.next = root.next.left;
                }
                connect(root.left);
                connect(root.right);
        }

        public void print(TreeLinkNode root) {
                if (root == null) {
                        return;
                }
                if (root.next != null) {
                        System.out.println(root.val + ". Next is :" + root.next.val);
                } else {
                        System.out.println(root.val + " No next.");
                }
                print(root.left);
                print(root.right);
        }
}

class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
                val = x;
        }
}
