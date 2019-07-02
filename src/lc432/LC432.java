package lc432;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Knox
 * @Date: 2019-03-30 09:38
 * @Description: You Know
 * @Version 1.0
 */

class AllOne {

    private Map<String, Long> data = new HashMap<>();
    private Map<String, Node> orderedLink = new HashMap<>();
    private Node head = null;
    private Node tail = null;


    /**
     * Initialize your data structure here.
     */
    public AllOne() {

    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {

        Long res = data.get(key);
        if (res != null) {
            data.put(key, data.get(key) + 1);
            orderedLink.get(key).value++;
            //重新插入排序
            reorder(orderedLink.get(key), true);


        } else {
            data.put(key, (long) 1);
            //新建节点，头插
            Node node = new Node();
            node.value = (long) 1;
            node.key = key;
            orderedLink.put(key, node);
            if (head == null) {
                head = tail = node;
                //print();
                return;
            }
            node.next = head;
            head.prev = node;
            head = node;
        }
        //print();
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {

        Long val = data.get(key);
        if (val != null) {
            if (val == 1) {
                data.remove(key);
                Node node = orderedLink.get(key);

                Node prev = node.prev;
                Node next = node.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
                if (node == head) {
                    head = next;
                    if (next != null) next.prev = null;
                }
                if (node == tail) {
                    tail = prev;
                    if (prev != null) prev.next = null;
                }
                orderedLink.remove(key);
                node = null; //help gc;

            } else {
                data.put(key, val - 1);
                orderedLink.get(key).value--;
                //重新插入排序
                reorder(orderedLink.get(key), false);

            }
            //print();
        }

    }

    private void reorder(Node node, boolean nextmov) {
        if (nextmov) {
            if (node == tail)
                return;

            Node nnext = node.next;
            Node p = node.next;
            while (p != null && p.value < node.value) p = p.next;
            if (p != null) {
                if (p != node.next) {
                    node.next.prev = node.prev;
                    if (node.prev != null)
                        node.prev.next = node.next;
                    //插入p前面
                    node.prev = p.prev;
                    p.prev.next = node;
                    node.next = p;
                    p.prev = node;
                    if (head == node) {
                        head = nnext;
                    }

                }
            } else {
                node.next.prev = node.prev;
                if (node.prev != null)
                    node.prev.next = node.next;

                tail.next = node;
                // tail.prev = node.prev;
                node.prev = tail;
                node.next = null;
                tail = node;
                if (head == node) {
                    head = nnext;
                }
            }
        } else {
            if (node == head)
                return;


            Node nprev = node.prev;
            Node p = node.prev;
            while (p != null && p.value > node.value) p = p.prev;
            if (p != null) {
                if (p != node.prev) {
                    node.prev.next = node.next;
                    if (node.next != null)
                        node.next.prev = node.prev;
                    //插入p后面
                    node.next = p.next;
                    p.next.prev = node;
                    node.prev = p;
                    p.next = node;
                    if (tail == node) {
                        tail = nprev;
                    }
                }
            } else {
                node.next.prev = node.prev;
                if (node.prev != null)
                    node.prev.next = node.next;
                //头部
                head.prev = node;
                node.next = head;
                head = node;
                node.prev = null;
                if (tail == node) {
                    tail = nprev;
                }
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (tail == null) return "";
        return tail.key;

    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (head == null) return "";
        return head.key;
    }

    final class Node {
        String key = "";
        Long value = (long) 0x0;
        Node next = null;
        Node prev = null;
    }

}


/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
public class LC432 {
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        allOne.getMaxKey();
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        allOne.getMaxKey();

    }
}


/*
["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
[[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]
 */