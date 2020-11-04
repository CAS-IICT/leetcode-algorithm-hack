class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // myidea : 采用递归 比较当前传入的节点是否相同，如果相同，就继续递归遍历其右子树与左子树
        // 递归出口：如果传入的两个节点均不存在，则返回true，若其中一个为空，另外一个不为空，则返回false
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        // 两者皆不为空，递归判断两者的左子树与两者的右子树
        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
    }
}
