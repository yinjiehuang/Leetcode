// Leetcode 117: Populating Next Right Pointers in Each Node II
// Author: Yinjie Huang
// Date: 11/30/2014
//
import java.util.*;

public class PopulatingNextRightPointersInEachNodeII {
        public static void main(String[] args) {
                System.out.println("Leetcode 117: Populating Next Right Pointers in Each Node II!!!");
                PopulatingNextRightPointersInEachNodeII pnrpien = new PopulatingNextRightPointersInEachNodeII();
                TreeLinkNode tln = new TreeLinkNode(1);
                tln.left = new TreeLinkNode(2);
                tln.right = new TreeLinkNode(3);
                tln.left.left = new TreeLinkNode(4);
                tln.left.right = new TreeLinkNode(5);
                tln.right.right = new TreeLinkNode(7);
                pnrpien.connect(tln);
                pnrpien.print(tln);
        }

        public void connect(TreeLinkNode root) {
                if (root == null) {
                        return;
                }

                TreeLinkNode p = root.next;
                while (p != null) {
                        if (p.left != null) {
                                p = p.left;
                                break;
                        }
                        if (p.right != null) {
                                p = p.right;
                                break;
                        }
                        p = p.next;
                }

                if (root.right != null) {
                        root.right.next = p;
                }

                if (root.left != null) {
                        if (root.right != null) {
                                root.left.next = root.right;
                        } else {
                                root.left.next = p;
                        }
                }

                connect(root.right);
                connect(root.left);
        }

        public void print(TreeLinkNode root) {
                if (root == null) {
                        return;
                }
                System.out.println("Node val: " + root.val);
                if (root.left != null) {
                        System.out.println("Left Node: " + root.left.val);
                }
                if (root.right != null) {
                        System.out.println("Right Node: " + root.right.val);
                }
                if (root.next != null) {
                        System.out.println("Next Node: " + root.next.val);
                }
                System.out.println("************");
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
