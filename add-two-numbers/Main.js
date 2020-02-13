/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let more = arguments[2] || 0 // 进位
    let lh = null
    if(l1 || l2){
        let sum = (l1?l1.val:0)+(l2?l2.val:0) + more
        lh = new ListNode(sum%10)
        sum>9?more=1:more=0
        lh.next = addTwoNumbers(l1&&l1.next,l2&&l2.next,more)
    } else {
        if(more) lh = new ListNode(1)
    }
    return lh
}
