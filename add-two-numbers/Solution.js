function ListNode(val) {
    this.val = val
    this.next = null
    this.print=()=>{
        let node = this
        process.stdout.write('[')
        while(node){
            process.stdout.write(node.val+'')
            node = node.next
            if(node) process.stdout.write(', ')
        }
        process.stdout.write(']\n')
    }
}
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

// make l1
let l1 = new ListNode(2)
let node = new ListNode(4)
node.next = new ListNode(3)
l1.next = node

//make l2
let l2 = new ListNode(5)
node = new ListNode(6)
node.next = new ListNode(4)
l2.next = node

let result = addTwoNumbers(l1,l2)
result.print()
