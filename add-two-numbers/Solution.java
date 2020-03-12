class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    void print() {
        var node = this;
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null)
                System.out.print(", ");
        }
        System.out.print("]\n");
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int... m) {
        int more = m.length > 0 ? m[0] : 0;
        if (l1 != null || l2 != null) {
            var sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + more;
            var Lh = new ListNode(sum % 10);
            more = 0;
            if (sum > 9)
                more = 1;
            Lh.next = this.addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, more);
            return Lh;
        } else {
            if (more == 1)
                return new ListNode(1);
            else
                return null;
        }
    }

    public static void main(String args[]) {
        // list1
        var list1 = new ListNode(2);
        var node = new ListNode(4);
        node.next = new ListNode(3);
        list1.next = node;

        // list2
        var list2 = new ListNode(5);
        node = new ListNode(6);
        node.next = new ListNode(4);
        list2.next = node;
        var result = new Solution().addTwoNumbers(list1, list2);
        result.print();
    }
}
