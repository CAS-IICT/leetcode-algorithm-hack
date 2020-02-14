/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
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
}
