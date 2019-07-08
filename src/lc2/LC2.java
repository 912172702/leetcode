package lc2;

/**
 * @Author: Knox
 * @Date: 2019-07-08 22:32
 * @Description: You Know
 * @Version 1.0
 */

public class LC2 {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(9), p2 = new ListNode(4), p3 = new ListNode(5), p4 = new ListNode(0), p5 = new ListNode(1);
        ListNode q1 = new ListNode(9), q2 = new ListNode(5), q3 = new ListNode(5);

        p5.next = p4;
        p4.next = p3;
        p3.next = p2;
        p2.next = p1;
        //
        q3.next = q2;
        q2.next = q1;

        ListNode res = new Solution().addTwoNumbers(p5, q3);

        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }

    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode s = l1, l = l2, p = root;
        int t = 0;


        while (l != null && s != null) {
            int sum = l.val + s.val + t;
            int val = sum % 10;
            t = sum / 10;
            p.next = new ListNode(val);
            p = p.next;
            l = l.next;
            s = s.next;
        }
        l = l == null ? s : l;
        while (l != null) {
            int sum = l.val + t;
            int val = sum % 10;
            t = sum / 10;
            p.next = new ListNode(val);
            p = p.next;
            l = l.next;
        }
        //加上t
        if (t != 0) {
            p.next = new ListNode(t);
        }

        return root.next;
    }
}