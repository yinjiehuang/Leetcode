// Leetcode: LRU Cache
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class LRUCache {
        public static void main(String[] args) {
                System.out.println("Leetcode: LRUCache!!!");
                LRUCache lruc = new LRUCache();
        }

        private HashMap<Integer, DoubleLinkedList> hm = new HashMap<Integer, DoubleLinkedList>();
        private DoubleLinkedList head, end;
        private int capacity;
        private int len;

        public LRUCache(int capacity) {
                this.capacity = capacity;
                len = 0;
        }

        public int get(int key) {
                if (hm.containsKey(key)) {
                        DoubleLinkedList node = hm.get(key);
                        removeNode(node);
                        setHead(node);
                        return node.val;
                } else {
                        return -1;
                }
        }

        public void set(int key, int value) {
                if (hm.containsKey(key)) {
                        DoubleLinkedList node = hm.get(key);
                        node.val = value;
                        removeNode(node);
                        setHead(node);
                } else {
                        DoubleLinkedList newnode = new DoubleLinkedList(key, value);
                        if (len < capacity) {
                                setHead(newnode);
                                hm.put(key, newnode);
                                len++;
                        } else {
                                hm.remove(end.key);
                                end = end.pre;
                                if (end != null) {
                                        end.next = null;
                                }
                                setHead(newnode);
                                hm.put(key, newnode);
                        }
                }
        }

        public void removeNode(DoubleLinkedList node) {
                DoubleLinkedList cur = node;
                DoubleLinkedList pre = cur.pre;
                DoubleLinkedList post = cur.next;

                if (pre != null) {
                        pre.next = post;
                } else {
                        head = post;
                }

                if (post != null) {
                        post.pre = pre;
                } else {
                        end = pre;
                }
        }

        public void setHead(DoubleLinkedList node) {
                node.next = head;
                node.pre = null;

                if (head != null) {
                        head.pre = node;
                }
                head = node;
                // For initialization
                if (end == null) {
                        end = node;
                }
        }
}

class DoubleLinkedList {
        int val;
        int key;
        DoubleLinkedList pre;
        DoubleLinkedList next;

        DoubleLinkedList(int key, int x) {
                this.key = key;
                val = x;
        }
}
