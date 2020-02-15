using System;
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    // ListNode打印方法
    public void Print(){
        var node = this;
        Console.Write("[");
        while(node!=null){
            Console.Write(node.val);
            node = node.next;
            if(node!=null) Console.Write(", ");
        }
        Console.Write("]\n");
    }
}

public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2, int more=0) {
        if(l1!=null || l2!=null){
            var sum = (l1!=null?l1.val:0)+(l2!=null?l2.val:0)+more;
            var Lh = new ListNode(sum%10);
            more = 0;
            if(sum>9) more = 1;
            Lh.next = this.AddTwoNumbers(l1==null?null:l1.next, l2==null?null:l2.next, more);
            return Lh;
        } else {
            if(more==1) return new ListNode(1);
            else return null;
        }
    }
    static void Main(string[] args) {
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
        var result = new Solution().AddTwoNumbers(list1,list2);
        result.Print();
    }
}
